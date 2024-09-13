package ru.STQA.geometry;

import ru.STQA.geometry.figures.Rectangle;
import ru.STQA.geometry.figures.Square;
import ru.STQA.geometry.figures.Triangle;

import static ru.STQA.geometry.figures.Triangle.halfPerimetr;

public class Geometry2 {
    public static void main(String[] args) {
        var side=7.0;
    //   System.out.println("площадь квадрата со строной " +side + " = " + Square.SquareArea(side));
        Square.printSquareArea(7.0);
    //    Square.printSquareArea(5.0);
    //    Square.printSquareArea(9.1);
        Rectangle.printRectangleArea(3.0, 5.0);
    //    Rectangle.printRectangleArea(7.0,9.0);

    //    var sideA=3.0;
    //    var sideB=4.0;
    //    var sideC=5.0;
    //    System.out.println( "1Площадь треугольника с стороной a " + sideA + " b " + sideB + " c " + sideC +" ="+ Math.sqrt( halfPerimetr(sideA, sideB, sideC) *(halfPerimetr(sideA, sideB, sideC)-sideA) *(halfPerimetr(sideA, sideB, sideC)-sideB)*(((sideA+sideB+sideC )/2)-sideC) )    );
    //    System.out.println( "2периметр треугольника с стороной a " + sideA + " b " + sideB + " c " + sideC +" ="+(sideA+sideB+sideC));
     //   Triangle.printTrianglePerimeter(3.0,4.0,5.0);
     //   Triangle.printTriangleArea(new Triangle(3.0,4.0,5.0));
     //   Triangle.perimetr         (new Triangle(3.0,4.0,5.0));
        Triangle.printTrianglePerimeter(new Triangle());
        Triangle.printTriangleArea(new Triangle());
    }

}
