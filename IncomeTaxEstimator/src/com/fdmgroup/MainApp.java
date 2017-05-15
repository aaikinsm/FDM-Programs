package com.fdmgroup;

import java.util.Scanner;

public class MainApp {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter your annual taxable income");
		float annualIncome = input.nextFloat();
		
		System.out.println("Enter your Semi-Monthly CPP paid: ");
		float cpp = input.nextFloat();
		
		System.out.println("Enter your Semi-Monthly EI paid: ");
		float ei = input.nextFloat();
		
		input.close();

		float federalTax;		
		if(annualIncome <= 45916){
			federalTax = (float) ((annualIncome - 0) * 0.15);
		}
		else if (annualIncome <= 91831){
			federalTax = (float) ((annualIncome - 45916) * 0.205);
			federalTax += 6887;
		}
		else if (annualIncome <= 142353){
			federalTax = (float) ((annualIncome - 91831) * 0.26);
			federalTax += 16300;
		}
		else if (annualIncome <= 202800){
			federalTax = (float) ((annualIncome - 142353) * 0.29);
			federalTax += 29436;
		}else{
			federalTax = (float) ((annualIncome - 202800) * 0.33);
			federalTax += 46965;			
		}
		
		float provincialTax;
		if(annualIncome <= 42201){
			provincialTax = (float) (annualIncome * .0505);
			provincialTax -= 0;
		}
		else if(annualIncome <= 84404){
			provincialTax = (float) (annualIncome * .0915);
			provincialTax -= 1730;
		}
		else if(annualIncome <= 150000){
			provincialTax = (float) (annualIncome * .1116);
			provincialTax -= 3427;
		}
		else if(annualIncome <= 220000){
			provincialTax = (float) (annualIncome * .1216);
			provincialTax -= 4927;
		}
		else{
			provincialTax = (float) (annualIncome * .1316);
			provincialTax -= 7127;		
		}
		
		float taxTotal = provincialTax+federalTax;
		System.out.println("The estimated amount of income tax you have to pay is: $"+(taxTotal));
		System.out.println("which is "+Math.round(taxTotal/annualIncome*100)+"% of your pay");
		
		System.out.println("Your annual CPP paid is: $"+cpp*24);
		System.out.println("Your annual EI paid is: $"+ei*24);		
	}
}
