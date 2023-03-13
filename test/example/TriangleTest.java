package example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TriangleTest { 
	 
    @Test 
    public void equilateralHasThreeEqualSides() throws Exception { 
        Triangle triangle1 = new Triangle(2, 2, 2); 
        Triangle triangle2 = new Triangle(Double.MIN_VALUE, Double.MIN_VALUE, Double.MIN_VALUE);
        Triangle triangle3 = new Triangle(Double.MAX_VALUE, Double.MAX_VALUE, Double.MAX_VALUE);
        assertEquals(TriangleKind.EQUILATERAL, triangle1.getKind());
        assertEquals(TriangleKind.EQUILATERAL, triangle2.getKind()); 
        assertEquals(TriangleKind.EQUILATERAL, triangle3.getKind()); 
    } 
    
    @Test
    public void isoscelesHasTwoEqualSides() throws Exception {
    	Triangle triangle1 = new Triangle(4, 4, 2);
    	Triangle triangle2 = new Triangle(1, 3, 3);
    	Triangle triangle3 = new Triangle(2, 1, 2);
    	assertEquals(TriangleKind.ISOSCELES, triangle1.getKind());
    	assertEquals(TriangleKind.ISOSCELES, triangle2.getKind());
    	assertEquals(TriangleKind.ISOSCELES, triangle3.getKind());
    }
    
    @Test
    public void scaleneHasNoEqualSides() throws Exception {
    	Triangle triangle1 = new Triangle(4, 2, 3);
    	Triangle triangle2 = new Triangle(7, 5, 4);
    	assertEquals(TriangleKind.SCALENE, triangle1.getKind());
    	assertEquals(TriangleKind.SCALENE, triangle2.getKind());
    }
    
    @Test
    public void throwsWhenAllSidesAreZero() {
        assertThrows(TriangleException.class, () -> new Triangle(0, 0, 0));
    }
    
    @Test
    public void throwsWhenViolatingTriangleInequality() {
    	assertThrows(TriangleException.class, () -> new Triangle(5, 5, 10));
    	assertThrows(TriangleException.class, () -> new Triangle(3, 4, 1));
    }
    
    @Test
    public void throwsWhenHavingImpossibleSides() {
    	assertThrows(TriangleException.class, () -> new Triangle(0, 1, 2));
    	assertThrows(TriangleException.class, () -> new Triangle(1, 0, 2));
    	assertThrows(TriangleException.class, () -> new Triangle(1, 2, 0));
    	assertThrows(TriangleException.class, () -> new Triangle(-1, 2, 3));
    }
    
    @Test
    public void testGetNumberOfUniqueSides() throws TriangleException {
    	Triangle triangle1 = new Triangle(4, 2, 3);
    	Triangle triangle2 = new Triangle(2, 2, 3);
    	Triangle triangle3 = new Triangle(3, 3, 3);
    	assertEquals(3, triangle1.getNumberOfUniqueSides());
    	assertEquals(2, triangle2.getNumberOfUniqueSides());
    	assertEquals(1, triangle3.getNumberOfUniqueSides());
    }
}