public class gate16 {

    public static int[] nand16(int[] a, int[] b) {
        int[] out = new int[16];
        for (int i = 15; i >= 0; i = i - 1) {
            int temp = gate.nand(a[i], b[i]);
            out[i] = temp;
        }
        return out;
    }

    public static int[] not16(int[] a) {
        int[] out = nand16(a, a);
        return out;
    }

    public static int[] and16(int[] a, int[] b) {
        int[] temp = nand16(a, b);
        int[] out = nand16(temp, temp);
        return (out);
    }

    public static int[] or16(int[] a, int[] b) {
        int[] nota = not16(a);
        int[] notb = not16(b);
        int[] out = nand16(nota, notb);
        return out;
    }

    public static int[] xor16(int[] a, int[] b) {
        int[] nota = not16(a);
        int[] notb = not16(b);
        int[] w1 = and16(a, notb);
        int[] w2 = and16(nota, b);
        int[] out = or16(w1, w2);
        return out;
    }

    public static int[] mux16(int[] a, int[] b, int sel) {
        int[] out = new int[16];
        for (int i = 15; i >= 0; i = i - 1) {
            int temp = gate.mux(a[i], b[i], sel);
            out[i] = temp;
        }
        return out;
    }
    public static int[] add16(int[] a, int[] b){
        int[] out = new int[16];
        int[] sumCarry15 = gate.halfAdder(a[15], b[15]);
        out[15] = sumCarry15[0];

        int[] sumCarry14 = gate.fullAdder(a[14], b[14], sumCarry15[1]);
        out[14] = sumCarry14[0];

        int[] sumCarry13 = gate.fullAdder(a[13], b[13], sumCarry14[1]);
        out[13] = sumCarry13[0];

        int[] sumCarry12 = gate.fullAdder(a[12], b[12], sumCarry13[1]);
        out[12] = sumCarry12[0];

        int[] sumCarry11 = gate.fullAdder(a[11], b[11], sumCarry12[1]);
        out[11] = sumCarry11[0];

        int[] sumCarry10 = gate.fullAdder(a[10], b[10], sumCarry11[1]);
        out[10] = sumCarry10[0];

        int[] sumCarry9 = gate.fullAdder(a[9], b[9], sumCarry10[1]);
        out[9] = sumCarry9[0];

        int[] sumCarry8 = gate.fullAdder(a[8], b[8], sumCarry9[1]);
        out[8] = sumCarry8[0];

        int[] sumCarry7 = gate.fullAdder(a[7], b[7], sumCarry8[1]);
        out[7] = sumCarry7[0];

        int[] sumCarry6 = gate.fullAdder(a[6], b[6], sumCarry7[1]);
        out[6] = sumCarry6[0];

        int[] sumCarry5 = gate.fullAdder(a[5], b[5], sumCarry6[1]);
        out[5] = sumCarry5[0];

        int[] sumCarry4 = gate.fullAdder(a[4], b[4], sumCarry5[1]);
        out[4] = sumCarry4[0];

        int[] sumCarry3 = gate.fullAdder(a[3], b[3], sumCarry4[1]);
        out[3] = sumCarry3[0];

        int[] sumCarry2 = gate.fullAdder(a[2], b[2], sumCarry3[1]);
        out[2] = sumCarry2[0];

        int[] sumCarry1 = gate.fullAdder(a[1], b[1], sumCarry2[1]);
        out[1] = sumCarry1[0];

        int[] sumCarry0 = gate.fullAdder(a[0], b[0], sumCarry1[1]);
        out[0] = sumCarry0[0];

        return out;
    }

}
