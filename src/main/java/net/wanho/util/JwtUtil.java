package net.wanho.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import net.wanho.properties.JwtProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Map;


public class JwtUtil {

    private static final String SECRET;
    private static final int EXPIRE;

    static {
        JwtProperties jwtProperties = ApplicationContextHolder.getBean(JwtProperties.class);
        SECRET = jwtProperties.getSecret();
        EXPIRE = jwtProperties.getExpire();
    }

    /**
     * 生成token
     * @param payload
     * @return
     */
    public static String generate(Map<String,Object> payload) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MINUTE, EXPIRE);

        String token = JWT.create()
                .withPayload(payload)
                .withExpiresAt(c.getTime())
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    /**
     * 校验令牌
     */
    public static boolean valid(String token) {
        try {
            JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 解析令牌
     */
    public static Integer parseInteger(String token, String key) {
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token).getClaim(key).asInt();
    }

    public static String parseString(String token, String key) {
        return JWT.require(Algorithm.HMAC256(SECRET)).build().verify(token).getClaim(key).asString();
    }


}
