package com.github.dmitrypopina.javaschool.lesson3.Ex3;

import java.util.Iterator;
import java.util.List;

public class Ex3 {
    public static void main(String[] args) {
        MyLinkedList<Number> list = new MyLinkedList<>();
        list.add(1);
        list.add(3d);
        System.out.println(list);
        list.add(1,2f);
        System.out.println(list);
        System.out.println("list.get(2) = " + list.get(2));
        System.out.println("\nlist.remove(2) = " + list.remove(2));
        System.out.println(list);

        System.out.println("Итератор");
        Iterator<Number> it = list.iterator();
        while (it.hasNext())
        {
            System.out.println(it.next());
        }
        list.addAll(List.of(4,5,6,7));
        System.out.println(list);
    }
}


