package com.fdmgroup;

public class MainApp {

	private static int customerIdNum = 1000;
	private static int bankIdNum = 2000000;
	
	public static void main(String[] args) {		
		Person person1 = new Person(generateCustomerId(), customerIdNum/3, "Albert", "56 Lexington");
		Person person2 = new Person(generateCustomerId(), customerIdNum/3, "John", "2 Hengton");
		Company company1 = new Company(generateCustomerId(), customerIdNum/3, "Sears", "1 Mohawk");
		BusinessSavingsAccount bsa = new BusinessSavingsAccount(generateBankId(), company1);
		PersonalCheckingAccount pca = new PersonalCheckingAccount(generateBankId(), 45, person1);
		
		
		
		BusinessSavingsAccount ba1 = new BusinessSavingsAccount(generateBankId(), company1);
		company1.addBankAccount(ba1);
		BusinessSavingsAccount ba2 = new BusinessSavingsAccount(generateBankId(), company1);
		company1.addBankAccount(ba2);
		BusinessSavingsAccount ba3 = new BusinessSavingsAccount(generateBankId(), null);
		ba3.setCompany(company1);
		company1.addBankAccount(ba3);
		
		/*person1.addBankAccount(pca);
		pca.correction(1000);
		System.out.println(pca.balance);
		person1.resetAllAccounts();
		System.out.println(pca.getBalance());
		pca.deposit(500);
		System.out.println(pca.getBalance());
		pca.withdraw(50);
		System.out.println(pca.getBalance());
		removeCustomer(person1);
		System.out.println(pca.getBalance());*/
		
		System.out.println("-------------------");
		ba1.deposit(50);
		System.out.println(ba1.getBalance());
		System.out.println(ba2.getBalance());
		company1.depositToAllAccounts(100);
		System.out.println(ba1.getBalance());
		System.out.println(ba2.getBalance());
	}
	
	public static int generateCustomerId(){
		customerIdNum = customerIdNum+=5;
		return customerIdNum-5;
	}
	
	public static int generateBankId(){
		bankIdNum = bankIdNum+=7;
		return bankIdNum-7;
	}
	
	public static void removeCustomer(BankCustomer bc){
		for (BankAccount account : bc.accounts) {
			account = null;
		}
	}

}
