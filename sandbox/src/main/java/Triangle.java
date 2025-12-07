public class Triangle {

    public double side_a;
    public double side_b;
    public double side_c;

    public Triangle(double side_a, double side_b, double side_c) {

        this.side_a = side_a;
        this.side_b = side_b;
        this.side_c = side_c;
        if ( side_a<0 || side_b<0 || side_c<0){
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }
        if ( side_a>(side_b+side_c) || side_b>(side_a+side_c) || side_c>(side_a+side_b)){
            throw new IllegalArgumentException("сумма двух любых сторон должна быть не меньше третьей стороны");
        }
    }

    public static void main(String[] args) {
        printTrianglePerimeter(5.0,6.0,7.0);
        printTriangleAria(5,6,7);

    }

    static void printTrianglePerimeter(double a, double b, double c){
        System.out.println("Периметр треугольника со сторонами a "
                + a + " b " + b + " c " + c + " = " + trianglePerimeter(a, b, c));
    }

    public static double trianglePerimeter(double a, double b, double c) {
        return a + b + c;
    }
    static void printTriangleAria(double a, double b, double c){
        System.out.println("Площадь треугольника со сторонами a "
                + a + " b " + b + " c " + c + " = " + trianglAria(a, b, c));
    }

    public static double trianglAria(double a, double b, double c) {
        return Math.sqrt(((a + b + c) / 2) * (((a + b + c) / 2) - a) * (((a + b + c) / 2) - b) * (((a + b + c) / 2) - c));
    }

    public double Perimeter() {
        return this.side_a + this.side_b + this.side_c;
    }

    public double Aria() {
        return Math.sqrt(((side_a + side_b + side_c) / 2) * (((side_a + side_b + side_c) / 2) - side_a) * (((side_a + side_b + side_c) / 2) - side_b) * (((side_a + side_b + side_c) / 2) - side_c));
    }
}
