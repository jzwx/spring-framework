package com.service;

        import main.java.com.jzwx.spring.demo.IocFactory.impl.ClassPathXMLApplicationContext;
        import main.java.com.jzwx.spring.demo.service.StudentService;
        import org.junit.Test;

/**
 * @Author:jzwx
 * @Desicription: spring IOC框架
 * @Date:Created in 2018-08-31 10:38
 * @Modified By:
 */
public class UserServiceTest{
    @Test
    public void testStudent() throws Exception{
        ClassPathXMLApplicationContext context = new ClassPathXMLApplicationContext("applicationContext.xml");
        /** 依赖注入,自动装配 */
        StudentService studentService = (StudentService) context.getBean("StudentService");
        studentService.getStudent().selfIntroDuction();
    }
}