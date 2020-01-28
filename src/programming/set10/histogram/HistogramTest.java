package programming.set10.histogram;

/**
 * HistogramTest
 */
public class HistogramTest {

    public static void main(String[] args) {
        WordHistogram h =
                new WordHistogram("Dance dance dANce dAncE unTil until the sun Sun comes up up");
        assert h.getOccurrences("dance") == 4 : "wubbel != 1";
        assert h.getOccurrences("wubsbel") == 0 : "wubsbel != 0";

    }
}
