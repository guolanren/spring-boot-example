package name.guolanren.common;

/**
 * @author guolanren
 */
public enum ResultCode {

    /**
     * 响应成功
     */
    REQUEST_SUCCESS(100, "响应成功"),

    /**
     * 请求失败
     */
    REQUEST_FAILD(200, "请求失败"),

    /**
     * 无效请求参数
     */
    INVALID_PARAM_FAILD(201, "无效参数"),

    /**
     * 非法请求参数
     */
    ILLEGAL_PARAM_FAILD(202, "非法参数"),

    /**
     * 服务器错误
     */
    SERVER_ERROR(301, "服务器错误"),

    /**
     * Session失效
     */
    EXPIRED_SESSION(401, "SESSION失效"),

    /**
     * 未授权
     */
    UNAUTHORIZED(402, "未授权"),

    /**
     * 未知异常
     */
    UNKNOWN_FAILED(900, "未知异常");

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
