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

    public static ResultEntity failed(Integer errCode, String errMsg) {
        ResultEntity result = new ResultEntity();
        result.setErrCode(errCode);
        result.setErrMsg(errMsg);
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
