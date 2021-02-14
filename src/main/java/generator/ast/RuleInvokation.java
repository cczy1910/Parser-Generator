package generator.ast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RuleInvokation extends Invokation {
    private final String name;
    final String alias;
    final String arg;
    Rule rule;

    public RuleInvokation(String name, String alias, String arg) {
        this.name = name;
        this.alias = alias;
        this.arg = arg;
    }


    public void deduceRules(Map<String, AbstractRule> naming) {
        if (naming.get(name) instanceof Rule) {
            this.rule = (Rule) naming.get(name);
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
        String contextName = Character.toUpperCase(this.name.charAt(0)) + this.name.substring(1) + "Context";
        if (arg != null) {
            result.add("children.add(new " + contextName + "(" + arg + ", lexer));");
        } else {
            result.add("children.add(new " + contextName + "(lexer));");
        }
        if (alias != null) {
            result.add(contextName + " " + alias + " = (" + contextName + ") children.get(children.size() - 1);");
        }
        return result;
    }
}
