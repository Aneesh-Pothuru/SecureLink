import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Aneesh Pothuru and Edgar Villanueva
 * @version April 2021
 */
public class Encrypt {

    /**
     * @param data
     * @return byte[]
     * @throws NoSuchAlgorithmException
     */
    public static byte[] getBytes(String data) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(data.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * @param data
     * @return String of encrypted data
     */
    public static String SHA256(String data) {
        BigInteger number = new BigInteger(1, data.getBytes());
        try {
            number = new BigInteger(1, Encrypt.getBytes(data));
        } catch (Exception e) {
        }
        StringBuilder hex = new StringBuilder(number.toString(16));
        while (hex.length() < 32) {
            hex.insert(0, '0');
        }
        return hex.toString();
    }

}
