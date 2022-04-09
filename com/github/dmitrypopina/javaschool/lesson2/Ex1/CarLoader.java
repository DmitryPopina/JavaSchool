package com.github.dmitrypopina.javaschool.lesson2.Ex1;

import java.util.Collection;

public class CarLoader {
    public static void generate(Collection<Car> cars) {
        cars.add(new Car("Лада", "седан"));
        cars.add(new Car("Лада", "хэтчбек"));
        cars.add(new Car("Мерседес", "седан"));
        cars.add(new Car("Бмв", "кроссовер"));
        cars.add(new Car("Форд", "хэтчбек"));
        cars.add(new Car("Пежо ", "кроссовер"));
        cars.add(new Car("Тойота", "седан"));
        cars.add(new Car("Тойота", "кроссовер"));
        cars.add(new Car("Лада", "кроссовер"));
    }
}
