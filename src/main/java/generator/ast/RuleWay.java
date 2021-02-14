package generator.ast;

import java.util.*;

public class RuleWay implements GrammarEntry {
    List<Invokation> way;
    String code;

    public RuleWay(List<Invokation> way, String code) {
        this.way = way;
        this.code = code;
    }

    public void deduceRules(Map<String, AbstractRule> rules) {
        for (Invokation invokation : way) {
            invokation.deduceRules(rules);
        }
    }

    public Set<MetaToken> getFirst() {
        Set<MetaToken> result = new HashSet<>();
        boolean toEps = true;
        for (Invokation rule : way) {
            result.addAll(rule.getFirst());
            if (!result.remove(new MetaToken(""))) {
                toEps = false;
                break;
            }
        }
        if (toEps) {
            result.add(new MetaToken(""));
        }
        return result;
    }

    public List<String> print() {
        List<String> result = new ArrayList<>();
        for (Invokation invokation : this.way) {
            result.addAll(invokation.print());
        }
        if (code != null) {
            result.add(code);
        }
        return result;
    }
}
