package com.lessons;

import java.lang.reflect.Proxy;

public class MyProxy {
    public static MyFibonacci getInstance(Object o) {
        return (MyFibonacci) Proxy.newProxyInstance(o.getClass().getClassLoader(), new Class[]{MyFibonacci.class}, new Handler(o));
    }
}
