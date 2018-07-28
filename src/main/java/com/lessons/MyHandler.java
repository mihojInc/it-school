package com.lessons;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

    Object object;

    public MyHandler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Method invoke from proxy object");
        System.out.println("============Start");
        Method m = object.getClass().getMethod(method.getName(), method.getParameterTypes());
        Count count = m.getAnnotation(Count.class);
        int counter = count.count();
        for (int i = 0; i < counter; i++) {
            method.invoke(object, args);
        }
        System.out.println("============End");
        return null;
    }
}
