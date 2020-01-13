package programming.set9.morses;

import java.util.HashMap;

/**
 * A morse de- and encoder.
 */
public class MorseCoder {

    /** Every letter of the english alphabet as morse code, where index 0 is "A". */
    private static final String[] MORSE_ALPHABET = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..",
            ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.." };
    /** The numbers from 0-9 as morse code, where index 0 is the number 0. */
    private final static String[] MORSE_NUMBERS = { "-----", ".----", "..---", "...--", "....-", ".....", "-....",
            "--...", "---..", "----." };

    /**
     * A map with morse codes as keys and the corresponding characters as values.
     * Eg.: Key: ".-", Value: "A".
     */
    private static final HashMap<String, Character> MORSE_TABLE = new HashMap<>();
    // Fill the Hashmap from morseAlphabet and morseNumbers.
    static {
        for (int i = 0; i < MORSE_ALPHABET.length; i++) {
            final String morseLetter = MORSE_ALPHABET[i];
            final char translation = (char) ('A' + i);

            MORSE_TABLE.put(morseLetter, translation);
        }

        for (int i = 0; i < MORSE_NUMBERS.length; i++) {
            final String morseNumber = MORSE_NUMBERS[i];
            final char translation = (char) ('0' + i);

            MORSE_TABLE.put(morseNumber, translation);
        }

    }

    /**
     * Returns a new string which is the Morse code version of the input string.
     * Each word in the output will be on a separate line. The Morse representation
     * of each character of the input string is separated from the next by a space
     * character in the output string.
     * 
     * @param input the input string.
     * @return the Morse code version of the input string, ignoring all characters
     *         in the input string that cannot be represented in international Morse
     *         code.
     */
    public static String encode(String input) {
        if (input == null) {
            return null;
        }
        String result = "";

        // Iterate over words.
        for (String word : input.split(" ")) {
            // Iterate over each character of each word.
            for (char c : word.toCharArray()) {
                // Case will be ignored in morse-code.
                c = Character.toLowerCase(c);

                // If the character is a number, look in the number-array.
                if ('0' <= c && c <= '9') {
                    result += MORSE_NUMBERS[c - '0'] + " ";
                }

                // If the character is a letter, look in the letter-array.
                if ('a' <= c && c <= 'z') {
                    result += MORSE_ALPHABET[c - 'a'] + " ";
                }
            }
            result += "\n";
        }

        // Remove unnecessary whitespace.
        return result.trim();
    }

    /**
     * Returns a new string which is the natural-language version of the input
     * string, which is assumed to be in Morse code format as produced by the encode
     * method.
     * 
     * @param input morse code input string.
     * @return natural language version or {@code null} if the input string could
     *         not be properly parsed.
     */
    public static String decode(String input) {
        if (input == null) {
            return null;
        }

        String result = "";

        for (String word : input.split("\n")) {
            // Iterate over each encoded letter.
            for (String morseLetter : word.split(" ")) {
                // Only try to decode the letter if a translation exists.
                if (MORSE_TABLE.containsKey(morseLetter)) {
                    result += MORSE_TABLE.get(morseLetter);
                }
            }
            result += " ";
        }

        // Remove extra whitespace after the decoded string.
        result = result.trim();

        if (result.equals("")) {
            return null;
        }

        return result;
    }

}