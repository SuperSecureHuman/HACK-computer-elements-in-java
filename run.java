import java.util.Arrays;

public class run {

    public static void main(String[] args) {
        int[] x = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1 };
        int[] y = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1 };
        int zx = 0;
        int nx = 1;
        int zy = 1;
        int ny = 1;
        int f = 1;
        int no = 1;
        System.out.print("\nThe output is ");
        System.out.println(Arrays.toString(alu.alu16(x, y, zx, nx, zy, ny, f, no)[0]));

    }
}
