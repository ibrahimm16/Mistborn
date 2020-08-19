package dev.IbrahimManfoud.Game.gfx;

import dev.IbrahimManfoud.Game.Handler;
import dev.IbrahimManfoud.Game.entities.Entities;
import dev.IbrahimManfoud.Game.tiles.Tiles;

public class GameCamera {

	private float xOffset, yOffset;
	private Handler handler;

	public GameCamera(Handler handler, float xOffset, float yOffset) {
		this.handler = handler;
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public void checkBlankSpace() {
		if (xOffset < 0) {
			xOffset = 0;
		} else if (xOffset > handler.getWorld().getWidth() * Tiles.TILEWIDTH - handler.getWidth()) {
			xOffset = handler.getWorld().getWidth() * Tiles.TILEWIDTH - handler.getWidth();
		}
		if (yOffset < 0) {
			yOffset = 0;
		} else if (yOffset > handler.getWorld().getHeight() * Tiles.TILEHEIGHT - handler.getHeight()) {
			yOffset = handler.getWorld().getHeight() * Tiles.TILEHEIGHT - handler.getHeight();
		}
	}

	public void centerOnEntity(Entities e) {
		xOffset = e.getX() - handler.getWidth() / 2;
		yOffset = e.getY() - handler.getHeight() / 2;
		checkBlankSpace();
	}

	public void move(float x, float y) {
		xOffset += x;
		yOffset += y;
		checkBlankSpace();
	}

	public float getxOffset() {
		return xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
