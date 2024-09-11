package ru.STQA.geometry.figures;

public class Rectangle {
    public static void printRectangleArea(double a, double b) {
        String text = String.format(
                "площадь прямоугольника со стронами %f и %f=%f ", a , b , RectangleArea(a, b));
        System.out.println(text);
    }

    private static double RectangleArea(double a, double b) {
        return a * b;
    }
}
