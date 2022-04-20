package com.github.dmitrypopina.javaschool.lesson5_reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class PerformanceProxy implements InvocationHandler {
    private final Object delegate;

    public PerformanceProxy(Object delegate){
        this.delegate=delegate;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws RuntimeException {
        Object res;

        if(!method.isAnnotationPresent(Metric.class)) {
             return run(method,args);
        }
        long startTime = System.nanoTime();
        res = run(method,args);
        long endTime = System.nanoTime();
        System.out.printf("Время работы метода: %d (в наносек)\n", endTime - startTime);
        return res;
    }

    private Object run(Method method, Object[] args) throws RuntimeException {
        try {
            return method.invoke(delegate,args);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("No access",e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException("Some problems during invocation",e);
        }
    }
}
