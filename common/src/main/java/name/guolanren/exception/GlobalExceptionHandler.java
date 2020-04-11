package name.guolanren.exception;

import name.guolanren.http.response.ResultCode;
import name.guolanren.http.response.ResultEntity;
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
    public ResultEntity illegalParamHandle(IllegalParamException e) {
        LOG.error(e.getMessage(), e);
        return ResultEntity.failed(ResultCode.ILLEGAL_PARAM_FAILED, e.getMessage());
    }

    @ExceptionHandler
    public ResultEntity serverErrorHandle(ServerErrorException e) {
        LOG.error(e.getMessage(), e);
        return ResultEntity.failed(ResultCode.SERVER_ERROR, e.getMessage());
    }

    @ExceptionHandler
    public ResultEntity expiredSessionHandle(SessionInvalidException e) {
        LOG.error(e.getMessage(), e);
        return ResultEntity.failed(ResultCode.EXPIRED_SESSION, e.getMessage());
    }

    @ExceptionHandler
    public ResultEntity unauthorizedHandle(UnauthorizedException e) {
        LOG.error(e.getMessage(), e);
        return ResultEntity.failed(ResultCode.UNAUTHORIZED, e.getMessage());
    }

    @ExceptionHandler
    public ResultEntity unknownHandle(Exception e) {
        LOG.error(e.getMessage(), e);
        return ResultEntity.failed(ResultCode.UNKNOWN_FAILED, e.getMessage());
    }

}
