package src.main.java.com.lessons;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {

    Object object;

    public MyHandler(Object object) {
        this.object=object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Method m = object.getClass().getMethod(method.getName(), method.getParameterTypes());
        For count = m.getAnnotation(For.class);
        Description d = object.getClass().getAnnotation(Description.class);
        String af = d.after();
        String be = d.before();
        int forFib = count.num();
        System.out.println(be);
        method.invoke(object, forFib);
        System.out.println(af);
        return null;
    }
}
