package programming.set10.histogram;

import java.util.HashMap;

/**
 * Takes a String and generates its histogram.
 */
public class WordHistogram {

    /**
     * How often each word is contained in the inputString. Key: word, value: numberOfOccurrences
     */
    private HashMap<String, Integer> histogram = new HashMap<>();

    /**
     * Counts how often each word is contained in the provided String and saves that data in a
     * histogram.
     * 
     * @param inputString The string to analyse.
     */
    public WordHistogram(String inputString) {
        if (inputString == null) {
            throw new IllegalArgumentException("The input was null.");
        }

        for (String word : inputString.toLowerCase().split(" ")) {
            // If the word-count for the current word is null, set it to 1, otherwise
            // increment the wordcount.
            histogram.merge(word, 1, (oldVal, newVal) -> oldVal + 1);
        }
    }

    /**
     * Returns the number of times the given word appears in the text. The results should ignore
     * case, that is, the Text "The tHe thE" contains the string "THE" three times.
     * 
     * @param word the word to look for.
     * @return the number of times the word occurs in the text, ignoring case.
     * @throws IllegalArgumentException if {@code word == null}.
     */
    public int getOccurrences(String word) {
        if (word == null) {
            throw new IllegalArgumentException("The input was null.");
        }

        String key = word.toLowerCase();

        if (histogram.containsKey(key)) {
            return histogram.get(key);
        } else {
            return 0;
        }
    }
}
