package ru.STQA.geometry.figures;

public class Triangle {

    double sideA;
    double sideB;
    double sideC;

    public Triangle() {


           }


    public static void printTrianglePerimeter(Triangle tr1) {
        Triangle myTriangle=new Triangle();
        myTriangle.sideA=3;
        myTriangle.sideB=4;
        myTriangle.sideC=5;
        String text2 = String.format("Объект периметр треугольника с стороной a=%f b=%f c=%f Perimetr=%f ",myTriangle.sideA, myTriangle.sideB,myTriangle.sideC, myTriangle.perimetr());
        System.out.println(text2);

    }
/*
    public static double perimetr(double a1, double b1, double c1) {
        return a1 + b1 + c1;
    }
*/
    public static void printTriangleArea(Triangle tr2) {
        Triangle myTriangle=new Triangle();
        myTriangle.sideA=3;
        myTriangle.sideB=4;
        myTriangle.sideC=5;
        String text = String.format(
                "объект площадь треугольника с стороной a= %f  b= %f c= %f  S=%f", myTriangle.sideA, myTriangle.sideB, myTriangle.sideC  , myTriangle.TriangleArea());
        System.out.println(text);

    }

    public  double halfPerimetr() {
        return perimetr() / 2;
    }

    public double perimetr() {
        return this.sideA+this.sideB+this.sideC;
    }

    public double TriangleArea() {
        return Math.sqrt(halfPerimetr() * (halfPerimetr() - this.sideA) * (halfPerimetr() - this.sideB) * (halfPerimetr() - this.sideC));
    }
}