package com.fdmgroup;

/*1)	Write a program that merges two sorted arrays.*/
public class Q1 {
	public static void main(String[] args) {
		int[] arr1 = {3,5,34,44,61,400}; 
		int[] arr2 = {1,3,6,8,47,75,86,355};
		int maxSize = arr1.length + arr2.length;
		int[] arr3 = new int[maxSize];
		int index1=0, index2=0, index3=0;
		
		while (index3 < maxSize) {
			
			if (index2 == arr2.length){
				arr3[index3] = arr1[index1];
				index1++;
				index3++;
			}
			else if(index1 == arr1.length){
				arr3[index3] = arr2[index2];
				index2++;
				index3++;
			}
			else if (arr1[index1] >= arr2[index2]){
				arr3[index3] = arr2[index2];
				index2++;
				index3++;
			}else if(arr1[index1] < arr2[index2]){
				arr3[index3] = arr1[index1];
				index1++;
				index3++;
			}
			
		}
		for (int i : arr3) {
			System.out.print(i+",");			
		}
	}
}
