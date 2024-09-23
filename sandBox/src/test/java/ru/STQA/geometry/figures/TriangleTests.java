package ru.STQA.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTests {
    @Test
    void canCalculateArea(){
        var s = new Triangle();
        assertEquals(6.0, s.TriangleArea());
    }
    @Test
    void canCalculatePerimetr(){
        var s2 = new Triangle();
        double result=s2.perimetr();
        assertEquals(12.0,result );

    }
    @Test
    void cannotCreateTriangleWithNegativeSide(){
       try{
           new Triangle();
           Assertions.fail();
       } catch(IllegalArgumentException exception){
           // OK
       }


    }
    @Test
    void canNotSummaDvuhStoronMensheTretiej(){
        try{
            new Triangle();
            Assertions.fail();
        } catch(IllegalArgumentException exception){
            System.out.println("Ошибка! сумма двух строн должна быть больше третьей стороны");
        }


    }
}
