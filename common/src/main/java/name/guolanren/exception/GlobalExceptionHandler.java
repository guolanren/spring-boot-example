package name.guolanren.exception;

import name.guolanren.http.response.ResultCode;
import name.guolanren.http.response.ResultEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author guolanren
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler
    public ResultEntity unknownHandle(Exception e) {
        LOG.error(e.getMessage(), e);
        return ResultEntity.failed(ResultCode.UNKNOWN_FAILED.getCode(), e.getMessage());
    }

}
