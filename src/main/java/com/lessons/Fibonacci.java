package com.lessons;

import com.lessons.annotatin.Description;
import com.lessons.annotatin.For;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;


/**
 * Created by Mihail Kolomiets on 28.07.18.
 */
@Description(before = "Hello from fibonachi", after = "bye bye")
public class Fibonacci {

    public String count(int forC) throws Throwable{
        String result = "0 1";
        int a = 0, b = 1, c;
        if (forC > 1) {
            for (int i = 2; i < forC; i++) {
                c = a + b;
                a = b;
                b = c;
                result += " " + c;
            }
        }
        return result;
    }

    @For(value = 12)
    public void writeResultInConsole() throws Throwable{
        Description description = this.getClass().getAnnotation(Description.class);
        For fibSize = this.getClass().getMethod("writeResultInConsole").getAnnotation(For.class);
        System.out.println(description.before());
        System.out.println(count(fibSize.value()));
        System.out.println(description.after());
    }
}
