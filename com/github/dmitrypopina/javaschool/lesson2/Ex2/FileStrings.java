package com.github.dmitrypopina.javaschool.lesson2.Ex2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileStrings implements  Iterable<String> {
    private final ArrayList<String> strings;
    public FileStrings(ArrayList<String> strings){
        this.strings = strings;
    }

    @Override
    public Iterator<String> iterator() {
        return strings.iterator();
    }

    public Iterator<String> backiterator() {
        return new FileStringsBackIterator(this);
    }

    public ArrayList<String> getStrings() {
        return strings;
    }
}

