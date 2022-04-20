package com.github.dmitrypopina.javaschool.lesson5_reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

public class BeanUtils {

    public static HashMap<String, Method> ListGetters(Object object) {
        Class<?> cls = object.getClass();
        HashMap<String, Method> methods = new HashMap<>();

        for (Method mtd : cls.getDeclaredMethods()){
            if (mtd.getReturnType() != void.class && mtd.getParameters().length == 0){
                if (mtd.getName().startsWith("get") || (mtd.getReturnType() == boolean.class && mtd.getName().startsWith("is"))) {
                    methods.put(mtd.getName(), mtd);
                }
            }
        }
        return methods;
    }

    public static HashMap<String, Method> ListSetters(Object object) {
        Class<?> cls = object.getClass();
        HashMap<String, Method> methods = new HashMap<>();

        for (Method mtd : cls.getDeclaredMethods()){
            if (mtd.getReturnType() == void.class && mtd.getParameters().length == 1){
                if (mtd.getName().startsWith("set")) {
                    methods.put(mtd.getName(), mtd);
                }
            }
        }
        return methods;
    }

    /**
     * Scans object "from" for all getters. If object "to"
     * contains correspondent setter, it will invoke it
     * to set property value for "to" which equals to the property
     * of "from".
     * <p/>
     * The type in setter should be compatible to the value returned
     * by getter (if not, no invocation performed).
     * Compatible means that parameter type in setter should
     * be the same or be superclass of the return type of the getter.
     * <p/>
     * The method takes care only about public methods.
     *
     * @param to   Object which properties will be set.
     * @param from Object which properties will be used to get values.
     */
    public static void assign(Object to, Object from) {
        HashMap<String, Method> mapMethodsFrom = ListGetters(from);
        HashMap<String, Method> mapMethodsTo = ListSetters(to);

        for (Map.Entry<String, Method> mtdFrom : mapMethodsFrom.entrySet()){
            if (Modifier.isPublic((mtdFrom.getValue().getModifiers()))){
                Method mtdTo = mapMethodsTo.get(mtdFrom.getKey().replace("get", "set"));
                if (mtdTo != null && Modifier.isPublic(mtdTo.getModifiers())
                    && mtdTo.getParameters()[0].getType().isAssignableFrom(mtdFrom.getValue().getReturnType()))
                {
                    try {
                        mtdTo.invoke(to, mtdFrom.getValue().invoke(from));
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        System.err.println(e.getMessage());
                    }
                }
            }
        }
    }

    public static void ListAllMethods(Object object){
        Class<?> cls = object.getClass();
        while (cls != null) {
            for (Method mtd : cls.getDeclaredMethods()) {
                System.out.printf("%s.%s\n", cls.getName(),  mtd.getName());
            }
            cls = cls.getSuperclass();
        }
    }
}

