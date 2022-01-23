public class gate {

    public static int nand(int a, int b) {
        int out = 1;
        if (a == 1 && b == 1)
            out = 0;
        return out;
    }

    public static int not(int a) {
        int out = nand(a, a);
        return out;
    }

    public static int and(int a, int b) {
        int temp = nand(a, b);
        int out = nand(temp, temp);
        return (out);
    }

    public static int or(int a, int b) {
        int nota = nand(a,a);
        int notb = nand(b,b);
        int out = nand(nota, notb);
        return out;
    }

    public static int xor(int a, int b) {
        int nota = nand(a,a);
        int notb = nand(b,b);
        int w1 = and(a, notb);
        int w2 = and(nota, b);
        int out = or(w1, w2);
        return out;
    }
    public static int mux(int a, int b, int sel){
        int notSel = not(sel);
        int temp1 = and(a , notSel);
        int temp2 = and(b , sel);
        int out = or(temp1 , temp2);
        return out;
    }

    public static int[] halfAdder(int a , int b){
        int[] sumCarry = new int[2];
        int sum = xor(a,b);
        int carry = and(a,b);
        sumCarry[0] = sum;
        sumCarry[1] = carry;
        return sumCarry;
    }
    public static int[] fullAdder(int a, int b, int c){
        int[] sumCarry = new int[2];
        int[] temp1 = halfAdder(a, b);
        int sumAB = temp1[0];
        int carryAB = temp1[1];
        int[] temp2 = halfAdder(sumAB, c);
        int sum = temp2[0];
        int carryABC = temp2[1];
        int carry = xor(carryAB , carryABC);
        sumCarry[0] = sum;
        sumCarry[1] = carry;
        return sumCarry;
    }
}

