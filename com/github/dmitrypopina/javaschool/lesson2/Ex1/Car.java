package com.github.dmitrypopina.javaschool.lesson2.Ex1;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Car {
    String model;
    String type;

    public Car(String model, String type) {
        this.model = model;
        this.type = type;
    }


    @Override
    public boolean equals(Object obj) {
        return obj.getClass() == this.getClass() && this.type.equals(((Car) obj).getType()) && this.model.equals(((Car) obj).getModel());
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }
}

