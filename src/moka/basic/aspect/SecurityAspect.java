package moka.basic.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by moka on 2017/3/29 0029.
 */
public class SecurityAspect {

    private static final String DEFAULT_TOKEN_NAME = "X-Token";

    private String tokenName;

    /**
     * 拿不到
     */
    @Autowired()
    private HttpServletRequest requests;

    public void setTokenName(String tokenName) {
        if(StringUtils.isEmpty(tokenName)){
            tokenName = DEFAULT_TOKEN_NAME;
        }
        this.tokenName = tokenName;
    }

    public Object execute(ProceedingJoinPoint pjp) throws Throwable{
        // 从切点上获取目标方法
        MethodSignature methodSignature = (MethodSignature) pjp.getSignature();
        Method method = methodSignature.getMethod();
        Object[] args = pjp.getArgs();
        System.out.println(args);
        HttpServletResponse response1 = (HttpServletResponse)args[1];
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getResponse();
        System.out.println(response == response1);
        response.setHeader("X-Token1","123123123");
        String token = request.getHeader(tokenName);
//        method.isAnnotationPresent()
        // 若目标方法忽略了安全性检查，则直接调用目标方法
//        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
//            return pjp.proceed();
//        }
        // 从 request header 中获取当前 token
//        String token = WebContext.getRequest().getHeader(tokenName);

        System.out.println(token);
        System.out.println(request);
        System.out.println(pjp);
        return pjp.proceed();
    }
}
