package net.wanho.interceptor;

import io.netty.util.internal.StringUtil;
import net.wanho.util.CurrentUserUtil;
import net.wanho.util.JwtUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authorization = request.getHeader("authorization");
        if(StringUtil.isNullOrEmpty(authorization)){
            throw new RuntimeException("请先登录");
        }
        String token = authorization.replace("Bearer ", "");

        if(!JwtUtil.valid(token)){
            throw new RuntimeException("令牌无效");
        }

        Integer id = JwtUtil.parseInteger(token, "userId");

        CurrentUserUtil.setCurrentUser(id);

        return true;

    }
}
