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
}
