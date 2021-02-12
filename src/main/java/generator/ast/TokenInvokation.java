package generator.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TokenInvokation extends Invokation {
    private final String name;
    final String alias;
    MetaToken rule;

    public TokenInvokation(String name, String alias) {
        this.name = name;
        this.alias = alias;
    }


    @Override
    protected void deduceRules(Map<String, AbstractRule> naming) {
        if (naming.get(name) instanceof MetaToken) {
            this.rule = (MetaToken) naming.get(name);
        } else {
            throw new RuntimeException(name + " is not a noterm");
        }
    }

    @Override
    public Set<MetaToken> getFirst() {
        return rule.getFirst();
    }

    @Override
    public List<String> print() {
        List<String> result = new ArrayList<>();
        result.add("if (lexer.curToken.type == TokenType." + this.name.toUpperCase() + ") {");
        result.add("    children.add(lexer.curToken);");
        result.add("    lexer.nextToken();");
        result.add("} else {");
        result.add("    throw new RuntimeException(\"Unexpected Token\" + lexer.curToken.type.toString());");
        result.add("}");
        if (alias != null) {
            result.add("TokenContext " + alias + " = (TokenContext) children.get(children.size() - 1);");
        }
        return result;
    }
}
