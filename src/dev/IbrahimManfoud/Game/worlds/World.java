package dev.IbrahimManfoud.Game.worlds;

import java.awt.Graphics2D;

import dev.IbrahimManfoud.Game.Handler;
import dev.IbrahimManfoud.Game.tiles.Tiles;
import dev.IbrahimManfoud.Game.utils.Utils;

public class World {

	private Handler handler;
	private int width = 32, height = 32;
	// private int spawnX, spawnY;
	private int[][] tiles;

	public World(Handler handler, String path) {
		this.handler = handler;
		loadWorld(path);
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAsString(path);
		String[] tokens = file.split("\\s+");
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		// spawnX = Utils.parseInt(tokens[2]);
		// spawnY = Utils.parseInt(tokens[3]);

		tiles = new int[width][height];
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}
		}

	}

	public void tick() {

	}

	public void render(Graphics2D g) {
		int xStart = (int) Math.max(0, handler.getCamera().getxOffset() / Tiles.TILEWIDTH);
		int xEnd = (int) Math.min(width, (handler.getCamera().getxOffset() + handler.getWidth()) / Tiles.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getCamera().getyOffset() / Tiles.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getCamera().getyOffset() + handler.getHeight()) / Tiles.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tiles.TILEWIDTH - handler.getCamera().getxOffset()),
						(int) (y * Tiles.TILEHEIGHT - handler.getCamera().getyOffset()));
			}
		}
	}

	public Tiles getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tiles.Rock;

		Tiles t = Tiles.tiles[tiles[x][y]];
		if (t == null) {
			return Tiles.stoneTile;
		}
		return t;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
}
