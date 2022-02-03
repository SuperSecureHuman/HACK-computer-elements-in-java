import java.util.Arrays;

public class cpu_test {
    public static void main(String[] args) {
        int[] inM = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] instruction = { 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1 };
        int reset = 0;
        int[][] output = cpu.CPU(inM, instruction, reset);

        int[] inM2 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] instruction2 = { 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0 };
        int reset2 = 0;

        output = cpu.CPU(inM2, instruction2, reset2);
        int[] inM3 = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] instruction3 = { 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0 };
        int reset3 = 0;

        output = cpu.CPU(inM3, instruction3, reset3);
        System.out.println(Arrays.toString(output[0]));
        System.out.println(Arrays.toString(output[1]));
        System.out.println(Arrays.toString(output[2]));
        System.out.println(Arrays.toString(output[3]));

    }
}
