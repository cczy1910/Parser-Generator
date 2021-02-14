package generator.ast;

import java.util.Map;

interface GrammarEntry {
    void deduceRules(Map<String, AbstractRule> naming);
}
