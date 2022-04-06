package com.github.dmitrypopina.javaschool.lesson1.Ex2;

public enum ShapeType {
    Circle ("Круг"),
    Triangle ("Треугольник"),
    Rect ("Прямоугольник"),
    Square ("Квадрат");

    private final String title;
    ShapeType(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return this.title;
    }
}
