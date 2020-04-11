package name.guolanren.http.response;

/**
 * @author guolanren
 */
public class ResultEntity<T> {

    private Integer errCode;
    private String errMsg;
    private T data;

    public static ResultEntity success() {
        ResultEntity result = new ResultEntity();
        result.setErrCode(ResultCode.REQUEST_SUCCESS.getCode());
        result.setErrMsg(ResultCode.REQUEST_SUCCESS.getDescription());
        return result;
    }

    public static <T> ResultEntity<T> success(T data) {
        ResultEntity<T> result = new ResultEntity();
        result.setErrCode(ResultCode.REQUEST_SUCCESS.getCode());
        result.setErrMsg(ResultCode.REQUEST_SUCCESS.getDescription());
        result.setData(data);
        return result;
    }

    public static <T> ResultEntity<T> failed(ResultCode code, T data) {
        ResultEntity<T> result = new ResultEntity();
        result.setErrCode(code.getCode());
        result.setErrMsg(code.getDescription());
        result.setData(data);
        return result;
    }

    public static ResultEntity redirect(String url) {
        ResultEntity<String> result = new ResultEntity();
        result.setErrCode(ResultCode.REDIRECT.getCode());
        result.setErrMsg(ResultCode.REDIRECT.getDescription());
        result.setData(url);
        return result;
    }

    public static ResultEntity forward(String path) {
        ResultEntity<String> result = new ResultEntity();
        result.setErrCode(ResultCode.FORWARD.getCode());
        result.setErrMsg(ResultCode.FORWARD.getDescription());
        result.setData(path);
        return result;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
