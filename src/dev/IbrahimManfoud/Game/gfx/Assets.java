package dev.IbrahimManfoud.Game.gfx;

import java.awt.image.BufferedImage;

public class Assets {

	public static BufferedImage player;

	public static BufferedImage stoneTile;
	public static BufferedImage rock;
	public static BufferedImage tree;

	public static BufferedImage[] player_down;
	public static BufferedImage[] player_up;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;

	private static final int width = 32, height = 32;

	// Loads all the images for use in the game.
	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/Textures/shortgrass.png"));
		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/Textures/SpriteSheet1.png"));
		SpriteSheet sheet3 = new SpriteSheet(ImageLoader.loadImage("/Textures/hyptosis_til-art-batch-2.png"));
		SpriteSheet kelsierSheet = new SpriteSheet(ImageLoader.loadImage("/Textures/kelsierSprites.png"));

		player_down = new BufferedImage[8];
		player_down[0] = kelsierSheet.crop(32, 0, 32, 64);
		player_down[1] = kelsierSheet.crop(32 * 2, 0, 32, 64);
		player_down[2] = kelsierSheet.crop(32 * 3, 0, 32, 64);
		player_down[3] = kelsierSheet.crop(32 * 2, 0, 32, 64);
		player_down[4] = kelsierSheet.crop(32, 0, 32, 64);
		player_down[5] = kelsierSheet.crop(32 * 4, 0, 32, 64);
		player_down[6] = kelsierSheet.crop(32 * 5, 0, 32, 64);
		player_down[7] = kelsierSheet.crop(32 * 4, 0, 32, 64);

		player_up = new BufferedImage[8];
		player_up[0] = kelsierSheet.crop(32, 64, 32, 64);
		player_up[1] = kelsierSheet.crop(32 * 2, 64, 32, 64);
		player_up[2] = kelsierSheet.crop(32 * 3, 64, 32, 64);
		player_up[3] = kelsierSheet.crop(32 * 2, 64, 32, 64);
		player_up[4] = kelsierSheet.crop(32, 64, 32, 64);
		player_up[5] = kelsierSheet.crop(32 * 4, 64, 32, 64);
		player_up[6] = kelsierSheet.crop(32 * 5, 64, 32, 64);
		player_up[7] = kelsierSheet.crop(32 * 4, 64, 32, 64);

		player_left = new BufferedImage[8];
		player_left[0] = kelsierSheet.crop(32, 64 * 2, 32, 64);
		player_left[1] = kelsierSheet.crop(32 * 2, 64 * 2, 32, 64);
		player_left[2] = kelsierSheet.crop(32 * 3, 64 * 2, 32, 64);
		player_left[3] = kelsierSheet.crop(32 * 2, 64 * 2, 32, 64);
		player_left[4] = kelsierSheet.crop(32, 64 * 2, 32, 64);
		player_left[5] = kelsierSheet.crop(32 * 4, 64 * 2, 32, 64);
		player_left[6] = kelsierSheet.crop(32 * 5, 64 * 2, 32, 64);
		player_left[7] = kelsierSheet.crop(32 * 4, 64 * 2, 32, 64);

		player_right = new BufferedImage[8];
		player_right[0] = kelsierSheet.crop(32, 64 * 3, 32, 64);
		player_right[1] = kelsierSheet.crop(32 * 2, 64 * 3, 32, 64);
		player_right[2] = kelsierSheet.crop(32 * 3, 64 * 3, 32, 64);
		player_right[3] = kelsierSheet.crop(32 * 2, 64 * 3, 32, 64);
		player_right[4] = kelsierSheet.crop(32, 64 * 3, 32, 64);
		player_right[5] = kelsierSheet.crop(32 * 4, 64 * 3, 32, 64);
		player_right[6] = kelsierSheet.crop(32 * 5, 64 * 3, 32, 64);
		player_right[7] = kelsierSheet.crop(32 * 4, 64 * 3, 32, 64);

		stoneTile = sheet.crop(0, 0, width, height);
		rock = sheet2.crop(0, 0, width, height);
		player = kelsierSheet.crop(0, 0, width, height * 2);
		tree = sheet3.crop(672, 0, 64, 160);
	}
}
