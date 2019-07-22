package name.guolanren.specification.condition;

import name.guolanren.specification.common.Logical;
import name.guolanren.specification.common.Operator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author guolanren
 */
public class MultiQueryQueryCondition extends QueryConditions {

    private static final Logger LOG = LoggerFactory.getLogger(MultiQueryQueryCondition.class);

    public static MultiQueryQueryCondition create() {
        return new MultiQueryQueryCondition();
    }

    public static MultiQueryQueryCondition create(MultiQueryQueryCondition conditions) {
        return new MultiQueryQueryCondition(conditions);
    }

    public static MultiQueryQueryCondition equalAll(Object object) {
        return equalAllExclude(object);
    }

    public static MultiQueryQueryCondition equalInclude(Object object, String... include) {
        return equalAll(object, true, include);
    }

    public static MultiQueryQueryCondition equalAllExclude(Object object, String... exclude) {
        return equalAll(object, false, exclude);
    }

    public static MultiQueryQueryCondition equalAll(Object object, Boolean include, String... properties) {
        MultiQueryQueryCondition multiQueryCondition = MultiQueryQueryCondition.create();
        if (object != null) {
            List<String> propertyList = Arrays.asList(properties);
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (include == propertyList.contains(field.getName())) {
                    try {
                        Object value = field.get(object);
                        if (value != null) {
                            multiQueryCondition.andEquals(field.getName(), value);
                        }
                    } catch (IllegalAccessException e) {
                        LOG.error(e.getMessage());
                    }
                }
            }
        }
        return multiQueryCondition;
    }

    private MultiQueryQueryCondition() {}

    private MultiQueryQueryCondition(MultiQueryQueryCondition conditions) {
        queryConditionList.addAll(conditions.queryConditionList);
    }

    private MultiQueryQueryCondition append(QueryCondition queryCondition) {
        queryConditionList.add(queryCondition);
        return this;
    }

    public MultiQueryQueryCondition andEquals(String attribute, Object value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.EQUALS, value, Logical.AND));
    }

    public MultiQueryQueryCondition orEquals(String attribute, Object value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.EQUALS, value, Logical.OR));
    }

    public MultiQueryQueryCondition andNotEquals(String attribute, Object value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.NOT_EQUALS, value, Logical.AND));
    }

    public MultiQueryQueryCondition orNotEquals(String attribute, Object value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.NOT_EQUALS, value, Logical.OR));
    }

    public MultiQueryQueryCondition andGreaterThan(String attribute, Comparable value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.GREATER_THAN, value, Logical.AND));
    }

    public MultiQueryQueryCondition orGreaterThan(String attribute, Comparable value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.GREATER_THAN, value, Logical.OR));
    }

    public MultiQueryQueryCondition andGreaterThanOrEquals(String attribute, Comparable value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.GREATER_THAN_OR_EQUALS, value, Logical.AND));
    }

    public MultiQueryQueryCondition orGreaterThanOrEquals(String attribute, Comparable value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.GREATER_THAN_OR_EQUALS, value, Logical.OR));
    }

    public MultiQueryQueryCondition andLessThan(String attribute, Comparable value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.LESS_THAN, value, Logical.AND));
    }

    public MultiQueryQueryCondition orLessThan(String attribute, Comparable value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.LESS_THAN, value, Logical.OR));
    }

    public MultiQueryQueryCondition andLessThanOrEquals(String attribute, Comparable value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.LESS_THAN_OR_EQUALS, value, Logical.AND));
    }

    public MultiQueryQueryCondition orLessThanOrEquals(String attribute, Comparable value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.LESS_THAN_OR_EQUALS, value, Logical.OR));
    }

    public <C extends Comparable> MultiQueryQueryCondition andBetween(String attribute, C min, C max) {
        return append(new SingleQueryQueryCondition(attribute, Operator.BETWEEN, Arrays.asList(min, max), Logical.AND));
    }

    public <C extends Comparable> MultiQueryQueryCondition orBetween(String attribute, C min, C max) {
        return append(new SingleQueryQueryCondition(attribute, Operator.BETWEEN, Arrays.asList(min, max), Logical.OR));
    }

    public MultiQueryQueryCondition andIn(String attribute, Collection collection) {
        return append(new SingleQueryQueryCondition(attribute, Operator.IN, collection, Logical.AND));
    }

    public MultiQueryQueryCondition orIn(String attribute, Collection collection) {
        return append(new SingleQueryQueryCondition(attribute, Operator.IN, collection, Logical.OR));
    }

    public MultiQueryQueryCondition andNotIn(String attribute, Collection collection) {
        return append(new SingleQueryQueryCondition(attribute, Operator.NOT_IN, collection, Logical.AND));
    }

    public MultiQueryQueryCondition orNotIn(String attribute, Collection collection) {
        return append(new SingleQueryQueryCondition(attribute, Operator.NOT_IN, collection, Logical.OR));
    }

    public MultiQueryQueryCondition andContains(String attribute, String value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.CONTAINS, value, Logical.AND));
    }

    public MultiQueryQueryCondition orContains(String attribute, String value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.CONTAINS, value, Logical.OR));
    }

    public MultiQueryQueryCondition andStartsWith(String attribute, String value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.STARTS_WITH, value, Logical.AND));
    }

    public MultiQueryQueryCondition orStartsWith(String attribute, String value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.STARTS_WITH, value, Logical.OR));
    }

    public MultiQueryQueryCondition andEndsWith(String attribute, String value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.ENDS_WITH, value, Logical.AND));
    }

    public MultiQueryQueryCondition orEndsWith(String attribute, String value) {
        return append(new SingleQueryQueryCondition(attribute, Operator.ENDS_WITH, value, Logical.OR));
    }

    public MultiQueryQueryCondition andIsNull(String attribute) {
        return append(new SingleQueryQueryCondition(attribute, Operator.IS_NULL, null, Logical.AND));
    }

    public MultiQueryQueryCondition orIsNull(String attribute) {
        return append(new SingleQueryQueryCondition(attribute, Operator.IS_NULL, null, Logical.OR));
    }

    public MultiQueryQueryCondition andNotNull(String attribute) {
        return append(new SingleQueryQueryCondition(attribute, Operator.NOT_NULL, null, Logical.AND));
    }

    public MultiQueryQueryCondition orNotNull(String attribute) {
        return append(new SingleQueryQueryCondition(attribute, Operator.NOT_NULL, null, Logical.OR));
    }


}
