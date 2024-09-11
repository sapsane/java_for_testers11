package ru.STQA.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTests {
    @Test
    void canCalculateArea(){
        assertEquals(6.0, Triangle.printTriangleArea(3.0,4.0,5.0));
    }
    @Test
    void canCalculatePerimetr(){
        assertEquals(12.0, Triangle.perimetr(3, 4, 5));
    }
}
