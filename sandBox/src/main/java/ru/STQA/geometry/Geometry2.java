package ru.STQA.geometry;

import ru.STQA.geometry.figures.Rectangle;
import ru.STQA.geometry.figures.Square;

public class Geometry2 {
    public static void main(String[] args) {
        var side=7.0;
      //  System.out.println("площадь квадрата со строной " +side + " = " + Square.SquareArea(side));
        Square.printSquareArea(7.0);
        Square.printSquareArea(5.0);
        Square.printSquareArea(9.1);
        Rectangle.printRectangleArea(3.0, 5.0);
        Rectangle.printRectangleArea(7.0,9.0);
    }

}
