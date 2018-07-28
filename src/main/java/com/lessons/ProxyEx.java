package com.lessons;

import java.lang.reflect.Proxy;

public class ProxyEx {
    public static MathAlgorithm getInstance(Object o) {
        return (MathAlgorithm) Proxy.newProxyInstance(o.getClass().getClassLoader(), new Class[]{MathAlgorithm.class}, new Handler(o));
    }
}
