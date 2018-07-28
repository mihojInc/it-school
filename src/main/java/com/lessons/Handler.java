package com.lessons;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

public class Handler implements InvocationHandler {

    Object object;

    public Handler(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Description description = object.getClass().getAnnotation(Description.class);
        System.out.println(description.before());
        Method method1 = object.getClass().getMethod(method.getName(),method.getParameterTypes());
        counter counter = method1.getAnnotation(com.lessons.counter.class);
        int iter = counter.count();
        for(int i = 0; i < iter; i++){
            method.invoke(object,args);
        }
        List<String> result = FileWork.readMyFile();
        for (String str:result
             ) {
            System.out.println(str);
        }
        System.out.println(description.after());
        return null;
    }
}
