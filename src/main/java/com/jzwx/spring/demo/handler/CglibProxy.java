package main.java.com.jzwx.spring.demo.handler;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Author:jzwx
 * @Desicription: CglibProxy
 * @Date:Created in 2018-08-31 16:47
 * @Modified By:
 */
public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target){
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        // 回调方法
        enhancer.setCallback(this);
        // 创建代理对象
        return enhancer.create();
    }

    @Override
    public Object intercept(Object proxy, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        System.out.println("事物开始");
        result =methodProxy.invokeSuper(proxy,objects);
        System.out.println("事物结束");
        return result;
    }
}
