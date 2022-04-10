package com.github.dmitrypopina.javaschool.lesson2.Ex2;

import java.util.LinkedList;

public class FileWord implements Comparable<FileWord>{
    private final String word;
    private int count;
    private final String key;

    public FileWord(String word) {
        this.word = word;
        this.count = 1;
        this.key = word.toLowerCase();
    }

    public int inc(){
        return ++this.count ;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null) {
            if (obj.getClass() == String.class) {
                return this.word.equalsIgnoreCase(obj.toString());
            }else if (obj.getClass() == this.getClass()){
                return this.word.equalsIgnoreCase(((FileWord) obj).getWord());
            } else {
                return false;
            }
        }
        return false;
        //return obj != null && obj.getClass() == this.getClass() && this.word.equalsIgnoreCase(((FileWord) obj).getWord());
    }

    @Override
    public String toString(){
        return this.word;
    }

    public String getWord() {
        return this.word;
    }

    public int getCount() {
        return this.count;
    }

    public String getKey() {
        return key;
    }

    @Override
    public int compareTo(FileWord o) {
        if (word.length() == o.getWord().length()){
            return word.compareTo(o.getWord());
        }else {
            return word.length() < o.getWord().length() ? -1 : 1;
        }
    }
}

