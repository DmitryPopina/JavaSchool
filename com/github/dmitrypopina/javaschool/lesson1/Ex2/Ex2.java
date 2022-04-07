package com.github.dmitrypopina.javaschool.lesson1.Ex2;

import java.util.Scanner;

class Ex2 {
    public static void main(String[] args) {
        int[] len = new int[3];
        Scanner console = new Scanner(System.in);
        iShape Shape;
        int cnt = 0;
        String text;
        System.out.print("Введите до 3х длин через пробел или Enter, завершите ввод символом !: ");
        while (cnt < 3){
            if (! console.hasNext()) {
                console.close();
                break;
            }
            if (console.hasNextInt()) {
                len[cnt] = console.nextInt();
                cnt ++;
            }else {
                text = console.next();
                if (text.compareTo("!") == 0){
                    break;
                }
            }
        }
        try {
            Shape = iShape.getShape(len, cnt);
        } catch (Exception e) {
            System.out.print("\nНе получилось создать фигуру\n");
            System.out.print(e.getMessage());
            return;
        }
        System.out.print("\nПолучена фигура: " + Shape.getShapeType());
        System.out.print("\nПлощадь фигуры: " + Shape.getArea());
        System.out.print("\nПериметр фигуры: " + Shape.getPerimeter());
    }
}