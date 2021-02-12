package generator.ast;

import java.util.*;

public class Rule extends AbstractRule {
    String argType;
    String valType;
    List<RuleWay> ways;
    private final Set<MetaToken> first = new HashSet<>();
    private final Set<MetaToken> follow = new HashSet<>();

    public Rule(String name, String argType, String valType, List<RuleWay> ways) {
        super(name);
        this.argType = argType;
        this.valType = valType;
        this.ways = ways;
    }

    @Override
    protected void deduceRules(Map<String, AbstractRule> naming) {
        for (RuleWay way : ways) {
            way.deduceRules(naming);
        }
    }

    @Override
    public Set<MetaToken> getFirst() {
        return this.first;
    }

    public Set<MetaToken> getFollow() {
        return this.follow;
    }

    public boolean updateFirst(Set<MetaToken> otherFirst) {
        return this.first.addAll(otherFirst);
    }

    public boolean updateFollow(Set<MetaToken> otherFollow) {
        return this.follow.addAll(otherFollow);
    }

    public List<String> printClass(String grammarName) {
        String contextName = Character.toUpperCase(this.name.charAt(0)) + this.name.substring(1) + "Context";
        String lexerName = grammarName + "Lexer";
        String abstractContextName = "Context";
        List<String> result = new ArrayList<>();
        result.add("public static class " + contextName + " extends " + abstractContextName + " {");
        if (valType != null) {
            result.add("    public " + valType + ";");
        }
        if (argType != null) {
            result.add("    public " + contextName + "(" + argType + ", " + lexerName + " lexer" + ") {");
        } else {
            result.add("    public " + contextName + "(" + lexerName + " lexer" + ") {");
        }
//        result.add("        " + abstractTokenName + " curToken = lexer.nextToken();");
        result.add("        switch(lexer.curToken.type) {");
        RuleWay toEps = null;
        for (RuleWay ruleWay : this.ways) {
            boolean nonEmpty = false;
            for (MetaToken token : ruleWay.getFirst()) {
                if (!token.equals(new MetaToken(""))) {
                    result.add("            case " + token.name + ":");
                    nonEmpty = true;
                } else {
                    toEps = ruleWay;
                }
            }
            if (nonEmpty) {
                result.add("            {");
                for (String l : ruleWay.print()) {
                    result.add("                " + l);
                }
                result.add("                }");
                result.add("                break;");
            }
        }
        if (toEps != null) {
            for (MetaToken token : this.getFollow()) {
                result.add("            case " + token.name + ":");
            }
            result.add("            {");
            for (String l : toEps.print()) {
                result.add("                " + l);
            }
            result.add("            }");
            result.add("                break;");
        }
        result.add("            default:");
        result.add("                throw new RuntimeException(\"Unexpected Token\");");
        result.add("        }");
        result.add("    }");
        result.add("}");
        return result;
    }
}
