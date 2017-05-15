package com.fdmgroup;

import java.util.List;

public class MainApp {

	public static void main(String[] args) {
		GenericClass<? super Double> gc = new GenericClass<>();
		gc.add(12.7);
		gc.add(4.3);
		gc.add(45.2);
		
		for (Object o : gc.getList()) {
			System.out.println(o);
		}
		
		System.out.println(getSize(gc.getList()));
	}
	
	public static <S> int getSize(List<S> list){
		if (list != null)
			return list.size();
		
		return 0;
	}

}
