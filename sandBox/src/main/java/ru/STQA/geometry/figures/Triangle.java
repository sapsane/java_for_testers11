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

    public static double perimetr(double a1, double b1, double c1) {
        return a1 + b1 + c1;
    }

    public static double printTriangleArea(Triangle tr2) {

        String text = String.format(
                "объект площадь треугольника с стороной a= %f  b= %f c= %f  S=%f", tr2.sideA, tr2.sideB, tr2.sideC  , tr2.printTriangleArea1());
        System.out.println(text);
        return tr2.printTriangleArea1();
    }

    public static double halfPerimetr(double a1, double b1, double c1) {
        return perimetr(a1, b1, c1) / 2;
    }

    public double perimetr() {
        return this.sideA+this.sideB+this.sideC;
    }

    public double printTriangleArea1() {
        return Math.sqrt(halfPerimetr(this.sideA, this.sideB, this.sideC) * (halfPerimetr(this.sideA, this.sideB, this.sideC) - this.sideA) * (halfPerimetr(this.sideA, this.sideB, this.sideC) - this.sideB) * (halfPerimetr(this.sideA, this.sideB, this.sideC) - this.sideC));
    }
}