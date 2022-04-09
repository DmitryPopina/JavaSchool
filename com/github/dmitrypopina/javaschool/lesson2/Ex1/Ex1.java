package com.github.dmitrypopina.javaschool.lesson2.Ex1;

import java.util.*;

public class Ex1 {
    public static void main(String[] args){
        List<Car> cars = new ArrayList<>();
        CarLoader.generate(cars);
        Map<String, HashSet<String>> typeCatalog = new HashMap<>();
        for (Car car : cars) {
            if (typeCatalog.containsKey(car.getType())){
                typeCatalog.get(car.getType()).add(car.getModel());
            }else{
                typeCatalog.put(car.getType(), new HashSet<>() {{add(car.getModel());}});
            }
        }
        for (String type : typeCatalog.keySet()) {
            System.out.println(type);
            for (String model : typeCatalog.get(type)){
                System.out.println("|------ " + model);
            }
        }
    }
}
