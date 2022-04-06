package com.github.dmitrypopina.javaschool.lesson1.Ex2;

import java.util.Scanner;

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

class Ex2 {
    public static void main(String[] args) {
        int[] len = new int[3];
        Scanner console = new Scanner(System.in);
        iShape Shape;
        int cnt = 0;
        String text;
        System.out.print("Введите до 3х длин через пробел или Enter, завершите ввод символом !: ");
        while (cnt < 3){
            if (! console.hasNext()) {
                console.close();
                break;
            }
            if (console.hasNextInt()) {
                len[cnt] = console.nextInt();
                cnt ++;
            }else {
                text = console.next();
                if (text.compareTo("!") == 0){
                    break;
                }
            }
        }
        try {
            Shape = iShape.getShape(len, cnt);
        } catch (Exception e) {
            System.out.print("\nНе получилось создать фигуру\n");
            System.out.print(e.getMessage());
            return;
        }
        System.out.print("\nПолучена фигура: " + Shape.getShapeType());
        System.out.print("\nПлощадь фигуры: " + Shape.getArea());
        System.out.print("\nПериметр фигуры: " + Shape.getPerimeter());
    }
}