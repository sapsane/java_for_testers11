package ru.STQA.geometry.figures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTests {
    @Test
    void canCalculateArea(){
        var s = new Triangle();
        s.sideA=3;
        s.sideB=4;
        s.sideC=5;
        assertEquals(6.0, s.TriangleArea());
    }
    @Test
    void canCalculatePerimetr(){
        var s2 = new Triangle();
        s2.sideA=3;
        s2.sideB=4;
        s2.sideC=5;
        assertEquals(12.0, s2.perimetr());
    }
}
