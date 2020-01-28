package programming.set11.brownies;

/**
 * Basically a Hashmap, but not as sophisticated.
 * 
 * @param <K> The type of the key.
 * @param <V> The type of the value.
 */
public class BrownieMap<K, V> {

    /** Every element of the map will be put in on of these buckets. */
    private HashEntry<K, V>[] buckets;

    /**
     * The capacity sets the length of the bucket array.
     * 
     * @param numberOfBuckets bucket array length
     * @throws IllegalArgumentException if the number of buckets is smaller than one.
     */
    public BrownieMap(int numberOfBuckets) {
        if (numberOfBuckets < 1) {
            throw new IllegalArgumentException();
        }
        buckets = new HashEntry[numberOfBuckets];
    }

    /*
     * Scans the entry chain looking for an entry that matches the specified key. If no such entry
     * exists, findEntry returns null.
     */
    private HashEntry<K, V> findEntry(HashEntry<K, V> entry, K key) {
        while (entry != null) {
            if (entry.getKey() == key) {
                return entry;
            }
            entry = entry.getLink();
        }
        return null;
    }

    /**
     * Put an item into the map.
     * 
     * @param key   the key of the item.
     * @param value the value of the item.
     * @throws IllegalArgumentException if the key or the value is {@code null}.
     */
    public void put(K key, V value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException();
        }

        // Which bucket the item will be put in.
        int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
        // Create the HashEntry from the arguments.
        HashEntry<K, V> entry = findEntry(buckets[bucketIndex], key);
        if (entry == null) {
            // Create the entry and add it to the
            entry = new HashEntry<K, V>(key, value);
            // Add the new entry to the start of the linked list.
            entry.setLink(buckets[bucketIndex]);
            // The new first element of the linked list is now the new entry.
            buckets[bucketIndex] = entry;
        } else {
            // If there's already an element with that key, simply update it.
            entry.setValue(value);
        }
    }

    /**
     * Returns the value of a given key.
     * 
     * @param key the key of the item.
     * @return the value belonging to that key or {@code null} if no value is mapped to that key.
     * @throws IllegalArgumentException if the key is {@code null}.
     */
    public V get(K key) {
        if (key == null) {
            throw new IllegalArgumentException("yeet");
        }

        int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
        HashEntry<K, V> currentEntry = buckets[bucketIndex];

        HashEntry<K, V> foundEntry = findEntry(currentEntry, key);

        return foundEntry == null ? null : foundEntry.getValue();
    }

    /**
     * Removes one key and its value from the map. If the key does not exist in the map, nothing
     * happens.
     * 
     * @param key the key.
     * @throws IllegalArgumentException if the key is {@code null}.
     */
    public void remove(K key) {
        if (key == null) {
            throw new IllegalArgumentException("yeet");
        }

        int bucketIndex = Math.abs(key.hashCode()) % buckets.length;
        HashEntry<K, V> currentEntry = buckets[bucketIndex];

        if (currentEntry.getKey() == key) {
            // Special case: The first element will be removed.
            currentEntry = currentEntry.getLink();
            return;
        }

        while (currentEntry.getLink() != null) {
            if (currentEntry.getLink().getKey() == key) {
                // This should not result in an error, because the first getLink() won't be null.
                HashEntry<K, V> nextEntry = currentEntry.getLink().getLink();
                currentEntry.setLink(nextEntry);
                return;
            }

            currentEntry = currentEntry.getLink();
        }


    }

    /**
     * Clears the entire map.
     */
    public void clear() {
        int numberOfBuckets = buckets.length;
        buckets = new HashEntry[numberOfBuckets];
    }
}


/**
 * This class represents a pair of a key and a value, along with a reference to the next HashEntry
 * in the chain. The methods exported by the class consist only of getters and setters.
 * 
 * @param <K> The type of the key.
 * @param <V> The type of the value.
 */
class HashEntry<K, V> {
    /** The key component for this HashEntry. */
    private K key;
    /** The value component for this HashEntry. */
    private V value;
    /** The next entry in the chain. */
    private HashEntry<K, V> link;

    /**
     * Creates a new HashEntry for the specified key/value pair.
     * 
     * @param key   The key.
     * @param value The value.
     */
    public HashEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    /**
     * Returns the key component of a HashEntry.
     * 
     * @return The key.
     */
    public K getKey() {
        return key;
    }

    /**
     * Returns the value component of a HashEntry.
     * 
     * @return The value.
     */
    public V getValue() {
        return value;
    }

    /**
     * Sets the value component of a HashEntry to a new value.
     * 
     * @param value The value.
     */
    public void setValue(V value) {
        this.value = value;
    }

    /**
     * Returns the next link in the entry chain.
     * 
     * @return The link.
     */
    public HashEntry<K, V> getLink() {
        return link;
    }



    /**
     * Sets the link to the next entry in the chain.
     * 
     * @param link The link to set.
     */
    public void setLink(HashEntry<K, V> link) {
        this.link = link;
    }

}
