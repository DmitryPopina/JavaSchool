package com.github.dmitrypopina.javaschool.lesson3.Ex3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class MyLinkedList<E> {
    private ArrayList<E> list = new ArrayList<>();

    public boolean add(E e) {
        return list.add(e);
    }
    public void add(int index, E element) {
        list.add(index, element);
    }
    public E get(int index) throws IllegalArgumentException {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть меньше 0");
        }else if (index >= list.size()) {
            throw new IllegalArgumentException("Индекс не может быть больше числа элементов списка");
        }
        return list.get(index);
    }
    public E remove(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть меньше 0");
        }else if (index >= list.size()) {
            throw new IllegalArgumentException("Индекс не может быть больше числа элементов списка");
        }
        return list.remove(index);
    }

    public Iterator<E> iterator(){
        return list.iterator();
    }

    public  boolean addAll(Collection<? extends E> c){
        return list.addAll(c);
    }

    public boolean copy(Collection<? extends E> c){
        ArrayList<E> tmplist = new ArrayList<>(list);
        try {
            list.clear();
            list.addAll(c);
            return true;
        }
        catch (Exception e){
            list = tmplist;
        }
        return false;
    }

    public String toString(){
        return list.toString();
    }
}
