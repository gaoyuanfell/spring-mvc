package moka.basic.aspect;

import moka.basic.service.RedisService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * Created by moka on 2017/3/29 0029.
 */
public class SecurityAspect {

    private static final String DEFAULT_TOKEN_NAME = "X-Token";

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
        Object[] args = pjp.getArgs();

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();

        redisService.flashLoginSession();

        /*response.setHeader("X-Token","123123123");
        String token = request.getHeader(tokenName);

        if(StringUtils.isEmpty(token)){
            response.reset();
            response.setHeader("X-Token","123123123");
            PrintWriter out = response.getWriter();
            JSONObject json = new JSONObject();
            json.put("asd","asd");
            out.print(JSON.toJSONString(json));
            out.flush();
            out.close();
            return false;
        }*/

//        method.isAnnotationPresent()
//         若目标方法忽略了安全性检查，则直接调用目标方法
//        if (method.isAnnotationPresent(IgnoreSecurity.class)) {
//            return pjp.proceed();
//        }

        return pjp.proceed();
    }
}
