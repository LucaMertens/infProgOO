package programming.set9.dna;

/**
 * Holds a String that other Strings can be matched against.
 */
public class DNAMatcher {
    /** The DNA to match other DNAs against. */
    private String baseDNA;

    /**
     * Constructs a DNAMatcher from a String.
     * 
     * @param inputDNA The string to store.
     */
    public DNAMatcher(String inputDNA) {
        if (inputDNA == null || inputDNA.equals("")) {
            throw new IllegalArgumentException("The provided String was empty or null.");
        }
        // The input may only contain the following chars: A,C,G,T.
        if (!inputDNA.matches("[ACGT]+")) {
            throw new IllegalArgumentException("The provided String contains illegal characters.");
        }

        this.baseDNA = inputDNA;
    }

    /**
     * Returns the index of the first position in the base DNA string where
     * candidateDNA can bind, if any.
     * 
     * @param candidateDNA the DNA string to try to bind to the base DNA.
     * @return index of the first binding position or {@code -1} if the candidate
     *         DNA string cannot bind to the base string.
     * @throws IllegalArgumentException if {@code candidateDNA} is {@code null},
     *                                  empty, or contains characters other than A,
     *                                  C, G, and T.
     */
    public int findFirstBindingPosition(String candidateDNA) {
        String stringToFind = toDNAComplement(candidateDNA);

        return findFirstSubstring(stringToFind);
    }

    /**
     * Converts a DNA-String to its dockable counterpart. Example: ATCG --> TAGC.
     * 
     * @param input a DNA-String.
     * @return The converted counterpart.
     */
    private static String toDNAComplement(String input) {
        String result = "";
        for (char base : input.toCharArray()) {
            switch (base) {
            case 'A':
                result += 'T';
                break;
            case 'T':
                result += 'A';
                break;
            case 'C':
                result += 'G';
                break;
            case 'G':
                result += 'C';
                break;
            default:
                throw new IllegalArgumentException();
            }
        }
        return result;
    }

    /**
     * Finds the first occurrence of a substring in baseDNA.
     * 
     * @param stringToFind The substring to find in baseDNA.
     * @return The index of the substring-start, or -1, if it wasn't found.
     */
    private int findFirstSubstring(String stringToFind) {
        // Find the first occurrence of the first character in stringToFind.
        int latestFind = indexOf(stringToFind.charAt(0), 0);

        // It doesn't make sense to look for a substring after this value.
        int lastPossibleIndex = baseDNA.length() - stringToFind.length();

        while (latestFind <= lastPossibleIndex && latestFind >= 0) {

            // The elements after our found index.
            String rest = baseDNA.substring(latestFind, latestFind + stringToFind.length());

            if (stringToFind.equals(rest)) {
                return latestFind;
            }

            // Go to the next occurrence of the first element of our input String.
            latestFind = indexOf(stringToFind.charAt(0), latestFind + 1);
        }

        // No match was found.
        return -1;
    }

    /**
     * Finds first occurence (starting at searchFrom) of the provided char in the
     * baseDNA-String.
     * 
     * @param charToFind The char to find in baseDNA.
     * @param searchFrom At which index to start looking in the array.
     * @return The index where the char was found (this can be the same index as
     *         searchFrom) or -1, if it wasn't found.
     */
    private int indexOf(char charToFind, int searchFrom) {
        // Iterate over every char of baseDNA
        for (int i = searchFrom; i < baseDNA.length(); i++) {
            if (baseDNA.charAt(i) == charToFind) {
                return i;
            }
        }
        return -1;
    }

}