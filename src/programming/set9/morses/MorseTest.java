package programming.set9.morses;

import acm.program.ConsoleProgram;

/**
 * MorseTest
 */
public class MorseTest extends ConsoleProgram {
    @Override
    public void run() {
        String morse = MorseCoder.encode("Thou shalt not produce bugs.");
        print(morse);
        print(MorseCoder.decode(morse));
        print(MorseCoder.encode("Thi(s"));
        print("test");
    }

    public static void main(String[] args) {
        new MorseTest().start();
    }

}