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
    @Test
    void testEquality(){
        var tr1= new Triangle();
        tr1.sideA=3;
        tr1.sideB=4;
        tr1.sideC=5;

        var tr2= new Triangle();
        tr2.sideA=4;
        tr2.sideB=5;
        tr2.sideC=3;

    Assertions.assertEquals(tr1,tr2);
    }
}
