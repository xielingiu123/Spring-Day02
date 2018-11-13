package cn.itcast.c_proxy;

import cn.itcast.service.UserService;
import cn.itcast.service.UserServiceImpl;
import org.junit.Test;

public class Demo {
    @Test
    public void fun(){
        UserService us = new UserServiceImpl();
        UserServiceProxyFactory usProxyFactory = new UserServiceProxyFactory(us);
        UserService usProxy = usProxyFactory.userServiceProxy();
        usProxy.select();
    }
}
