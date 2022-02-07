public class programCounter {
    static int[] out = new int[16];

    public static int[] pc(int in[], int inc, int load, int reset) {
        int [] zero = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};

        if (reset == 1) {
            out = zero;
        } else if (load == 1) {
            out = in;
        } else if (inc == 1) {
            int[] one = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 };
            int [][] tmp = gate16.add16(out, one);
            out = tmp[0];
        }
        return out;
    }
}