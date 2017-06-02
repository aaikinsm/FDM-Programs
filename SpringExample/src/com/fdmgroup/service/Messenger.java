package com.fdmgroup.service;

public class Messenger {
	private String os;
	private String version;
	private Messaging provider;

	public Messenger() {
		super();
	}

	public Messenger(String os, String version, Messaging provider) {
		super();
		this.os = os;
		this.version = version;
		this.provider = provider;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Messaging getProvider() {
		return provider;
	}

	public void setProvider(Messaging provider) {
		this.provider = provider;
	}
	
	public void myInit(){
		System.out.println("Further initializing messenger object");
	}

	public void myDestroy(){
		System.out.println("Further destroying messenger object");
	}
	public void sendMessage(String receipient, String message){
		provider.send(receipient, message);
	}

}
