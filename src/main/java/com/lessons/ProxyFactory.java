package com.lessons;

import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static ILogger getInstance(Object o) {
        return (ILogger) Proxy.newProxyInstance(o.getClass().getClassLoader(), new Class[]{ILogger.class}, new MyHandler(o));
    }
}
