package dev.IbrahimManfoud.Game.entities;

import java.awt.Graphics2D;
import java.awt.Rectangle;

import dev.IbrahimManfoud.Game.Handler;

public abstract class Entities {

	protected Handler handler;
	protected float x, y;
	protected int width, height;
	protected Rectangle bounds;

	public Entities(Handler handler, float x, float y, int width, int height) {
		this.handler = handler;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		bounds = new Rectangle(0, 0, width, height);
	}

	public abstract void tick();

	public abstract void render(Graphics2D g);

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}
}
