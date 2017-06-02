package com.fdmgroup.service;

public abstract class MessageProvider {

	private String prefix;
	private String type;

	public MessageProvider() {
		super();
	}

	public MessageProvider(String prefix, String type) {
		super();
		this.prefix = prefix;
		this.type = type;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
