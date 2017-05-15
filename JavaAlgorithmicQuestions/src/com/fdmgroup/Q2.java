package com.fdmgroup;

/*Write a program that asks the user to enter an integer value, then print out following text according to the entered number: 
Assume user entered 4.
- - - - 1 - - - -
- - 2 - 2 - -
- 3 - 3 - 3 -
4 - 4 - 4 - 4*/

public class Q2 {
	public static void main(String[] args) {
		
		int num = 9;
		
		for (int i =1; i<=num; i++){
			for (int j = 0; j<(num*2); j++){
				if(j<(num-i) || j>=(num+i)){
					System.out.print("-");
				}
				else if((j-i)%2==0){
					System.out.print(i);
				}
				else
					System.out.print("-");
			}
			System.out.println();
		}
	}
}
