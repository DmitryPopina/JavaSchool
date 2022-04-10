package com.github.dmitrypopina.javaschool.lesson2.Ex2;

import java.util.LinkedList;

public class FileWord implements Comparable<FileWord>{
    private final String word;
    private int count;

    public FileWord(String word) {
        this.word = word;
        this.count = 1;
    }

    public int inc(){
        return ++this.count ;
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj.getClass() == this.getClass() && this.word.equals (((FileWord) obj).getWord());
    }

    @Override
    public String toString(){
        return this.word;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
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

