package cn.itcast.c_proxy;

import cn.itcast.service.UserService;
import cn.itcast.service.UserServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceProxyFactory implements InvocationHandler {

    public UserServiceProxyFactory(UserService us) {
        super();
        this.us = us;
    }

    private UserService us;


    public UserService userServiceProxy(){
        /**
         * 生成代理对象
         * 1.类加载器
         * 2.被代理对象的接口
         * 3.传入一个实现如何增强被代理对象的接口
         */
        UserService userServiceProxy = (UserService) Proxy.newProxyInstance(
                UserServiceProxyFactory.class.getClassLoader(),
                UserServiceImpl.class.getInterfaces(),
                this);

        return userServiceProxy;
    }

    /*
       1.当前的代理对象
       2.当前调用的方法
       3.当前方法执行的参数
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("打开事务");
        Object invoke = method.invoke(us,args);
        System.out.println("关闭事务");
        return invoke;
    }
}
