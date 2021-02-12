package generator.ast;

import java.util.Objects;
import java.util.Set;

public abstract class AbstractRule extends Entry {
    public String name;

    public AbstractRule(String name) {
        this.name = name;
    }

    public abstract Set<MetaToken> getFirst();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractRule that = (AbstractRule) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
