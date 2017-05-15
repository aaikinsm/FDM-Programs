package com.fdmgroup;

public class Player {
	private Object gameConnection;
	private MultiplayerGame game;
	private String name;

	public Player(String name) {
		super();
		game = MultiplayerGame.getInstance();
		this.name = name;
	}

	public void joinGame() {
		gameConnection = game.aquireReusableConnection();
		if (gameConnection != null)
			System.out.println(name + " has joined the game");
		else
			System.out.println(name + "'s connection attempt failed");
	}

	public void leaveGame() {
		game.releaseReusableConnection(gameConnection);
		System.out.println(name + " has disconnected from the game");
	}

}
