package generator.ast;

import java.util.Map;
import java.util.Set;

public class MetaToken extends AbstractRule {
    String regexp = "";
    boolean skip = false;

    MetaToken(String name) {
        super(name);
    }

    public MetaToken(String name, String regexp) {
        super(name);
        this.regexp = regexp;
    }

    public MetaToken(String name, String regexp, boolean skip) {
        super(name);
        this.regexp = regexp;
        this.skip = skip;
    }

    public void deduceRules(Map<String, AbstractRule> naming) {

    }

    @Override
    public Set<MetaToken> getFirst() {
        return Set.of(this);
    }


}
