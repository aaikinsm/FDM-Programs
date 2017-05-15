import java.util.Calendar;

import com.fdmgroup.math.Calculator;

public class MainApp {
	private static Status status;
	public static void main(String[] args) {
		status = status.OPEN;
		Calculator cal = new Calculator();
		cal.setNum1(45);
		cal.setNum2(5);
		System.out.println("The result add is: " + cal.add());
		System.out.println("The result sub is: " + cal.sub());
		System.out.println("The result mul is: " + cal.mul());
		System.out.println("The result div is: " + cal.div());
		
		System.out.println("________________________________");
		String s1 = "Hello World";
		String s2 = new String("Hello World");
		
		if (s1.equals(s2))
			System.out.println("The strings are equal.");
		else
			System.out.println("The strings are no equal.");
		
		int r = s1.indexOf('l');
		int r2 = s1.indexOf('l', (r+1));
		int r3 = s1.indexOf('l', (r2+1));
		int r4 = s1.indexOf('l', (r3+1));
		int r5 = s1.indexOf('l', (r4+1));
		
		System.out.println(r);
		System.out.println(r2);
		System.out.println(r3);
		System.out.println(r4);
		System.out.println(r5);

		System.out.println("________________________________");
		
		/*int[] numbers = new int[5];
		numbers[0] = 15;
		numbers[1] = 45;
		numbers[2] = -7;
		numbers[3] = -78;
		numbers[4] = 0;*/
		
		int[] numbers = {15, 45, -7, 78, 0};
		
		int[][] matrix = new int[2][3];
		matrix[0][0] = 1;
		matrix[0][2] = 1;
		matrix[1][0] = 1;
		matrix[1][1] = 1;
		
		
		//System.out.println(numbers[2] + numbers[1]);
		
		if (status == Status.OPEN){
			System.out.println("App is running...");
			
		}
		
		System.out.println(Math.sqrt(2));
		System.out.println(Math.random());
		System.out.println(Math.PI);
		
		System.out.println("________________________________");

		Calendar c = Calendar.getInstance();
		System.out.println(c.getTime().toString());
		System.out.println(c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE)+ ":" + c.get(Calendar.SECOND));
		
		System.out.println("________________________________");

		int guess = 2;
		
		switch (guess){
		case 1:
			System.out.print("1");
		break;
		case 2:
			System.out.print("2");
			break;
		case 3:
			System.out.print("3");
			break;
		}
	}
}
