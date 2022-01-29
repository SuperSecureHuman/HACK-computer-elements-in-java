public class carrySelectAdder {
    //this implements the carry select adder in java

    public static int[][] csl(int[] a, int[] b, int c){

        int[] outputSum = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int carry = 0;

        //------------------ Block 0 - 0 -3 bits------------------

        //carry 0 
        int[] sumCarry00 = gate.fullAdder(a[15], b[15], 0);
        int[] sumCarry01 = gate.fullAdder(a[14], b[14], sumCarry00[1]);
        int[] sumCarry02 = gate.fullAdder(a[13], b[13], sumCarry01[1]);
        int[] sumCarry03 = gate.fullAdder(a[12], b[12], sumCarry02[1]);
        

        //carry 1
        int[] sumCarry10 = gate.fullAdder(a[15], b[15], 1);
        int[] sumCarry11 = gate.fullAdder(a[14], b[14], sumCarry10[1]);
        int[] sumCarry12 = gate.fullAdder(a[13], b[13], sumCarry11[1]);
        int[] sumCarry13 = gate.fullAdder(a[12], b[12], sumCarry12[1]);

        //mux selecting the output
        int carryOut1 = gate.mux(sumCarry03[1], sumCarry13[1], c);

        //mux deciding the output sum
        outputSum[15] = gate.mux(sumCarry00[0], sumCarry10[0], c);
        outputSum[14] = gate.mux(sumCarry01[0], sumCarry11[0], c);
        outputSum[13] = gate.mux(sumCarry02[0], sumCarry12[0], c);
        outputSum[12] = gate.mux(sumCarry03[0], sumCarry13[0], c);

        //------------------ Block 1 - 4 -7 bits------------------

        //carry 0
        int[] sumCarry04 = gate.fullAdder(a[11], b[11], 0);
        int[] sumCarry05 = gate.fullAdder(a[10], b[10], sumCarry04[1]);
        int[] sumCarry06 = gate.fullAdder(a[9], b[9], sumCarry05[1]);
        int[] sumCarry07 = gate.fullAdder(a[8], b[8], sumCarry06[1]);

        //carry 1
        int[] sumCarry14 = gate.fullAdder(a[11], b[11], 1);
        int[] sumCarry15 = gate.fullAdder(a[10], b[10], sumCarry14[1]);
        int[] sumCarry16 = gate.fullAdder(a[9], b[9], sumCarry15[1]);
        int[] sumCarry17 = gate.fullAdder(a[8], b[8], sumCarry16[1]);

        //mux selecting the output
        int carryOut2 = gate.mux(sumCarry07[1], sumCarry17[1], carryOut1);

        //mux deciding the output sum
        outputSum[11] = gate.mux(sumCarry04[0], sumCarry14[0], carryOut1);
        outputSum[10] = gate.mux(sumCarry05[0], sumCarry15[0], carryOut1);
        outputSum[9] = gate.mux(sumCarry06[0], sumCarry16[0], carryOut1);
        outputSum[8] = gate.mux(sumCarry07[0], sumCarry17[0], carryOut1);

        //------------------ Block 2 - 8 -11 bits------------------

        //carry 0
        int[] sumCarry08 = gate.fullAdder(a[7], b[7], 0);
        int[] sumCarry09 = gate.fullAdder(a[6], b[6], sumCarry08[1]);
        int[] sumCarry010 = gate.fullAdder(a[5], b[5], sumCarry09[1]);
        int[] sumCarry011 = gate.fullAdder(a[4], b[4], sumCarry010[1]);

        //carry 1
        int[] sumCarry18 = gate.fullAdder(a[7], b[7], 1);
        int[] sumCarry19 = gate.fullAdder(a[6], b[6], sumCarry18[1]);
        int[] sumCarry110 = gate.fullAdder(a[5], b[5], sumCarry19[1]);
        int[] sumCarry111 = gate.fullAdder(a[4], b[4], sumCarry110[1]);

        //mux selecting the output
        int carryOut3 = gate.mux(sumCarry011[1], sumCarry111[1], carryOut2);

        //mux deciding the output sum
        outputSum[7] = gate.mux(sumCarry08[0], sumCarry18[0], carryOut2);
        outputSum[6] = gate.mux(sumCarry09[0], sumCarry19[0], carryOut2);
        outputSum[5] = gate.mux(sumCarry010[0], sumCarry110[0], carryOut2);
        outputSum[4] = gate.mux(sumCarry011[0], sumCarry111[0], carryOut2);

        //------------------ Block 3 - 12 -15 bits------------------

        //carry 0
        int[] sumCarry012 = gate.fullAdder(a[3], b[3], 0);
        int[] sumCarry013 = gate.fullAdder(a[2], b[2], sumCarry012[1]);
        int[] sumCarry014 = gate.fullAdder(a[1], b[1], sumCarry013[1]);
        int[] sumCarry015 = gate.fullAdder(a[0], b[0], sumCarry014[1]);

        //carry 1
        int[] sumCarry112 = gate.fullAdder(a[3], b[3], 1);
        int[] sumCarry113 = gate.fullAdder(a[2], b[2], sumCarry112[1]);
        int[] sumCarry114 = gate.fullAdder(a[1], b[1], sumCarry113[1]);
        int[] sumCarry115 = gate.fullAdder(a[0], b[0], sumCarry114[1]);

        //mux selecting the output
        int carryOut4 = gate.mux(sumCarry015[1], sumCarry115[1], carryOut3);

        //mux deciding the output sum
        outputSum[3] = gate.mux(sumCarry012[0], sumCarry112[0], carryOut3);
        outputSum[2] = gate.mux(sumCarry013[0], sumCarry113[0], carryOut3);
        outputSum[1] = gate.mux(sumCarry014[0], sumCarry114[0], carryOut3);
        outputSum[0] = gate.mux(sumCarry015[0], sumCarry115[0], carryOut3);

        carry = carryOut4;
        
        int[][] output = {outputSum, {carry}};

        return output;

    }
}

