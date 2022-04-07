package com.github.dmitrypopina.javaschool.lesson1.Ex2;

class Circle implements iShape {
    private final int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Circle;
    }

    @Override
    public double getArea() {
        return (Math.PI * Math.pow(this.radius, 2));
    }

    @Override
    public double getPerimeter() {
        return Math.PI * 2 * this.radius;
    }
}

class ZeroCircle extends Circle {

    public static final Circle INSTANCE = new ZeroCircle(0);
    private ZeroCircle(int radius) {
        super(radius);
    }
    @Override
    public double getArea() {
        return (0);
    }

    @Override
    public double getPerimeter() {
        return (0);
    }
}

class Triangle implements iShape {
    private final int side1, side2, side3;

    public static boolean checkTriangle(int side1, int side2, int side3) {
        return (side1 < side2 + side3 ) && (side2 < side1 + side3 ) && (side3 < side1 + side2 );
    }

    public Triangle(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Triangle;
    }

    @Override
    public double getArea() {
        double halfPerimeter = this.getPerimeter() / 2;
        return Math.sqrt(halfPerimeter * (halfPerimeter - this.side1)*(halfPerimeter - this.side2)*(halfPerimeter - this.side3));
    }

    @Override
    public double getPerimeter() {
        return this.side1 + this.side2 + this.side3;
    }
}

class Rect implements iShape {
    protected int side1, side2;

    public Rect(int side1, int side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Rect;
    }

    @Override
    public double getArea() {
        return side1 * side2;
    }

    @Override
    public double getPerimeter() {
        return side1 * side2 * 2;
    }
}

class Square extends  Rect{
    public Square(int side1, int side2) {
        super(side1, side2);
    }

    @Override
    public ShapeType getShapeType() {
        return ShapeType.Square;
    }
}

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
