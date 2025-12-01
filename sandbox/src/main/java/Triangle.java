public class Triangle {
    public static void main(String[] args) {
        printTrianglePerimeter(5.0,6.0,7.0);
        printTriangleAria(5,6,7);

    }

    static void printTrianglePerimeter(double a, double b, double c){
        System.out.println("Периметр треугольника со сторонами a "
                + a + " b " + b + " c " + c + " = " + trianglePerimeter(a, b, c));
    }

    private static double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }
    static void printTriangleAria(double a, double b, double c){
        System.out.println("Площадь треугольника со сторонами a "
                + a + " b " + b + " c " + c + " = " + trianglAria(a, b, c));
    }

    private static double trianglAria(double a, double b, double c) {
        return Math.sqrt(((a + b + c) / 2) * (((a + b + c) / 2) - a) * (((a + b + c) / 2) - b) * (((a + b + c) / 2) - c));
    }
}
