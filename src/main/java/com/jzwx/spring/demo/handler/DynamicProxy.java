package main.java.com.jzwx.spring.demo.handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author:jzwx
 * @Desicription: DynamicProxy
 * @Date:Created in 2018-08-31 15:35
 * @Modified By:
 */
public class DynamicProxy implements InvocationHandler {

    private Object target;

    public Object bind(Object target) {
        this.target = target;
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        //切面之前执行
        System.out.println("切面之前执行");
        //执行业务
        result = method.invoke(target, args);
        //切面之后执行
        System.out.println("切面之后执行");
        return result;
    }
}