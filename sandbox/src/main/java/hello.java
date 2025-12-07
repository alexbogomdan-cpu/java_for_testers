public class hello {
    public static void main(String[] args) {
        try {
            calculete();
            System.out.println("Hello, world!");
            System.out.println(6*6);
        } catch (ArithmeticException exception) {
            exception.printStackTrace();
        }

    }

    private static void calculete() {
        var x =1;
        var y =0;
        divide(x, y);
    }

    private static void divide(int x, int y) {
        var z = x / y;
    }
}
