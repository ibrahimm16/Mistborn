package dev.IbrahimManfoud.Game;

import dev.IbrahimManfoud.Game.gfx.GameCamera;
import dev.IbrahimManfoud.Game.input.KeyManager;
import dev.IbrahimManfoud.Game.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game) {
		this.game = game;
	}
	
	public int getWidth() {
		return game.getWidth();
	}
	
	public int getHeight() {
		return game.getHeight();
	}
	
	public KeyManager getKeyManager() {
		return game.getKeyManager();
	}
	
	public GameCamera getCamera() {
		return game.getCamera();
	}

	public Game getGame() {
		return game;
	}

	public World getWorld() {
		return world;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
