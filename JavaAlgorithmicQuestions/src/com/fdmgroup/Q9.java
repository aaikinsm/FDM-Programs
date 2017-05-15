package com.fdmgroup;
/*9)	Write an algorithm that will check to see if a number is a valid palindrome 
 * 		(If it is reversed, it is the same number. E.g. 123454321 is a palindrome).
 */
public class Q9 {
	public static void main(String[] args) {
		int number = 123454321;
		System.out.println("Is "+number+" a palindrome? "+isPalindrome(number));
		
	}
	
	private static boolean isPalindrome(int num){
		String word = num+"";
		for (int i=0; i<word.length()/2; i++){
			if(word.charAt(i) != word.charAt(word.length()-i-1))
				return false;
		}
		return true;
	}
}
