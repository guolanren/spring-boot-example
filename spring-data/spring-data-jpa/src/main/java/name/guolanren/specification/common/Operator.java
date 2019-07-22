package name.guolanren.specification.common;

/**
 * @author guolanren
 */
public enum Operator {

    /**
     * 相等
     */
    EQUALS,

    /**
     * 不相等
     */
    NOT_EQUALS,

    /**
     * 大于
     */
    GREATER_THAN,

    /**
     * 大于等于
     */
    GREATER_THAN_OR_EQUALS,

    /**
     * 小于
     */
    LESS_THAN,

    /**
     * 小于等于
     */
    LESS_THAN_OR_EQUALS,

    /**
     * 介于之间
     */
    BETWEEN,

    /**
     * 存在于
     */
    IN,

    /**
     * 不存在于
     */
    NOT_IN,

    /**
     * 包含
     */
    CONTAINS,

    /**
     * 前缀
     */
    STARTS_WITH,

    /**
     * 后缀
     */
    ENDS_WITH,

    /**
     * 空
     */
    IS_NULL,

    /**
     * 非空
     */
    NOT_NULL
}
