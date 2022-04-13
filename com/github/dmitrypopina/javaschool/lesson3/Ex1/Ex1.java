package com.github.dmitrypopina.javaschool.lesson3.Ex1;

public class Ex1 {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();

        map.add(10);
        map.add(10);
        map.add(5);
        map.add(6);
        map.add(5);
        map.add(10);

        System.out.println("Первоначальный список:");
        map.toMap().forEach((key, value) -> System.out.println("Count " + key + " " + value));

        System.out.println("Запросы из задания:");
        int count;
        count = map.getCount(5); // 2
        System.out.println("Count 5 " + count);
        count = map.getCount(6); // 1
        System.out.println("Count 6 " + count);
        count = map.getCount(10); // 3
        System.out.println("Count 10 " + count);

        CountMap<Integer> nmap = new CountMapImpl<>();
        nmap.add(10);
        nmap.add(10);
        nmap.add(5);
        nmap.add(6);
        nmap.add(5);
        nmap.add(10);

        System.out.println("Список после удвоения:");
        map.addAll(nmap);
        map.toMap().forEach((key, value) -> System.out.println("Count " + key + " " + value));


        count = map.remove(10);
        System.out.println("Count 10 до удаления " + count);
        count = map.remove(5);
        System.out.println("Count 5 до удаления " + count);
        count = map.remove(6);
        System.out.println("Count 6 до удаления " + count);
        //проверяем что не свалится
        count = map.remove(6);
        System.out.println("Count 6 до удаления " + count);

        System.out.println("Список после удаления:");
        map.toMap().forEach((key, value) -> System.out.println("Count " + key + " " + value));

    }
}
