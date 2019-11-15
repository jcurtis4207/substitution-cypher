/*
 *     This class creates a Cipher object with a field for a substitution cipher 'substituionKey'
 *     The encrypt method is used to encrypt a user-entered string using the 'substitutionKey'
 *     The decrypt method is used to decrypt a user-entered string using the 'substitutionKey'
 *     These objects are created in the EncodePanel and DecodePanel 
 * */
 
public class Cipher {
	private String substitutionKey;
	
	public Cipher(String input) {
		substitutionKey = input;
	}
	
	//Empty constructor for subclass use
	public Cipher() {}
	
	public String getKey(){
		return substitutionKey;
	}
	
	//encrypts 'input' using 'substituionKey', which is passed as a parameter 'encryptKey' from EncodePanel
	public String encrypt(String input, String encryptKey) {
		StringBuilder result = new StringBuilder(input);
		for(int i = 0; i < input.length(); i++) {
			char target = input.charAt(i);
			if(target != ' ') {										//skips spaces
				if(target < 97)
					result.setCharAt(i,' ');						//if not a lower case letter, converts to space
				else { 
					char newChar = (encryptKey.charAt(target-97));	//uses char 'target' to find correct character from encryptKey
					newChar -= 32;									//converts to upper case
					result.setCharAt(i, newChar);					//adds character to 'result' string
				}
			}
		}
		return result.toString();
	}
	
	//decrypts 'input' using 'substitutionKey', which is pass as a parameter 'decryptKey' from DecodePanel
	public String decrypt(String input, String decryptKey) {
		StringBuilder result = new StringBuilder(input);
		for(int i = 0; i< input.length(); i++) {
			char target = input.charAt(i);
			if(target != ' '){										//skips spaces
				if(target < 65)
					result.setCharAt(i,' ');						//if not an upper case letter, converts to space
				else {
					target += 32;									//converts to lower case letter
					int newIndex = decryptKey.indexOf(target);		//finds index of char 'target' in 'decryptKey'
					newIndex += 97;									//convert from 0-25 to ASCII value of character
					result.setCharAt(i,(char)newIndex);				//adds character to 'result' string
				}
			}
		}
		return result.toString();
	}
}
