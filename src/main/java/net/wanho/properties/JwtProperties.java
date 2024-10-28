package net.wanho.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * JWT配置属性类
 */
@Data
@Component
@ConfigurationProperties(prefix = "warehouse.jwt")
public class JwtProperties {
    private String secret;
    private Integer expire;
}
