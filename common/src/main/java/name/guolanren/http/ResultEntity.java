package name.guolanren.http;

/**
 * @author guolanren
 */
public class ResultEntity<T> {

    private Integer code;
    private String msg;
    private T data;

    public static ResultEntity success() {
        ResultEntity result = new ResultEntity();
        result.setCode(ResultCode.REQUEST_SUCCESS.getCode());
        result.setMsg(ResultCode.REQUEST_SUCCESS.getDescription());
        return result;
    }

    public static <T> ResultEntity success(T data) {
        ResultEntity<T> result = new ResultEntity();
        result.setCode(ResultCode.REQUEST_SUCCESS.getCode());
        result.setMsg(ResultCode.REQUEST_SUCCESS.getDescription());
        result.setData(data);
        return result;
    }

    public static <T> ResultEntity faild(ResultCode code, T data) {
        ResultEntity<T> result = new ResultEntity();
        result.setCode(code.getCode());
        result.setMsg(code.getDescription());
        result.setData(data);
        return result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
