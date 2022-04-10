package com.github.dmitrypopina.javaschool.lesson2.Ex2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args){
        try {
            Scanner scanner = new Scanner(Paths.get("C:\\Users\\popina\\IdeaProjects\\JavaSchool\\com\\github\\dmitrypopina\\javaschool\\lesson2\\Ex2\\test.txt"));
            ArrayList<String> lines = new ArrayList<>();

            while (scanner.hasNextLine()){
                lines.add(scanner.nextLine());
            }
            System.out.println("Начало задания. выводим строки в прямом порядке");
            for (String str : lines){
                //str.split("\\W");
                System.out.println(str);
            }

            System.out.println("Решение 4: Выведите на экран все строки файла в обратном порядке");
            FileStrings fStrings = new FileStrings(lines);
            Iterator<String> backStringIterator = fStrings.backiterator();
            while (backStringIterator.hasNext()) {
                System.out.println(backStringIterator.next());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
