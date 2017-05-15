package com.fdmgroup;

public class Arithmetic {

	public int add (int a, int b){
		AppLogger.getUserLogger().info("Adding "+a+" and "+b+" --> "+(a+b));
		return a+b;
	}
	public int sub (int a, int b){
		AppLogger.getUserLogger().info("Subtracting "+a+" and "+b+" --> "+(a-b));
		return a-b;
	}
	public int mul (int a, int b){
		AppLogger.getUserLogger().info("Multiplying "+a+" and "+b+" --> "+(a*b));
		return a*b;
	}
	public int div (int a, int b){
		if (b==0){
			AppLogger.getSystemLogger().error("Dividing by zero ");			
		}
		AppLogger.getUserLogger().info("Dividing "+a+" and "+b+" --> "+(a/b));
		return a/b;
	}
}
