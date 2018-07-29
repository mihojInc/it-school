package src.main.java.com.lessons;

import java.lang.reflect.Proxy;
public class ProxyFactory {
    public static IFinobachi getInstance(Object o) {
        return (IFinobachi) Proxy.newProxyInstance(o.getClass().getClassLoader(), new Class[]{IFinobachi.class}, new MyHandler(o));
    }

}
