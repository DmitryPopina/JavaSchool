package com.github.dmitrypopina.javaschool.lesson1;

import java.util.Scanner;
class Ex1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] mas = new int[10];
        int y = 0, cnt = 0;
        System.out.print("Введите целые числа через пробел, до 10 чисел: ");
        while (y < mas.length){
            if (! console.hasNext()){
                console.close();
                break;
            }
            if (console.hasNextInt()) {
                mas[y] = console.nextInt();
                cnt ++;
            }else{
                console.next();
            }
            y++;
        }

        System.out.println("Массив до сортировки: ");
        for (int i = 0; i < cnt; i++){
            System.out.print(mas[i] + " ");
        }

        for (int i = cnt-1; i > 0 ; i--){
            for (int j = 0; j  < i; j++) {
                if (mas[j] > mas[j+1]){
                    y = mas[j+1];
                    mas[j+1] = mas[j];
                    mas[j] = y;
                }
            }
        }

        System.out.print("\nМассив после сортировки: ");
        for (int i = 0; i < cnt; i++){
            System.out.print(mas[i] + " ");
        }
    }
}