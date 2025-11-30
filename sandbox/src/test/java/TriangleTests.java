import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {
    @Test
    void canCalculateArea(){
        var side_a = 5.;
        var side_b = 6.;
        var side_c = 7.;
        var semi_p = ((side_a + side_b + side_c)/2);
        void result = System.out.println("Периметр треугольника со сторонами a "
                + side_a + " b " + side_b + " c " + side_c + " = " + (side_a + side_b + side_c));
        Assertions.assertEquals(18., + (side_a + side_b + side_c));

    }
}
