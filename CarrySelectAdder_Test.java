import java.util.Arrays;

public class CarrySelectAdder_Test {

    public static void main(String[] args) {
        int[] x = new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 };
        int[] y = new int[] { 1, 0, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 0 };

        System.out.println("Result is: " + Arrays.toString(carrySelectAdder.csl(x, y, 0)[0]));
        System.out.println("Carry is is: " + Arrays.toString(carrySelectAdder.csl(x, y, 0)[1]));
    }

}
