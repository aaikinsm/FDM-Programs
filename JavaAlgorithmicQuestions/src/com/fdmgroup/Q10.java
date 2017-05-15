package com.fdmgroup;
/*10)	Write an algorithm to find the most frequent integer in an array*/
public class Q10 {
	public static void main(String[] args) {
		
		int[] array = {4,6,2,8,4,2,34,1,5,8,38,3,1,3,7,4};
		System.out.println("Most frequent integer is: "+getMaxFreq(array));
	}
	
	private static int getMaxFreq(int... array){
		int max = 0, maxCount=0, count = 0;
		for (int i=0; i<array.length-1; i++){
			count = 0;
			for (int j=i+1; j<array.length; j++){
				if(array[i]==array[j]) count++;
			}
			if(count>maxCount){ 
				max=array[i];
				maxCount = count;
			}
		}
		return max;
	}
}
