package com.github.dmitrypopina.javaschool.lesson2.Ex2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FileStringsBackIterator implements Iterator<String> {
    private final ArrayList<String> strings;

    private int it;

    public FileStringsBackIterator(FileStrings strings) {
        this.strings = strings.getStrings();
        it = this.strings.size();
    }

    @Override
    public boolean hasNext() {
        return it > 0;
    }

    @Override
    public String next() {
        return strings.get(it-- -1);
    }
}
