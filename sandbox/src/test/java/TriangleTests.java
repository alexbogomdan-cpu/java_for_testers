import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculatePerimeter(){
        var t = new Triangle(5,6,7);
        double result = t.Perimeter();
        Assertions.assertEquals(18,result);

    }
    @Test
    void canCalulateArea(){
        var t = new Triangle(5,6,7);
        double result = t.Aria();
        Assertions.assertEquals(14.696938456699069,result);
    }
    @Test
    void cannotCreateTriangleWithnegativSide (){
        try {
            new Triangle(-5,6,7);
            Assertions.fail();
        } catch (IllegalArgumentException exception){
            //Ok
        }
    }
    @Test
    void cannotCreateTriangleWithsumoftwosides() {
        try {
            new Triangle(20, 6, 7);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            //Ok
        }
    }
    @Test
    void testEquality1() {
        var t1 = new Triangle(3, 4, 5);
        var t2 = new Triangle(4, 5, 3);
        Assertions.assertEquals( t1, t2);
    }
    @Test
    void testEquality5(){
        var a = 2;
        var b = 3;
        var c = 4;
        var triangle = new Triangle(a, b, c);
        var triangle1 = new Triangle(c, a, b);
        Assertions.assertEquals(triangle, triangle1);
    }
}
