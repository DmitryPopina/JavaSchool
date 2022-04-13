package com.github.dmitrypopina.javaschool.lesson3.Ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Ex2 {
    public static void main(String[] args) {
        List <Number> list = new ArrayList<>(Arrays.asList(8,1,3,5,6,4));
        System.out.println(CollectionUtils.containsAll(list, Arrays.asList(1,3,4,5,6,8)));
        System.out.println(CollectionUtils.containsAll(list, Arrays.asList(1,2,3,4,5,6,8)));
        System.out.println(CollectionUtils.containsAny(list, Arrays.asList(1,9, 10, 11)));
        System.out.println(CollectionUtils.containsAny(list, Arrays.asList(9, 10, 11)));
        System.out.println(CollectionUtils.range(Arrays.asList(8,1,3,5,6, 4), 3, 6));
        CollectionUtils.add(list, 2d);
        System.out.println(list);
        System.out.println(CollectionUtils.indexOf(list, 2d));
        CollectionUtils.removeAll(list, Arrays.asList(2d, 8));
        System.out.println(list);
        CollectionUtils.addAll(Arrays.asList(2d, 8), list);
        System.out.println(list);
        System.out.println(CollectionUtils.limit(list, 4));
        Comparator<Integer> cmp = Comparator.comparingInt(o -> o);
        System.out.println(CollectionUtils.range(Arrays.asList(8,2,1,3,5,6, 4), 3, 10, cmp));
    }
}
