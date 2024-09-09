package ru.STQA.geometry.figures;

public class Square {
    public static void printSquareArea (double side) {
        String text = String.format(
                "площадь квадрата со строной %f = %f", side, SquareArea(side));
        System.out.println(text);


    }

    static double SquareArea(double a) {
        return a * a;
    }
}
