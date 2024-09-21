package ru.STQA.geometry.figures;

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
        assertEquals(12.0, s2.perimetr());
    }
}
