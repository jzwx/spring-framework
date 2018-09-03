package main.java.com.jzwx.spring.demo.IocFactory;

/**
 * @Author:jzwx
 * @Desicription: ApplicationContext
 * @Date:Created in 2018-08-31 10:04
 * @Modified By:
 */
public interface ApplicationContext {
    Object getBean(String name);
}