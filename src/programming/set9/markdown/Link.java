package programming.set9.markdown;

/**
 * Represents a link that consists of a descriptive text and the URL it links to.
 */
public class Link {
	
	/** The link's descriptive text. */
	private final String description;
	/** The link's URL. */
	private final String url;
	
	
	/**
	 * Creates a new instance.
	 * 
	 * @param description the link's descriptive text.
	 * @param url the URL the link links to.
	 */
	public Link(String description, String url) {
		this.description = description;
		this.url = url;
	}

	
	/**
	 * Returns the link's description.
	 * 
	 * @return the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Returns the link's URL.
	 * 
	 * @return the URL.
	 */
	public String getURL() {
		return url;
	}
}
