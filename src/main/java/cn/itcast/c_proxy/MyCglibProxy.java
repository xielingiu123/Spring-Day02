package cn.itcast.c_proxy;

import cn.itcast.service.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description:
 * @Author xielingqiu
 * @Date 2018/11/15
 */
        //cglib动态代理
    public class MyCglibProxy implements MethodInterceptor{

        private UserService us;

    public MyCglibProxy(UserService us) {
        this.us = us;
    }

    //生成代理的方法
    public UserService createProxy(){
        //创建cglib核心类
         Enhancer eh = new Enhancer();
        //设置父类
        eh.setSuperclass(UserService.class);
        //设置回调
        eh.setCallback(this);
        //生成代理
       UserService usProxy = (UserService) eh.create();
        return usProxy;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        if ("delet".equals(method.getName())){
                Object object = methodProxy.invokeSuper(o,objects);
                System.out.println("dididiid ");

                return object;
        }
        return null;
    }
}
