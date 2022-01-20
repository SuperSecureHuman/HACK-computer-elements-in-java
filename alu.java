public class alu {
    
    public static int[] alu16(int[] x, int[] y, int zx, int nx, int zy, int ny, int f, int no) {
        //Zero x y
        int[] zerosForFalse = new int[16];
        int[] x1 = gate16.mux16(x, zerosForFalse, zx);
        int[] y1 = gate16.mux16(y, zerosForFalse, zy);
        //not x,y
        int[] x2 = gate16.not16(x1);
        int[] x3 = gate16.mux16(x1, x2, nx);
        int[] y2 = gate16.not16(y1);
        int[] y3 = gate16.mux16(y1, y2, ny);

        // f part
        int[] f0 = gate16.and16(x3, y3);
        int[] f1 = gate16.add16(x3, y3);
        int[] fo = gate16.mux16(f0, f1, f);

        // not f part
        int[] notf = gate16.not16(fo);
        int[] output = gate16.mux16(fo, notf, no);
        return output;
    }
    
}
