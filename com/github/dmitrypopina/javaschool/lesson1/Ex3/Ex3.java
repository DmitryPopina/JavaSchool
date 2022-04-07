package com.github.dmitrypopina.javaschool.lesson1.Ex3;

import java.util.Scanner;

public class Ex3 {
    public static void main(String[] args) {
        double degree;
        ConvertBuilder converterBuilder = new ConvertBuilder();
        Converter converter;
        Scanner console = new Scanner(System.in);
        double celsius;
        String text;

        System.out.print("Выберите один из вариантов конвертации: " + converterBuilder + " ");
        text = console.next();

        if (text.length() ==1) {
            try{
                converter = converterBuilder.getConverter(text.charAt(0));
                System.out.print("\nВведите значение в градусах Цельсия для конвертации: ");
                if (console.hasNextDouble()) {
                    celsius = console.nextDouble();
                    System.out.print("\nСконвертированное значение = " + converter.convertTo(celsius));
                } else {
                    System.out.print("\nПереданно неверное значение температуры");
                }
            } catch (IllegalArgumentException e) {
                System.out.print("\nНе получилось создать конвертер температур: " + e.getMessage());
            }

        }
        //Пробуем расширенный список видов конвертации
        converterBuilder = new AdvancedConvertBuilder();
        System.out.print("\nВыберите один из вариантов конвертации: " + converterBuilder + " ");
        text = console.next();

        if (text.length() ==1) {
            try {
                converter = converterBuilder.getConverter(text.charAt(0));
                System.out.print("\nВведите значение в градусах Цельсия для конвертации: ");
                if (console.hasNextDouble()) {
                    celsius = console.nextDouble();
                    System.out.print("\nСконвертированное значение = " + converter.convertTo(celsius));
                } else {
                    System.out.print("\nПереданно неверное значение температуры");
                    console.close();
                }
            } catch (IllegalArgumentException e) {
                System.out.print("\nНе получилось создать конвертер температур: " + e.getMessage());
            }
        }
    }
}
