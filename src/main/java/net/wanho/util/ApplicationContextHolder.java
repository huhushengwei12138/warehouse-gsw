package net.wanho.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Author：汤小洋
 * Date：2024-08-09 10:42
 * Description：IoC容器工具类，用于从容器中获取Bean
 */
@Component
public class ApplicationContextHolder implements ApplicationContextAware {

    private static ApplicationContext ac;

    @Override
    public void setApplicationContext(ApplicationContext ac) throws BeansException {
        this.ac = ac;
    }

    /**
     * 根据名称，获取容器中的bean
     */
    public static Object getBean(String name) {
        return ac.getBean(name);
    }

    /**
     * 根据类型，获取容器中的bean
     */
    public static <T> T getBean(Class<T> clazz) {
        return ac.getBean(clazz);
    }
}
