package dev.IbrahimManfoud.Game.entities.creatures;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import dev.IbrahimManfoud.Game.Handler;
import dev.IbrahimManfoud.Game.gfx.Animation;
import dev.IbrahimManfoud.Game.gfx.Assets;

public class Player extends Creature {

	// Animations
	private Animation animDown;
	private Animation animUp;
	private Animation animLeft;
	private Animation animRight;

	public Player(Handler handler, float x, float y) {
		super(handler, 584, 418, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);
		bounds.x = 4;
		bounds.y = 32;
		bounds.width = 22;
		bounds.height = 30;
		speed = 1.5f;

		// Animations
		animDown = new Animation(95, Assets.player_down);
		animUp = new Animation(95, Assets.player_up);
		animLeft = new Animation(95, Assets.player_left);
		animRight = new Animation(95, Assets.player_right);
	}

	@Override
	public void tick() {
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		getInput();
		move();
		handler.getCamera().centerOnEntity(this);
	}

	private void getInput() {
		xMove = 0;
		yMove = 0;
		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;
	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getCamera().getxOffset()),
				(int) (y - handler.getCamera().getyOffset()), null);

	}

	private BufferedImage getCurrentAnimationFrame() {
		if (xMove < 0) {
			return animLeft.getCurrentFrame();
		} else if (xMove > 0) {
			return animRight.getCurrentFrame();
		} else if (yMove > 0) {
			return animDown.getCurrentFrame();
		} else {
			return animUp.getCurrentFrame();
		}
	}

}
