package programming.set9.dna;

/**
 * DNAMatcher
 */
public class DNAMatcher {
    public String baseDNA;

    DNAMatcher(String inputDNA) {
        String baseDNA = inputDNA.trim();
        if (baseDNA == null || baseDNA == "") {
            throw new IllegalArgumentException("The provided String was empty or null.");
        }

        if (!inputDNA.matches("[ACGT ]+")) {
            throw new IllegalArgumentException("The provided String contains illegal characters.");
        }

        this.baseDNA = baseDNA;
    }
}