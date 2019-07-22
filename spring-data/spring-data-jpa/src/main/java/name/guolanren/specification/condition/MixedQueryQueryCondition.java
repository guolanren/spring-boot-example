package name.guolanren.specification.condition;

import name.guolanren.specification.common.Logical;

/**
 * @author guolanren
 */
public class MixedQueryQueryCondition extends QueryConditions {

    public static MixedQueryQueryCondition create() {
        return new MixedQueryQueryCondition();
    }

    public static MixedQueryQueryCondition create(MultiQueryQueryCondition conditions) {
        return new MixedQueryQueryCondition(conditions);
    }

    public static MixedQueryQueryCondition create(MixedQueryQueryCondition conditions) {
        return new MixedQueryQueryCondition(conditions);
    }

    private MixedQueryQueryCondition() {}

    private MixedQueryQueryCondition(QueryCondition conditions) {
        queryConditionList.add(conditions);
    }

    private MixedQueryQueryCondition append(QueryCondition queryCondition) {
        queryConditionList.add(queryCondition);
        return this;
    }

    public MixedQueryQueryCondition and(QueryCondition queryCondition) {
        queryCondition.setLogical(Logical.AND);
        return append(queryCondition);
    }

    public MixedQueryQueryCondition or(QueryCondition queryCondition) {
        queryCondition.setLogical(Logical.OR);
        return append(queryCondition);
    }

}
