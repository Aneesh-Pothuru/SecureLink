import java.time.Instant;

/**
 * @author Aneesh Pothuru and Edgar Villanueva
 * @version April 2021
 */
public class Block<T> {
    /**
     * hash uses SHA256 to get encryption string
     */
    private String hash;
    /**
     * prevHash uses SHA256 to get encryption string and is the hash of previous
     * data
     */
    private String prevHash;
    /**
     * data is a generic object
     */
    private T data;
    /**
     * utcCreated is the time it was created in UTC time
     */
    private long utcCreated;

    /**
     * @param data
     * @param prevHash
     */
    public Block(T data, String prevHash) {
        this.data = data;
        this.prevHash = prevHash;
        this.utcCreated = Instant.now().getEpochSecond();
        this.hash = this.dataHash();
    }

    /**
     * @return hash created using data, utc created, and previous hash to make
     *         unique hash for the data
     */
    public String dataHash() {
        return Encrypt.SHA256(data.hashCode() + Long.toString(utcCreated) + this.getPrevHash());
    }

    /**
     * @return hash
     */
    public String getHash() {
        return hash;
    }

    /**
     * @param hash
     */
    public void setHash(String hash) {
        this.hash = hash;
    }

    /**
     * @return prevHash
     */
    public String getPrevHash() {
        return prevHash;
    }

    /**
     * @param prevHash
     */
    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    /**
     * @return utcCreated
     */
    public long getUtcCreated() {
        return utcCreated;
    }

}
