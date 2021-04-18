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

	public ArrayList<Block<String>> getBlockchain() {
		return this.blockchain;
	}

	/**
	 * Checks if blockchain is valid and that nothing has changed in the process
	 * 
	 * @param blockchain The blockchain to be checked
	 * @return A boolean whether or not it's valid or not
	 */
	public static Boolean isValid(Blockchain BC) {
		Block<String> currentBlock;
		Block<String> previousBlock;

		ArrayList<Block<String>> blockchain = BC.getBlockchain();

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
		Blockchain BC = new Blockchain();
		ArrayList<Block<String>> blockchain = BC.getBlockchain();

		blockchain.add(new Block<String>("1st block", null));
		blockchain.add(new Block<String>("2nd block", blockchain.get(blockchain.size() - 1).getHash()));
		blockchain.add(new Block<String>("3rd block", blockchain.get(blockchain.size() - 1).getHash()));
		blockchain.add(new Block<String>("4th block", blockchain.get(blockchain.size() - 1).getHash()));
		blockchain.add(new Block<String>("5th block", blockchain.get(blockchain.size() - 1).getHash()));

		System.out.println(Blockchain.isValid(BC));
	}
}
