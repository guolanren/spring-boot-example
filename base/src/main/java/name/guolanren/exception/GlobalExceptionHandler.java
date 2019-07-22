package name.guolanren.exception;

import name.guolanren.common.ResultCode;
import name.guolanren.common.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author guolanren
 */
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResultEntity requestHandle(RequestException e) {
        LOG.error(e.getMessage());
        return ResultEntity.faild(ResultCode.REQUEST_FAILD, e.getMessage());
    }
    @ExceptionHandler
    public ResultEntity InvalidParamHandle(InvalidParamException e) {
        LOG.error(e.getMessage());
        return ResultEntity.faild(ResultCode.INVALID_PARAM_FAILD, e.getMessage());
    }

    @ExceptionHandler
    public ResultEntity IllegalParamHandle(IllegalParamException e) {
        LOG.error(e.getMessage());
        return ResultEntity.faild(ResultCode.REQUEST_FAILD, e.getMessage());
    }

    @ExceptionHandler
    public ResultEntity serverErrorHandle(ServerErrorException e) {
        LOG.error(e.getMessage());
        return ResultEntity.faild(ResultCode.SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler
    public ResultEntity expiredSessionHandle(ExpiredSessionException e) {
        LOG.error(e.getMessage());
        return ResultEntity.faild(ResultCode.EXPIRED_SESSION, e.getMessage());
    }

    @ExceptionHandler
    public ResultEntity unauthorizedHandle(UnauthorizedException e) {
        LOG.error(e.getMessage());
        return ResultEntity.faild(ResultCode.UNAUTHORIZED, e.getMessage());
    }

    @ExceptionHandler
    public ResultEntity unknownHandle(Exception e) {
        LOG.error(e.getMessage());
        return ResultEntity.faild(ResultCode.UNKNOWN_FAILED, e.getMessage());
    }

}
