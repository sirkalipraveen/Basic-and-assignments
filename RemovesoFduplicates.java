package Week3day1;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class RemovesoFduplicates {

	public static void main(String[] args) {
		String name="PayPal India";
		char[]charArray= name.toCharArray();
		int CharArray=charArray.length;
		System.out.println("Number of characters in the given String: "+charArray.length);
		Set<Character> charSet=new HashSet<Character>();
		Set<Character> dupCharSet=new HashSet<Character>();
		for (char character : charArray) {
			if(charSet.contains(character)) {
				dupCharSet.add(character);
			}else {
				charSet.add(character);
				}
		}
		for (Character character : dupCharSet) {
			charSet.remove(character);
		}
		System.out.println("size of charset after duplicate removal: "+charSet.size());
		for (Character character2 : charSet) {
			if(!Character.isWhitespace(character2)) {
				System.out.println(character2);
			}
		} 
	}



	}


