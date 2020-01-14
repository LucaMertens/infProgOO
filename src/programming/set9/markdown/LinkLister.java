package programming.set9.markdown;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Provides a method to collect all links from a markdown String.
 */
public class LinkLister {
    /** This pattern will match Descriptions and links in two different groups. */
    static final Pattern LINK_PATTERN = Pattern.compile("\\[(\\b[^\\[\\]]+\\b)\\]\\(([^\\(\\)\\s]+)\\)");

    /**
     * Extracts all links from the given Markdown-formatted String and returns them
     * in a handy list.
     * 
     * @param markdown a Markdown-formatted String.
     * @return possibly empty list of links in the order they appeared in the text.
     */
    public static List<Link> extractLinks(String markdown) {
        ArrayList<Link> result = new ArrayList<>();
        if (markdown == null) {
            return result;
        }

        // Create a Matcher with the input-String. No actual matching happens here.
        Matcher linkMatcher = LINK_PATTERN.matcher(markdown);
        //
        while (linkMatcher.find()) {
            // The description will be captured in the first group.
            String description = linkMatcher.group(1);
            // The url will be captured in the second group.
            String url = linkMatcher.group(2);

            if (description != null) {
                result.add(new Link(description, url));
            }
        }
        return result;
    }

}