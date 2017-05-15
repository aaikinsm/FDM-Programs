package com.fdmgroup;

public class MainApp {
	public static void main(String[] args) {
		User u = new User("jDoe", "1234");
		System.out.println(u);
		
		User a = new Admin();
		System.out.println(a);
		
		if (a instanceof Admin){
			Admin a2 = (Admin) a;
			System.out.println(a2);
		}

		if (a.getClass() == Admin.class){
			Admin a2 = (Admin) a;
			System.out.println(a2);
		}
		
		//assert(args.length == 2) : "# of inputs is not 2";
		//System.out.println(args[0]+args[1]);
		
		float average = average(12, -5, 0, 65, 32);
		System.out.println("The average is: " + average);
	}
	
	public static float average(int... numbers){
		int sum = 0;
		for (int i : numbers) {
			sum += i;
		}
		
		return (float) sum/numbers.length;
	}
}
