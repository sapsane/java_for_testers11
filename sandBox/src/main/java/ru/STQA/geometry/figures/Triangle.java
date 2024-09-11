package ru.STQA.geometry.figures;

public class Triangle {
    public static void printTrianglePerimeter(double a1, double b1, double c1) {
        String text2 = String.format("функция периметр треугольника с стороной a=%f b=%f c=%f Perimetr=%f ", a1, b1, c1, perimetr(a1, b1, c1));
        System.out.println(text2);

    }

    public static double perimetr(double a1, double b1, double c1) {
        return a1 + b1 + c1;
    }

    public static double printTriangleArea(double sideA, double sideB, double sideC) {

        String text = String.format(
                "функция площадь треугольника с стороной a= %f  b= %f c= %f  S=%f", sideA, sideB, sideC, Math.sqrt(halfPerimetr(sideA, sideB, sideC) * (halfPerimetr(sideA, sideB, sideC) - sideA) * (halfPerimetr(sideA, sideB, sideC) - sideB) * (halfPerimetr(sideA, sideB, sideC) - sideC)));
        System.out.println(text);
        return Math.sqrt(halfPerimetr(sideA, sideB, sideC) * (halfPerimetr(sideA, sideB, sideC) - sideA) * (halfPerimetr(sideA, sideB, sideC) - sideB) * (halfPerimetr(sideA, sideB, sideC) - sideC));
    }

    public static double halfPerimetr(double a1, double b1, double c1) {
           return perimetr(a1, b1, c1) / 2;
       }
}
