package moka.basic.aspect;

import moka.basic.annotation.IgnoreSecurity;
import moka.basic.annotation.NotAspect;
import moka.basic.bo.Token;
import moka.basic.exception.NoLoginException;
import moka.basic.service.RedisService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Created by moka on 2017/3/29 0029.
 */
public class SecurityAspect {

    @Value("#{propertyConfigurer['data_token_name']}")
    private String DEFAULT_TOKEN_NAME;

    private String tokenName;

    public void setTokenName(String tokenName) {
        if (StringUtils.isEmpty(tokenName)) {
            tokenName = DEFAULT_TOKEN_NAME;
        }
        this.tokenName = tokenName;
    }

    @Resource
    private RedisService redisService;

    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        //获取方法上面的注解
        boolean IgnoreSecurity_b = method.isAnnotationPresent(IgnoreSecurity.class);
        if (IgnoreSecurity_b) return pjp.proceed();

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();

        String token = request.getHeader(tokenName);
        if(!StringUtils.isEmpty(token)){
            redisService.flashLoginSession(new Token(token));
            response.setHeader(tokenName,token);
        }else{
            throw new NoLoginException("用户没有登录");
        }
        return pjp.proceed();
    }
}
