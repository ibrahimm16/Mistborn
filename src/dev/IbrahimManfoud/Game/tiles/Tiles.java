package dev.IbrahimManfoud.Game.tiles;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Tiles {

	// STATIC STUFF HERE

	public static Tiles[] tiles = new Tiles[256];
	public static Tiles stoneTile = new StoneTile(0);
	public static Tiles Rock = new Rock(1);

	// CLASS

	public static final int TILEWIDTH = 32, TILEHEIGHT = 32;                                         

	protected BufferedImage texture;
	protected final int id;

	public Tiles(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;

		tiles[id] = this;
	}

	public void tick() {

	}

	public void render(Graphics2D g, int x, int y) {
		g.drawImage(texture, x, y, null);
	}

	public int getID() {
		return id;
	}

	public boolean isSolid() {
		return false;
	}
}
