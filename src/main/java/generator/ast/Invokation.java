package generator.ast;

import java.util.List;
import java.util.Set;

public abstract class Invokation implements GrammarEntry {
    public abstract Set<MetaToken> getFirst();

    public abstract List<String> print();
}
