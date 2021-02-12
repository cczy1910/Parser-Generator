package generator.ast;

import java.util.*;

public class Grammar {
    public final String name;
    private final String header;
    List<Rule> rules;
    List<MetaToken> metaTokens;
    Map<String, AbstractRule> naming;

    public Grammar(String name, String header, List<Rule> rules, List<MetaToken> metaTokens) {
        this.name = name;
        this.header = header;
        this.rules = rules;
        this.metaTokens = metaTokens;
        this.naming = new HashMap<>();
        for (Rule rule : this.rules) {
            if (naming.put(rule.name, rule) != null) {
                throw new RuntimeException("Rule " + rule.name + " had already been defined");
            }
        }
        for (MetaToken rule : this.metaTokens) {
            if (naming.put(rule.name, rule) != null) {
                throw new RuntimeException("Token " + rule.name + " had already been defined");
            }
        }
    }

    public void deduceRules() {
        for (Rule rule : this.rules) {
            rule.deduceRules(naming);
        }
    }

    public void findFirst() {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (Rule rule : this.rules) {
                for (RuleWay way : rule.ways) {
                    if (rule.updateFirst(way.getFirst())) {
                        changed = true;
                    }
                }
            }
        }
    }

    public void findFollow() {
        rules.get(0).getFollow().add(new MetaToken("EOF"));
        boolean changed = true;
        while (changed) {
            changed = false;
            for (Rule rule : this.rules) {
                for (RuleWay ruleWay : rule.ways) {
                    for (int i = 0; i < ruleWay.way.size(); i++) {
                        if (ruleWay.way.get(i) instanceof RuleInvokation) {
                            RuleInvokation ruleInv = (RuleInvokation) ruleWay.way.get(i);
                            Set<MetaToken> tailFirst = new RuleWay(ruleWay.way.subList(i + 1, ruleWay.way.size()), null).getFirst();
                            if (tailFirst.contains(new MetaToken(""))) {
                                tailFirst.remove(new MetaToken(""));
                                if (ruleInv.rule.updateFollow(rule.getFollow())) {
                                    changed = true;
                                }
                            }
                            if (ruleInv.rule.updateFollow(tailFirst)) {
                                changed = true;
                            }
                        }
                    }
                }
            }
        }
    }

    public void checkLL1() {
        for (Rule rule : this.rules) {
            for (int i = 0; i < rule.ways.size(); i++) {
                for (int j = 0; j < rule.ways.size(); j++) {
                    if (i != j) {
                        for (MetaToken tk : rule.ways.get(i).getFirst()) {
                            if (rule.ways.get(j).getFirst().contains(tk)) {
                                throw new RuntimeException("Grammar is not LL(1) : token " + tk.name +
                                        " is in first for both " + (i + 1) + "th and " + (j + 1) + "th ways for noterm " + rule.name);
                            }
                        }
                    }
                    if (rule.ways.get(i).getFirst().contains(new MetaToken(""))) {
                        for (MetaToken tk : rule.ways.get(j).getFirst()) {
                            if (rule.getFollow().contains(tk)) {
                                throw new RuntimeException("Grammar is not LL(1): token " + tk.name +
                                        " is in first for " + (j + 1) + "th way and in follow for nullable noterm " + rule.name);
                            }
                        }
                    }
                }
            }
        }
    }

    public List<String> printParser() {
        List<String> result = new ArrayList<>();
        result.add(header.substring(1, header.length() - 1));
        result.add("");
        result.add("import java.util.*;");
        result.add("");
        result.add("public class " + name + "Parser {");
        result.add("    " + name + "Lexer lexer;");
        result.add("");
        result.add("    public " + name + "Parser(String input) {");
        result.add("        this.lexer = new " + name + "Lexer(input);");
        result.add("    }");
        result.add("");
        result.add("    public enum TokenType {");
        StringBuilder types = new StringBuilder("       ");
        for (MetaToken metaToken : this.metaTokens) {
            types.append(metaToken.name.toUpperCase());
            types.append(", ");
        }
        types.append("EOF;");
        result.add(types.toString());
        result.add("    }");
        result.add("");
        result.add("    public static abstract class Context {");
        result.add("        public List<Context> children = new ArrayList<>();");
        result.add("");
        result.add("    }");
        result.add("");
        result.add("    public static class TokenContext extends Context{");
        result.add("        public TokenType type;");
        result.add("        public String text;");
        result.add("        ");
        result.add("        public TokenContext(TokenType type, String text) {");
        result.add("            this.type = type;");
        result.add("            this.text = text;");
        result.add("        }");
        result.add("");
        result.add("    }");
        result.add("");
        String parseType = Character.toUpperCase(this.rules.get(0).name.charAt(0)) + this.rules.get(0).name.substring(1) + "Context";
        result.add("    public " + parseType + " parse() {");
        result.add("        return new " + parseType + "(this.lexer);");
        result.add("    }");
        result.add("");
        for (Rule rule : this.rules) {
            for (String l : rule.printClass(name)) {
                result.add("    " + l);
            }
            result.add("");
        }
        for (String l : this.printLexer()) {
            result.add("    " + l);
        }
        result.add("}");
        return result;
    }

    public List<String> printLexer() {
        List<String> result = new ArrayList<>();
        result.add("public static class " + name + "Lexer {");
        result.add("    String input;");
        result.add("    int index = 0;");
        result.add("    TokenContext curToken;");
        result.add("    ");
        result.add("");
        result.add("    public " + name + "Lexer(String input) {");
        result.add("        this.input = input;");
        result.add("        this.nextToken();");
        result.add("    }");
        result.add("");
        result.add("    public TokenContext nextToken() {");
        result.add("        if (this.index == this.input.length()) {");
        result.add("            curToken = new TokenContext(TokenType.EOF, \"\");");
        result.add("            return curToken;");
        result.add("        }");
        result.add("        TokenContext newToken = null;");
        result.add("        int newIndex = -1;");
        for (MetaToken metaToken : this.metaTokens) {
            if (metaToken.skip) {
                result.add("        for (int i = index + 1; i <= this.input.length(); i++) {");
                result.add("            String curSubstring = input.substring(index, i);");
                result.add("            if(curSubstring.matches(\"" + metaToken.regexp + "\")) {");
                result.add("                newIndex = i;");
                result.add("            }");
                result.add("        }");
                result.add("        if (newIndex != -1) {");
                result.add("            index = newIndex;");
                result.add("            return nextToken();");
                result.add("        }");
            } else {
                result.add("        for (int i = index + 1; i <= this.input.length(); i++) {");
                result.add("            String curSubstring = input.substring(index, i);");
                result.add("            if(curSubstring.matches(\"" + metaToken.regexp + "\")) {");
                result.add("                newToken = new TokenContext(TokenType." + metaToken.name.toUpperCase() + ", curSubstring);");
                result.add("                newIndex = i;");
                result.add("            }");
                result.add("        }");
                result.add("        if (newToken != null) {");
                result.add("            index = newIndex;");
                result.add("            curToken = newToken;");
                result.add("            return curToken;");
                result.add("        }");
            }
        }
        result.add("        throw new RuntimeException(\"Input Mismatch\");");
        result.add("    }");
        result.add("}");
        return result;
    }
}
