package com.lessons;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    Object object;

    public Handler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Description description = object.getClass().getAnnotation(Description.class);
        System.out.println(description.before());
        Method m = object.getClass().getMethod(method.getName(),method.getParameterTypes());
        For f = m.getAnnotation(For.class);
        int counter = f.count();
        method.invoke(object,counter);
        System.out.println(description.after());
        return null;
    }
}
