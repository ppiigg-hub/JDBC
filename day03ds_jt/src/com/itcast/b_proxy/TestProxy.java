package com.itcast.b_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        //创建代理对象
        QuJingRen proxy =  (QuJingRen)Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[]{QuJingRen.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                //判断
                if("eat".equals(method.getName())){
                    System.out.println("吃的方法执行了");
                    return "eat "+ (String)args[0];
                }else if("hit".equals(method.getName())){
                    System.out.println("狠厉害的打妖怪~~");
                    return null;
                }

                return null;
            }
        });

        //创建代理对象
       /*
        QuJingRen proxy1 =  (QuJingRen)Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[]{QuJingRen.class},
                (proxy,method,args)->{
                    return null;
                });
        */

        //String result = proxy.eat("花生油");
        //System.out.println("eat方法的返回值为:"+result);

        proxy.hit();

    }
}


