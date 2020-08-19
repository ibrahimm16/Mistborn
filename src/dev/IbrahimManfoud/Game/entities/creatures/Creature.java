package dev.IbrahimManfoud.Game.entities.creatures;

import dev.IbrahimManfoud.Game.Handler;
import dev.IbrahimManfoud.Game.entities.Entities;
import dev.IbrahimManfoud.Game.tiles.Tiles;

public abstract class Creature extends Entities {

	public static final int DEFAULT_HEALTH = 100;
	public static final float DEFAULT_SPEED = 2.3f;
	public static final int DEFAULT_CREATURE_WIDTH = 32;
	public static final int DEFAULT_CREATURE_HEIGHT = 64;

	protected int health;
	protected float speed;
	protected float xMove, yMove;

	public Creature(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
		health = DEFAULT_HEALTH;
		speed = DEFAULT_SPEED;
		xMove = 0;
		yMove = 0;
	}

	public void move() {
		moveX();
		moveY();
	}

	public void moveX() {
		if (xMove > 0) {
			int tx = (int) (x + xMove + bounds.x + bounds.width) / Tiles.TILEWIDTH;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tiles.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tiles.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tiles.TILEWIDTH - bounds.x - bounds.width - 1;
			}
		} else if (xMove < 0) {
			int tx = (int) (x + xMove + bounds.x) / Tiles.TILEWIDTH;
			if (!collisionWithTile(tx, (int) (y + bounds.y) / Tiles.TILEHEIGHT)
					&& !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tiles.TILEHEIGHT)) {
				x += xMove;
			} else {
				x = tx * Tiles.TILEWIDTH + Tiles.TILEWIDTH - bounds.x;
			}
		}
	}

	public void moveY() {
		if (yMove < 0) {
			int ty = (int) (y + yMove + bounds.y) / Tiles.TILEHEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tiles.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tiles.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tiles.TILEHEIGHT + Tiles.TILEHEIGHT - bounds.y;
			}
		} else if (yMove > 0) {
			int ty = (int) (y + yMove + bounds.y + bounds.height) / Tiles.TILEHEIGHT;
			if (!collisionWithTile((int) (x + bounds.x) / Tiles.TILEWIDTH, ty)
					&& !collisionWithTile((int) (x + bounds.x + bounds.width) / Tiles.TILEWIDTH, ty)) {
				y += yMove;
			} else {
				y = ty * Tiles.TILEHEIGHT - bounds.y - bounds.height - 1;
			}
		}
	}

	protected boolean collisionWithTile(int x, int y) {
		return handler.getWorld().getTile(x, y).isSolid();
	}

	public int getHealth() {
		return health;
	}

	public float getSpeed() {
		return speed;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getxMove() {
		return xMove;
	}

	public float getyMove() {
		return yMove;
	}

	public void setxMove(float xMove) {
		this.xMove = xMove;
	}

	public void setyMove(float yMove) {
		this.yMove = yMove;
	}

}
