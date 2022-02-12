import java.util.Arrays;

public class cpu {

    public static int[] ARegisterValue = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
    public static int[] DRegisterValue = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

    public static int[] ARegister(int[] in, int load) {
        int[] output = {};
        if (load == 1) {
            output = in;
            ARegisterValue = in;
        } else
            output = ARegisterValue;
        return output;
    }

    public static int[] DRegister(int[] in, int load) {
        int[] output = {};
        if (load == 1) {
            output = in;
            DRegisterValue = in;
        } else
            output = DRegisterValue;
        return output;
    }

    public static int[][] CPU(int[] inM, int[] instruction, int reset) {
        int[] outM = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int writeM = 0;
        int[] addressM = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] pc = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        // Define some needed variables
        int[] ALUout = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };

        /*
         * Not(in=instruction[15], out=Ainstruction);
         * Not(in=Ainstruction, out=Cinstruction);
         */
        int Ainstruction = gate.not(instruction[0]);
        int Cinstruction = gate.not(Ainstruction);
        /*
         * And(a=Cinstruction, b=instruction[5], out=ALUtoA); // C-inst and dest to
         * A-reg
         * Mux16(a=instruction, b=ALUout, sel=ALUtoA, out=Aregin);
         */
        int ALUtoA = gate.and(Cinstruction, instruction[10]);
        int[] Aregin = gate16.mux16(instruction, ALUout, ALUtoA);

        /*
         * Or(a=Ainstruction, b=ALUtoA, out=loadA);
         * ARegister(in=Aregin, load=loadA, out=Aout);
         * 
         */
        int loadA = gate.or(Ainstruction, ALUtoA);
        int[] Aout = ARegister(Aregin, loadA);

        /*
         * Mux16(a=Aout, b=inM, sel=instruction[12], out=AMout); // select A or M based
         * on a-bit
         * And(a=Cinstruction, b=instruction[4], out=loadD);
         * DRegister(in=ALUout, load=loadD, out=Dout); // load the D register from ALU
         */

        int[] AMout = gate16.mux16(Aout, inM, instruction[3]);
        int loadD = gate.and(Cinstruction, instruction[11]);
        int[] Dout = DRegister(ALUout, loadD);

        /*
         * ALU(x=Dout, y=AMout, zx=instruction[11], nx=instruction[10],
         * zy=instruction[9], ny=instruction[8], f=instruction[7],
         * no=instruction[6], out=ALUout, zr=ZRout, ng=NGout); // calculate
         */

        int[][] aluOutput = alu.alu16(Dout, AMout, instruction[4], instruction[5], instruction[6], instruction[7],
                instruction[8], instruction[9]);
        ALUout = aluOutput[0];
        int ZRout = aluOutput[1][0];
        int NGout = aluOutput[2][0];

        /*
         * // Set outputs for writing memory
         * Or16(a=false, b=Aout, out[0..14]=addressM);
         * Or16(a=false, b=ALUout, out=outM);
         * And(a=Cinstruction, b=instruction[3], out=writeM);
         */

        int[] flse = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        int[] addressMTemp = gate16.or16(flse, Aout);
        addressM = Arrays.copyOfRange(addressMTemp, 1, 16);
        outM = gate16.or16(flse, ALUout);
        writeM = gate.and(Cinstruction, instruction[12]);

        /*
         * And(a=ZRout, b=instruction[1], out=jeq); // is zero and jump if zero
         * And(a=NGout, b=instruction[2], out=jlt); // is neg and jump if neg
         * Or(a=ZRout, b=NGout, out=zeroOrNeg);
         */
        int jeq = gate.and(ZRout, instruction[14]);
        int jlt = gate.and(NGout, instruction[13]);
        int zeroOrNeg = gate.or(ZRout, NGout);

        /*
         * Not(in=zeroOrNeg, out=positive); // is positive (not zero and not neg)
         * And(a=positive, b=instruction[0], out=jgt); // is pos and jump if pos
         * Or(a=jeq, b=jlt, out=jle);
         * Or(a=jle, b=jgt, out=jumpToA); // load PC if cond met and jump if cond
         */

        int positive = gate.not(zeroOrNeg);
        int jgt = gate.and(positive, instruction[15]);
        int jle = gate.or(jeq, jlt);
        int jumpToA = gate.or(jle, jgt);

        /*
         * And(a=Cinstruction, b=jumpToA, out=PCload); // Only jump if C instruction
         * Not(in=PCload, out=PCinc); // only inc if not load
         * 
         */
        int PCload = gate.and(Cinstruction, jumpToA);
        int PCinc = gate.not(PCload);

        // PC(in=Aout, inc=PCinc, load=PCload, reset=reset, out[0..14]=pc);

        int[] pcOUT = programCounter.pc(Aout, PCinc, PCload, reset);
        pc = Arrays.copyOfRange(pcOUT, 1, 16);

        int[] WriteM = { 0 };
        WriteM[0] = writeM;
        int[][] output = { outM, WriteM, addressM, pc };
        return output;
    }

}
