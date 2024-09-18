package ru.STQA.geometry.figures;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTests {
    @Test
    void canCalculateArea(){
        var s = new Triangle(3.0,4.0,5.0);
        assertEquals(6.0, s.TriangleArea());
    }
    @Test
    void canCalculatePerimetr(){
        assertEquals(12.0, new Triangle(3.0,4.0,5.0).perimetr());
    }
}
