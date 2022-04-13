package com.github.dmitrypopina.javaschool.lesson2.Ex2;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

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


            Map<String, FileWord> wordCatalog = new HashMap<>();
            TreeSet<FileWord> tree = new TreeSet<>();
            FileWord tmpWord;
            for (String str : lines){
                for (String wrd : str.toLowerCase().split("[^A-Za-zА-Яа-я]+")){
                    if (wordCatalog.containsKey(wrd)) {
                        wordCatalog.get(wrd).inc();
                    }else {
                        tmpWord = new FileWord(wrd);
                        wordCatalog.put(wrd, tmpWord);
                        tree.add(tmpWord);
                    }
                }
            }
            //Задание 1: Подсчитайте количество различных слов в файле.
            System.out.println("\n<<Решение 1: Подсчитайте количество различных слов в файле>>");
            System.out.println("Количнство различных слов в файле  " + wordCatalog.keySet().size());

            //Задание 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту).
            //Вместо компаратора реализовал compareTo.
            System.out.println("\n<<Решение 2: Выведите на экран список различных слов файла, отсортированный по возрастанию их длины (компаратор сначала по длине слова, потом по тексту)>>");
            for (FileWord wrd: tree) {
                System.out.println(wrd.getWord());
            }


            //Задание 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле.
            System.out.println("\n<<Решение 3: Подсчитайте и выведите на экран сколько раз каждое слово встречается в файле>>");
            for (String wrd : wordCatalog.keySet()) {
                System.out.println(wrd + "  " + wordCatalog.get(wrd).getCount());
            }

            //Задание 4: Выведите на экран все строки файла в обратном порядке
            System.out.println("\n<<Решение 4: Выведите на экран все строки файла в обратном порядке>>");
            TreeSet<String> tStrings = new TreeSet<>(lines);
            Iterator<String> backStringIterator = tStrings.descendingIterator();
            while (backStringIterator.hasNext()) {
                System.out.println(backStringIterator.next());
            }
            //Задание 5: Реализуйте свой Iterator для обхода списка в обратном порядке.
            System.out.println("\n<<Решение 5: Реализуйте свой Iterator для обхода списка в обратном порядке>>");
            FileStrings fStrings = new FileStrings(lines);
            backStringIterator = fStrings.backiterator();
            while (backStringIterator.hasNext()) {
                System.out.println(backStringIterator.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
