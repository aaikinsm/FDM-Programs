package com.fdmgroup;
/*8)	Write an algorithm that will check to see if two strings are valid anagrams of one another. 
 * 		(They must have the same letters in different order). You can assume that case sensitivity does not matter 
 * 		(Stop and Pots are valid anagrams), and that you will only be presented words with the letters a-z.*/
public class Q8 {
	public static void main(String[] args) {
		String word1 = "Anagram";
		String word2 = "Nag a ram";
		System.out.println("Are "+word1+" & "+word2+" anagrams? "+ anagram(word1,word2));
		
	}
	
	public static boolean anagram(String word1, String word2){
		String firstWord = word1.toLowerCase().replace(" ", "");
		String secondWord = word2.toLowerCase().replace(" ", "");
		int index;
		for (int i = 0; i<firstWord.length(); i++) {
			index = secondWord.indexOf(firstWord.charAt(i));
			if (index != -1){
				secondWord = secondWord.replaceFirst(""+firstWord.charAt(i), "");
			}else {
				return false;
			}
		}
		if(secondWord.isEmpty()) 
			return true;
		else 
			return false;
	}
}
