package com.service;

import main.java.com.jzwx.spring.demo.IocFactory.impl.ClassPathXMLApplicationContext;
import main.java.com.jzwx.spring.demo.handler.DynamicProxy;
import main.java.com.jzwx.spring.demo.service.PeopleTalkService;
import main.java.com.jzwx.spring.demo.service.impl.ITalk;
import org.junit.Test;

/**
 * @Author:jzwx
 * @Desicription: spring AOP框架
 * @Date:Created in 2018-08-31 15:46
 * @Modified By:
 */
public class PeopleTalkServiceTest {
    @Test
    public void testPeopleTalkService() throws Exception{
        ClassPathXMLApplicationContext context = new ClassPathXMLApplicationContext("applicationContext.xml");
        PeopleTalkService peopleTalkService = (PeopleTalkService) context.getBean("PeopleTalkService");
        ITalk iTalk = (ITalk) new DynamicProxy().bind(peopleTalkService.getPeopleTalk());
        iTalk.talk("业务说明");
    }
}
