package ru.STQA.geometry.figures;

public class Triangle {

    double sideA= 3.0;
    double sideB= 4.0;
    double sideC= 5.0;

    public Triangle() {
        this.sideA=sideA;
        this.sideB=sideB;
        this.sideC=sideC;

           }


    public static void printTrianglePerimeter(Triangle tr1) {
        String text2 = String.format("Объект периметр треугольника с стороной a=%f b=%f c=%f Perimetr=%f ", 3.0, 4.0,5.0, tr1.perimetr());
        System.out.println(text2);

    }
/*
    public static double perimetr(double a1, double b1, double c1) {
        return a1 + b1 + c1;
    }
*/
    public static double TriangleArea(Triangle tr2) {

        String text = String.format(
                "объект площадь треугольника с стороной a= %f  b= %f c= %f  S=%f", tr2.sideA, tr2.sideB, tr2.sideC  , tr2.TriangleArea());
        System.out.println(text);
        return tr2.TriangleArea();
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