package com.fdmgroup;

public abstract class Mammal extends Animal {
	
	private int furLength;
	private int lungsCapacity;
	
	public int getFurLength() {
		return furLength;
	}
	public void setFurLength(int furLength) {
		this.furLength = furLength;
	}
	public int getLungsCapacity() {
		return lungsCapacity;
	}
	public void setLungsCapacity(int lungsCapacity) {
		this.lungsCapacity = lungsCapacity;
	}
	
	public abstract void hibernate();
	public abstract void makeNoise();	
	
}
