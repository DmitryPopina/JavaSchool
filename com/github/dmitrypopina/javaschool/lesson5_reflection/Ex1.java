package com.github.dmitrypopina.javaschool.lesson5_reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Ex1 {
    public static void main(String[] args){
        Rabbit Bunny = new Rabbit("Bunny", 5);

        Bunny.setWeight(6);
        Bunny.setHidden("hidden");

        System.out.println("Вывести на консоль все методы класса, включая все родительские методы, включая приватные");
        BeanUtils.ListAllMethods(Bunny);
        System.out.println("Вывести все геттеры класса");
        for (Method mtd : BeanUtils.ListGetters(Bunny).values()){
            System.out.printf("%s.%s\n", Bunny.getClass().getName(), mtd.getName());
        }

        System.out.println("Реализовать следующий класс по документации");
        System.out.println(Bunny);
        Rabbit notABunny = new Rabbit("Not a Bunny", 6);
        notABunny.setWeight(12);
        notABunny.setHidden("ntb");
        System.out.println(notABunny);
        System.out.println("После вызова BeanUtils.assign");
        BeanUtils.assign(notABunny, Bunny);
        System.out.println(notABunny);

        Calculator delegate = new CalculatorImpl();
        Calculator calc = (Calculator) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), delegate.getClass().getInterfaces(),new PerformanceProxy(delegate));
        System.out.println(calc.calc(10));
        System.out.println(calc.calc(9));
        System.out.println(calc.calc(8));
        System.out.println(calc.calc(7));
    }
}
