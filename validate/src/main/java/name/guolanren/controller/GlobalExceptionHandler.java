package name.guolanren.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author guolanren
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * JSR 303: org.springframework.web.bind.MethodArgumentNotValidException
     */
    @ExceptionHandler
    public ResponseEntity<String> methodArgumentNotValidHandle(MethodArgumentNotValidException e) {
        BindingResult bs = e.getBindingResult();
        Map<String, String> errors = new HashMap<>(8);
        for (ObjectError objectError : bs.getAllErrors()) {
            FieldError fieldError = (FieldError) objectError;
            errors.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.ok(errors.toString());
    }

    /**
     * JSR-303: javax.validation.ConstraintViolationException
     * Spring MVC: org.springframework.web.bind.MissingServletRequestParameterException
     */
    @ExceptionHandler({ConstraintViolationException.class, MissingServletRequestParameterException.class})
    public ResponseEntity<String> constraintViolationHandle(Exception e) {
        return ResponseEntity.ok(e.getMessage());
    }

    @ExceptionHandler
    public ResponseEntity<String> unknownHandle(Exception e) {
        LOG.error(e.getMessage(), e);
        return ResponseEntity.ok(e.getMessage());
    }
}
