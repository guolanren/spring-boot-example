package name.guolanren.specification.condition;

import name.guolanren.specification.common.Logical;
import name.guolanren.specification.common.Operator;
import name.guolanren.specification.factory.SpecificationFactory;
import org.springframework.data.jpa.domain.Specification;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author guolanren
 */
public class SingleQueryQueryCondition extends QueryCondition {

    private String attribute;
    private Operator operator;
    private Object value;

    public static SingleQueryQueryCondition equals(String attribute, Object value) {
        return new SingleQueryQueryCondition(attribute, Operator.EQUALS, value);
    }

    public static SingleQueryQueryCondition notEquals(String attribute, Object value) {
        return new SingleQueryQueryCondition(attribute, Operator.NOT_EQUALS, value);
    }

    public static SingleQueryQueryCondition greaterThan(String attribute, Comparable value) {
        return new SingleQueryQueryCondition(attribute, Operator.GREATER_THAN, value);
    }

    public static SingleQueryQueryCondition greaterThanOrEquals(String attribute, Comparable value) {
        return new SingleQueryQueryCondition(attribute, Operator.GREATER_THAN_OR_EQUALS, value);
    }

    public static SingleQueryQueryCondition lessThan(String attribute, Comparable value) {
        return new SingleQueryQueryCondition(attribute, Operator.LESS_THAN, value);
    }

    public static SingleQueryQueryCondition lessThanOrEquals(String attribute, Comparable value) {
        return new SingleQueryQueryCondition(attribute, Operator.LESS_THAN_OR_EQUALS, value);
    }

    public static <C extends Comparable> SingleQueryQueryCondition between(String attribute, C min, C max) {
        return new SingleQueryQueryCondition(attribute, Operator.BETWEEN, Arrays.asList(min, max));
    }

    public static SingleQueryQueryCondition in(String attribute, Collection collection) {
        return new SingleQueryQueryCondition(attribute, Operator.IN, collection);
    }

    public static SingleQueryQueryCondition notIn(String attribute, Collection collection) {
        return new SingleQueryQueryCondition(attribute, Operator.NOT_IN, collection);
    }

    public static SingleQueryQueryCondition contains(String attribute, String value) {
        return new SingleQueryQueryCondition(attribute, Operator.CONTAINS, value);
    }

    public static SingleQueryQueryCondition startsWith(String attribute, String value) {
        return new SingleQueryQueryCondition(attribute, Operator.STARTS_WITH, value);
    }

    public static SingleQueryQueryCondition endsWith(String attribute, String value) {
        return new SingleQueryQueryCondition(attribute, Operator.ENDS_WITH, value);
    }

    public static SingleQueryQueryCondition isNull(String attribute) {
        return new SingleQueryQueryCondition(attribute, Operator.IS_NULL, null);
    }

    public static SingleQueryQueryCondition notNull(String attribute) {
        return new SingleQueryQueryCondition(attribute, Operator.NOT_NULL, null);
    }

    private SingleQueryQueryCondition(String attribute, Operator operator, Object value) {
        this.attribute = attribute;
        this.operator = operator;
        this.value = value;
    }

    SingleQueryQueryCondition(String attribute, Operator operator, Object value, Logical logical) {
        this.attribute = attribute;
        this.operator = operator;
        this.value = value;
        this.logical = logical;
    }

    @Override
    public <T> Specification<T> build() {
        return toSpecification();
    }

    Specification toSpecification() {
        switch (operator) {
            case EQUALS: return SpecificationFactory.equals(attribute, value);
            case NOT_EQUALS: return SpecificationFactory.notEquals(attribute, value);
            case GREATER_THAN: return SpecificationFactory.greaterThan(attribute, (Comparable) value);
            case GREATER_THAN_OR_EQUALS: return SpecificationFactory.greaterThanOrEquals(attribute, (Comparable) value);
            case LESS_THAN: return SpecificationFactory.lessThan(attribute, (Comparable) value);
            case LESS_THAN_OR_EQUALS: return SpecificationFactory.lessThanOrEquals(attribute, (Comparable) value);
            case BETWEEN:
                List<Comparable> range = (List<Comparable>)value;
                return SpecificationFactory.between(attribute, range.get(0), range.get(1));
            case IN: return SpecificationFactory.in(attribute, (Collection) value);
            case NOT_IN: return SpecificationFactory.notIn(attribute, (Collection) value);
            case CONTAINS: return SpecificationFactory.contains(attribute, (String) value);
            case STARTS_WITH: return SpecificationFactory.startsWith(attribute, (String) value);
            case ENDS_WITH: return SpecificationFactory.endsWith(attribute, (String) value);
            case IS_NULL: return SpecificationFactory.isNull(attribute);
            case NOT_NULL: return SpecificationFactory.notNull(attribute);
            default: return null;
        }
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}
