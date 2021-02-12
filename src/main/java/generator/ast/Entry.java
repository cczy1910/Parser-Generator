package generator.ast;

import java.util.Map;

public abstract class Entry {
    protected abstract void deduceRules(Map<String, AbstractRule> naming);
}
