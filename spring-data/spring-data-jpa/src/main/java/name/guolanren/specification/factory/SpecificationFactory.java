package name.guolanren.specification.factory;

import org.springframework.data.jpa.domain.Specification;

import java.util.Collection;

/**
 * @author guolanren
 */
public final class SpecificationFactory {

    public static Specification nullSpecification() {
        return (root, query, criteriaBuilder) -> null;
    }

    public static <T> Specification<T> equals(String attribute, Object value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(attribute), value);
    }

    public static <T> Specification<T> notEquals(String attribute, Object value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get(attribute), value).not();
    }

    public static <T> Specification<T> greaterThan(String attribute, Comparable value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get(attribute), value);
    }

    public static <T> Specification<T> greaterThanOrEquals(String attribute, Comparable value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get(attribute), value);
    }

    public static <T> Specification<T> lessThan(String attribute, Comparable value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThan(root.get(attribute), value);
    }

    public static <T> Specification<T> lessThanOrEquals(String attribute, Comparable value) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(root.get(attribute), value);
    }

    public static <T, C extends Comparable> Specification<T> between(String attribute, C min, C max) {
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get(attribute), min, max);
    }

    public static <T> Specification<T> in(String attribute, Collection collection) {
        return (root, query, criteriaBuilder) -> root.get(attribute).in(collection);
    }

    public static <T> Specification<T> notIn(String attribute, Collection collection) {
        return (root, query, criteriaBuilder) -> root.get(attribute).in(collection).not();
    }

    public static <T> Specification<T> contains(String attribute, String value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(attribute), "%" + value + "%"));
    }

    public static <T> Specification<T> startsWith(String attribute, String value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(attribute), value + "%"));
    }

    public static <T> Specification<T> endsWith(String attribute, String value) {
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get(attribute), "%" + value));
    }

    public static <T> Specification<T> isNull(String attribute) {
        return (root, query, criteriaBuilder) -> root.get(attribute).isNull();
    }

    public static <T> Specification<T> notNull(String attribute) {
        return (root, query, criteriaBuilder) -> root.get(attribute).isNotNull();
    }

}
