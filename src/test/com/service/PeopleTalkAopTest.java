package com.service;

import main.java.com.jzwx.spring.demo.handler.CglibProxy;
import main.java.com.jzwx.spring.demo.pojo.PeopleTalkAop;
import org.junit.Test;

/**
 * @Author:jzwx
 * @Desicription: PeopleTalkAop
 * @Date:Created in 2018-08-31 16:46
 * @Modified By:
 */
public class PeopleTalkAopTest {
    @Test
    public void testPeopleTalkAop(){
        PeopleTalkAop peopleTalkAop= (PeopleTalkAop) new CglibProxy().getInstance(new PeopleTalkAop());
        peopleTalkAop.talk("业务方法");
        peopleTalkAop.spreak("业务方法");
    }
}
