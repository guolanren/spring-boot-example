package name.guolanren.http.response;

/**
 * @author guolanren
 */
public enum ResultCode {

    /**
     * 请求成功
     */
    REQUEST_SUCCESS(0, "ok"),

    /**
     * 未知异常
     */
    UNKNOWN_FAILED(-1, "unknown");

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
