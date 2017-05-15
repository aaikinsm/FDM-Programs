package com.fdmgroup.app;

import javax.persistence.Persistence;

import com.fdmgroup.controller.HomeController;

public class MainApp {
	public static void main(String[] args) {
		HomeController hc = HomeController.getInstance();
		hc.showHome();
	}
}
