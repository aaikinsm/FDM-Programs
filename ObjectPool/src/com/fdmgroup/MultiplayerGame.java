package com.fdmgroup;

import java.util.HashMap;
import java.util.Map;

public class MultiplayerGame {
	private Map<Object, Boolean> connectionPool;
	private final int MAX_NUM_OF_PLAYERS = 4;
	private boolean NOT_AVAILABLE = false, AVAILABLE = true;
	private static MultiplayerGame game = null;

	private MultiplayerGame() {
		super();
		connectionPool = new HashMap<>();

		Object playerConnection1 = new Object();
		connectionPool.put(playerConnection1, AVAILABLE);

		Object playerConnection2 = new Object();
		connectionPool.put(playerConnection2, AVAILABLE);
	}

	public static MultiplayerGame getInstance() {
		if (game == null) {
			game = new MultiplayerGame();
		}
		return game;
	}

	public Object aquireReusableConnection() {
		for (Object connectionObject : connectionPool.keySet()) {
			if (connectionPool.get(connectionObject) == AVAILABLE) {
				connectionPool.put(connectionObject, NOT_AVAILABLE);
				System.out.println("-------Reusing a connection-------");
				return connectionObject;
			}
		}

		if (connectionPool.size() < MAX_NUM_OF_PLAYERS) {
			Object newConnectionObject = new Object();
			connectionPool.put(newConnectionObject, NOT_AVAILABLE);
			System.out.println("-------Creating a new connection-------");
			return newConnectionObject;
		}

		System.out.println("-------The game room is full. Please try again later-------");
		return null;
	}

	public void releaseReusableConnection(Object object) {
		connectionPool.put(object, AVAILABLE);
	}
}
