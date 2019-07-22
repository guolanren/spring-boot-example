package name.guolanren.specification.condition;

import name.guolanren.specification.factory.SpecificationFactory;
import org.springframework.data.jpa.domain.Specification;

import java.util.LinkedList;
import java.util.List;

/**
 * @author guolanren
 */
public abstract class QueryConditions extends QueryCondition {

    protected List<QueryCondition> queryConditionList = new LinkedList<>();

    @Override
    public <T> Specification<T> build() {
        Specification specification = SpecificationFactory.nullSpecification();
        for (QueryCondition queryCondition : queryConditionList) {
            switch (queryCondition.getLogical()) {
                case AND:
                    specification = specification.and(queryCondition.build());
                    break;
                case OR:
                    specification = specification.or(queryCondition.build());
                    break;
                default:
            }
        }
        return specification;
    }

}
