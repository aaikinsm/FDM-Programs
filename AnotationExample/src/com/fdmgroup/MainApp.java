package com.fdmgroup;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class MainApp {
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		LoginController lc = new LoginController("david", "123456");
		Class<LoginController> loginControllerClass = (Class<LoginController>) lc.getClass();
		
		if (loginControllerClass.isAnnotationPresent(Controller.class)){
			Field[] fields = loginControllerClass.getDeclaredFields();
			
			boolean flag = true;
			
			for (Field field : fields) {
				if (field.isAnnotationPresent(Size.class)){
					Size size = field.getDeclaredAnnotation(Size.class);
					field.setAccessible(true);
					String value = (String) field.get(lc);
					if (value.length() < size.min() || value.length() > size.max()){
						System.out.println(field.getName() + "size is not between "+size.min() + " and "+size.max()+".");
						flag = false;
					}
				}
			}
			
			if (flag){
				Method[] methods = loginControllerClass.getMethods();
				for (Method method : methods) {
					if (method.isAnnotationPresent(Runner.class)){
						Boolean result = (Boolean) method.invoke(lc);
						System.out.println("Calling "+ method.getName() + "...");
						System.out.println("The result is  "+ result);
					}
				}				
			}
		}
	}
}
