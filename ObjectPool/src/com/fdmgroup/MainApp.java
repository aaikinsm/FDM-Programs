package com.fdmgroup;

public class MainApp {

	public static void main(String[] args) {

		Player jen = new Player("Jen");
		Player ben = new Player("Ben");
		Player ken = new Player("Ken");
		Player john = new Player("John");
		Player lisa = new Player("Lisa");
		Player sean = new Player("Sean");

		jen.joinGame();
		john.joinGame();
		lisa.joinGame();
		ben.joinGame();
		ken.joinGame();
		sean.joinGame();

		System.out.println("_________________________________");

		john.leaveGame();
		ken.joinGame();
		jen.leaveGame();
		sean.joinGame();
	}
}
