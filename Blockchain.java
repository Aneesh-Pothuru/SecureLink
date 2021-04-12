import java.util.ArrayList;
/**
 * @author Aneesh Pothuru and Edgar Villanueva
 * @version April 2021
 */
public class Blockchain {

    /**
     * The blockchain in array list format
     */
	private ArrayList<Block<String>> blockchain;

    /**
     * Constructor for the Blockchain class
     */
	public Blockchain() {
		blockchain = new ArrayList<>();
	}

    /**
     * Adds a block to the blockchain
     * @param b The block to be added
     */
	public void add(Block<String> b) {
		this.blockchain.add(b);
	}

    /**
     * Gets the size of the blockchain
     * @return The size of the blockchain
     */
	public int size() {
		return this.blockchain.size();
	}

    /**
     * Gets the block at a certain index within the blockchain
     * @param index The chosen index within the blockchain
     * @return The block corresponding to given index
     */
	public Block<String> get(int index) {
		return this.blockchain.get(index);
	}

    /**
     * Checks if blockchain is valid and that nothing has changed in the process
     * @param blockchain The blockchain to be checked
     * @return A boolean whether or not it's valid or not
     */
	public static Boolean isValid(Blockchain blockchain) {
		Block<String> currentBlock;
		Block<String> previousBlock;

		for (int i = 1; i < blockchain.size(); i++) {
			currentBlock = blockchain.get(i);
			previousBlock = blockchain.get(i - 1);

			if (!currentBlock.getHash().equals(currentBlock.dataHash())) {
				return false;
			}

			if (!previousBlock.getHash().equals(currentBlock.getPrevHash())) {
				return false;
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Blockchain blockchain = new Blockchain();

		blockchain.add(new Block<String>("1st block", null));
		blockchain.add(new Block<String>("2nd block", blockchain.get(blockchain.size() - 1).getHash()));
		blockchain.add(new Block<String>("3rd block", blockchain.get(blockchain.size() - 1).getHash()));
		blockchain.add(new Block<String>("4th block", blockchain.get(blockchain.size() - 1).getHash()));
		blockchain.add(new Block<String>("5th block", blockchain.get(blockchain.size() - 1).getHash()));

		System.out.println(Blockchain.isValid(blockchain));
	}
}
