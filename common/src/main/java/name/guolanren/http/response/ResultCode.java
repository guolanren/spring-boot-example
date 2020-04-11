package name.guolanren.http.response;

/**
 * @author guolanren
 */
public enum ResultCode {

    /**
     * 请求成功
     */
    REQUEST_SUCCESS(1000, "请求成功"),

    /**
     * 非法参数
     */
    ILLEGAL_PARAM_FAILED(2001, "非法参数"),

    /**
     * 服务端错误
     */
    SERVER_ERROR(3000, "服务器错误"),

    /**
     * 无效会话
     */
    EXPIRED_SESSION(4001, "无效失效"),

    /**
     * 未授权
     */
    UNAUTHORIZED(4002, "未授权"),

    /**
     * 重定向
     */
    REDIRECT(5001, "重定向"),

    /**
     * 转发
     */
    FORWARD(5002, "转发"),

    /**
     * 业务错误
     */
    BUSINESS_FAIL(10000, "业务异常"),

    /**
     * 未知异常
     */
    UNKNOWN_FAILED(-1, "未知异常");

    private Integer code;
    private String description;

    ResultCode(Integer code, String description) {
        this.code = code;
        this.description = description;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
