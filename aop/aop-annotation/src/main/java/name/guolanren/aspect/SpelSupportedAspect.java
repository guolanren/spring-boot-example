package name.guolanren.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.lang.Nullable;

import java.lang.reflect.Method;

/**
 * @author guolanren
 */
public abstract class SpelSupportedAspect {

    private static final Logger LOG = LoggerFactory.getLogger(SpelSupportedAspect.class);

    @Autowired
    private BeanFactory beanFactory;

    StandardEvaluationContext context = new StandardEvaluationContext();
    ExpressionParser parser = new SpelExpressionParser();
    LocalVariableTableParameterNameDiscoverer discoverer = new LocalVariableTableParameterNameDiscoverer();

    public void addVariable(ProceedingJoinPoint joinPoint) {
        try {
            context.setBeanResolver(new BeanFactoryResolver(beanFactory));
            Method method = ((MethodSignature)joinPoint.getSignature()).getMethod();
            String[] params = discoverer.getParameterNames(method);
            Object[] args = joinPoint.getArgs();
            for (int i = 0; i < params.length; i++) {
                context.setVariable(params[i], args[i]);
            }
        } catch (Exception e) {
            LOG.warn(e.getMessage());
        }
    }

    public <T> T getValue(String expressionString, @Nullable Class<T> desiredResultType) {
        try {
            return parser.parseExpression(expressionString).getValue(context, desiredResultType);
        } catch (Exception e) {
            LOG.warn(e.getMessage());
        }
        return null;
    }
}
