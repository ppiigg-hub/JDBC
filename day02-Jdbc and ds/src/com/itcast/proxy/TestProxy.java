package com.itcast.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class TestProxy {
    public static void main(String[] args) {
        //创建被代理对象
        HouZi wukong = new HouZi();
        /*String res = wukong.eat("香蕉");
        System.out.println(res);

        wukong.hit();*/

        //创建代理对象
        QuJingRen wukongProxy = (QuJingRen)Proxy.newProxyInstance(TestProxy.class.getClassLoader(), new Class[]{QuJingRen.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //System.out.println(method.getName());
                //System.out.println(Arrays.toString(args));

                //执行原来的操作
                /*Object re = method.invoke(wukong, args);//eat方法  re:吃玉米
                System.out.println(re);
                return re;
                */
                //若是hit方法,修改逻辑
                if("hit".equals(method.getName())){
                    System.out.println("乖乖的打妖怪");
                    return null;
                }

                //否则 执行原来的逻辑


                //执行原来的操作
                return method.invoke(wukong, args);
            }
        });

        wukongProxy.hit();
        String r = wukongProxy.eat("玉米");
        System.out.println("r的结果"+r);
    }
}
