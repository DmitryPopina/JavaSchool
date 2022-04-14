package com.github.dmitrypopina.javaschool.lesson3.Ex1;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<T> implements CountMap<T> {
    private final HashMap<T, Integer> map = new HashMap<>();
    @Override
    public void add(T o) {
        //map.merge(o, 1, (oldValue, newValue) -> ++oldValue);
        map.merge(o, 1, Integer::sum);
    }

    @Override
    public int getCount(T o) {
        return map.getOrDefault(o,0);
    }

    @Override
    public int remove(T o) {
        int cnt = map.getOrDefault(o, 0);
        if (cnt > 0 ) {
            map.remove(o);
        }
        return cnt;
    }

    @Override
    public int size() {
        return map.keySet().size();
    }

    @Override
    public void addAll(CountMap<T> source) {
        source.toMap().forEach((key, value) -> map.merge(key, value, Integer::sum));
    }

    @Override
    public Map<T, Integer> toMap() {
        return map;
    }

    @Override
    public void toMap(Map<T, Integer> destination) {
        destination.putAll(map);
    }
}
