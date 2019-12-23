package programming.set8.bff;

/**
 * An interpreter for the esoteric programming-language Brainfuck.
 */
public class BrainfuckInterpreter {
    /** The program as entered by the user. */
    private char[] program;
    /** The cells the program operates on. */
    private byte[] cells = new byte[1024];

    /**
     * constructs an BF-Interpreter from a String.
     * 
     * @param input a String containing Brainfuck-Code (or not, I'm not your mum).
     */
    public BrainfuckInterpreter(String input) {
        this(input.toCharArray());
    }

    /**
     * Constructs an BF-Interpreter from an array of chars.
     * 
     * @param inputChars an array of chars, where the chars are instructions (or
     *                   comments).
     */
    public BrainfuckInterpreter(char[] inputChars) {
        // Check if every bracket has a partner.
        int bracketDepth = 0;
        for (char c : inputChars) {
            if (c == '[') {
                bracketDepth++;
            } else if (c == ']') {
                bracketDepth--;
            }
        }
        if (bracketDepth != 0) {
            throw new IllegalArgumentException("There's at least one lonely brackets in your program.");
        }

        this.program = inputChars;
    }

    /**
     * Interprets the loaded program and returns the console-output.
     * 
     * @return the console-output.
     */
    public String interpret() {
        // Which cell we're currently looking at.
        int cellPointer = 0;
        String consoleOutput = "";

        // Iterate over every element of the program.
        for (int i = 0; i < program.length; i++) {
            // Execute commands, or do nothing if the char isn't recognized.
            switch (program[i]) {
            case '<':
                if (cellPointer == 0) {
                    cellPointer = program.length - 1;
                } else {
                    cellPointer--;
                }
                break;
            case '>':
                if (cellPointer == program.length - 1) {
                    cellPointer = 0;
                } else {
                    cellPointer++;
                }
                break;
            case '+':
                cells[cellPointer]++;
                break;
            case '-':
                cells[cellPointer]--;
                break;
            case '.':
                consoleOutput += (char) cells[cellPointer];
                break;
            case '/':
                cells[cellPointer] *= 2;
                break;
            case '[':
                if (cells[cellPointer] == 0) {
                    i = findCorrespondingBracket(i);
                }
                break;

            case ']':
                if (cells[cellPointer] != 0) {
                    i = findCorrespondingBracket(i);
                }
                break;

            default:
                break;
            }
        }

        return consoleOutput;
    }

    /**
     * Finds the index of the counterpart of a bracket. Basically parship for
     * brackets.
     * 
     * @param bracketIndex The index of the bracket that is looking for its partner.
     * @return The index of the supplied bracket's counterpart.
     */
    private int findCorrespondingBracket(int bracketIndex) {
        // How many other bracket pairs are nested within the bracket pair we're trying
        // to find.
        int bracketDepth = 0;

        switch (program[bracketIndex]) {
        case '[':
            // Look for a counterpart after the supplied bracket.
            for (int j = bracketIndex + 1; j < cells.length - 1; j++) {
                // The char we're looking at currently.
                char c = program[j];

                if (c == ']') {
                    if (bracketDepth == 0) {
                        return j;
                    } else {
                        bracketDepth--;
                    }
                } else if (c == '[') {
                    bracketDepth++;
                }
            }
            break;

        case ']':
            // Look for a counterpart before the supplied bracket.
            for (int j = bracketIndex - 1; j >= 0; j--) {
                // The char we're looking at currently.
                char c = program[j];

                if (c == '[') {
                    if (bracketDepth == 0) {
                        return j;
                    } else {
                        bracketDepth--;
                    }
                } else if (c == ']') {
                    bracketDepth++;
                }
            }
            break;

        default:
            throw new IllegalArgumentException("The supplied index points to a non-bracket char.");

        }

        return -1;
    }

    /*
     * public static void main(String[] args) { String program =
     * "Prints Yo! to the console+//////+++++++++++++++++++++++++.>+///////-----------------.>+/////+"
     * ; System.out.println(new BrainfuckInterpreter(program).interpret()); String
     * anothaOne =
     * "++++++++[>++++[>++>+++>+++>+<<<<-]>+>+>->>+[<]<-]>>.>---.+++++++..+++.>>.<-.<.+++.------.--------.>>+.>++.";
     * System.out.println(new BrainfuckInterpreter(anothaOne).interpret()); }
     */
}