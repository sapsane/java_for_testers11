public class Geometry2 {
    public static void main(String[] args) {
        var side=7.0;
        System.out.println("площадь квадрата со строной " +side + " = " + SquareArea(side));
        printSquareArea(7.0);
        printSquareArea(5.0);
        printSquareArea(9.1);
        printRectangleArea(3.0, 5.0);
        printRectangleArea(7.0,9.0);
    }

    private static void printRectangleArea(double a, double b) {
        System.out.println("площадь прямоугольника со стронами " + a + " и " + b + " = " + RectangleArea(a,b));
    }

    private static double RectangleArea(double a, double b) {
        return a * b;
    }

    static void printSquareArea (double side) {
        System.out.println("площадь квадрата со строной " +side + " = " + SquareArea(side));

    }

    private static double SquareArea(double a) {
        return a * a;
    }
}
