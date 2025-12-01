import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculatePerimeter(){
        double result = Triangle.trianglePerimeter(5,6,7);
        Assertions.assertEquals(18,result);

    }
    @Test
    void canCalulateArea(){
        double result = Triangle.trianglAria(5,6,7);
        Assertions.assertEquals(14.696938456699069,result);
    }
}
