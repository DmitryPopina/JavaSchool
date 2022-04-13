package com.github.dmitrypopina.javaschool.lesson3.Ex2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    public static <T> List<? super T> limit(List<? extends T> source, int size) {
        return null;
    }

    public static <T> void add(List<? super T> source, T o) {
        source.add(o);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? super T> c1, List<? extends T>  c2) {
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? super T> c1, List<? extends T>  c2) {
        for (T t : c2) {
            if (c1.contains(t)) {
                return true;
            }
        }
        return false;
    }

    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        List<T> res = new ArrayList<>(list);
        if (min == null || max == null) {
            res.clear();
        } else {
            res.removeIf(x -> !(x.compareTo(min) >= 0 && x.compareTo(max) <= 0));
        }
        return res;
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        List<T> res = new ArrayList<>(list);
        if (min == null || max == null) {
            res.clear();
        } else {
            res.removeIf(x -> !(comparator.compare( x, min) >= 0 && comparator.compare(x, max) <= 0));
        }
        return res;
    }
}
