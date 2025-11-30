public class Triangle {
    public static void main(String[] args) {
        var side_a = 5.;
        var side_b = 6.;
        var side_c = 7.;
        var semi_p = ((side_a + side_b + side_c)/2) ;
        System.out.println("Периметр треугольника со сторонами a "
                + side_a + " b " + side_b + " c " + side_c + " = " + (side_a + side_b + side_c));
        System.out.println("Площадь треугольника со сторонами a "
                + side_a + " b " + side_b + " c " + side_c + " = " + Math.sqrt(semi_p*(semi_p-side_a)*(semi_p-side_b)*(semi_p-side_c)));

    }
}
