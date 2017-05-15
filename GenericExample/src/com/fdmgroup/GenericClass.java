package com.fdmgroup;

import java.util.ArrayList;
import java.util.List;

public class GenericClass<T> {
	
	private List<T> list;
	
	public GenericClass() {
		super();
		list = new ArrayList<T>();
	}

	public T add(T t){
		list.add(t);
		return t;
	}
	
	public boolean remove(T t){
		if (list.contains(t)){
			list.remove(t);
			return true;
		}
		return false;
	}
	
	public void clear(){
		list.clear();
	}
	
	public List<T> getList(){
		return list;
	}
}
