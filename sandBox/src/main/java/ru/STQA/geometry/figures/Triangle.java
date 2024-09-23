package ru.STQA.geometry.figures;

public class Triangle {

    double sideA;
    double sideB;
    double sideC;

    public Triangle() {
        this.sideA=3.0;
        this.sideB=4.0;
        this.sideC=5.0;
    if (sideA < 0 ||sideB < 0 || sideC <0) {
        throw new IllegalArgumentException("сторона стреугольника не должна быть  меньше 0 нуля");
    }
    if (((sideA + sideB) < (sideC)) || ((sideB + sideC) < (sideA)) || ((sideA + sideC) < (sideB)) ){
        throw new IllegalArgumentException("ошибка!!! сумма двух строн должна быть больше третьей стороны");
    }

    }


    public static void printTrianglePerimeter(Triangle tr1) {

        String text2 = String.format("Объект периметр треугольника с стороной a=%f b=%f c=%f Perimetr=%f ",tr1.sideA, tr1.sideB,tr1.sideC, tr1.perimetr());
        System.out.println(text2);

    }
/*
    public static double perimetr(double a1, double b1, double c1) {
        return a1 + b1 + c1;
    }
*/
    public static void printTriangleArea(Triangle tr2) {

        String text = String.format(
                "объект площадь треугольника с стороной a= %f  b= %f c= %f  S=%f", tr2.sideA, tr2.sideB, tr2.sideC  , tr2.TriangleArea());
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