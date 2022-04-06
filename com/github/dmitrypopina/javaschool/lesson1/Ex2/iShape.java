package com.github.dmitrypopina.javaschool.lesson1.Ex2;

import java.util.Arrays;

public interface iShape {
    static iShape getShape(int[] len, int cnt) throws Exception {
        switch (cnt) {
            case (1) :
                return  getShape(len[0]);
            case (2) :
                return  getShape(len[0], len[1]);
            case (3) :
                return  getShape(len[0], len[1], len[2]);
            default:
                throw new Exception("Количество сторон должно быть от 1, 2 или 3");
        }
    }
    static iShape getShape(int len) throws Exception {
        if (len > 0) {
            return new Circle(len);
        }else if (len == 0){
            return ZeroCircle.INSTANCE;
        }else{
            throw new Exception("Радиус должен быть не меньше нуля");
        }
    }
    static iShape getShape(int len1, int len2, int len3) throws Exception {
        if (Triangle.checkTriangle(len1, len2, len3)) {
            return new Triangle(len1, len2, len3);
        }else {
            throw new Exception("Невозможно создать треуголник с такими длинами сторон");
        }
    }
    static iShape getShape(int len1, int len2) throws Exception {
        if (len1 < 0 || len2 < 0) {
            throw new Exception("Стороны прямоуголника должны быть больше 0");
        }
        if (len1 == len2) {
            return new Square(len1, len2);
        } else {
            return new Rect(len1, len2);
        }
    }
    ShapeType getShapeType();
    double getArea();
    double getPerimeter();
}
