package extraCredit1302;

/*
 *    This class creates RandomCipher objects
 *    Each object gets a random substitution cipher, created by calling 'randomSort' on a sorted string of characters from a to z
 *    RandomCipher objects can also call encrypt and decrypt from the parent Cipher class
 */
import java.util.Random;

public class RandomCipher extends Cipher{
	private String alphabet = "abcdefghijklmnopqrstuvwxyz";
	private String substitutionKey;
	
	public RandomCipher() {
		//Creates a randomized version of alphabet string
		substitutionKey = randomSort(alphabet);
	}
	
	public String getKey(){
		return substitutionKey;
	}
	
	public String randomSort(String input) {
		Random rand = new Random();
		int size = input.length();
		StringBuilder newList = new StringBuilder(input);
		for(int i = 0; i < 25; i++) {
			int randomNumber = rand.nextInt(size)+i;
			char temp = newList.charAt(i);
			newList.setCharAt(i,newList.charAt(randomNumber));
			newList.setCharAt(randomNumber,temp);
			size--;
		}
		return newList.toString();
	}
}