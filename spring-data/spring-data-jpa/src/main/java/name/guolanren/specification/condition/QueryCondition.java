package name.guolanren.specification.condition;

import name.guolanren.specification.common.Logical;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author guolanren
 */
public abstract class QueryCondition {

    protected Logical logical;

    public abstract <T> Specification<T> build();

    public Logical getLogical() {
        return logical;
    }

    public void setLogical(Logical logical) {
        this.logical = logical;
    }
}
