package dev.IbrahimManfoud.Game.entities.statics;

import java.awt.Graphics2D;

import dev.IbrahimManfoud.Game.Handler;
import dev.IbrahimManfoud.Game.gfx.Assets;
import dev.IbrahimManfoud.Game.tiles.Tiles;

public class Tree extends StaticEntity {

	public Tree(Handler handler, float x, float y) {
		super(handler, x, y, Tiles.TILEWIDTH, Tiles.TILEHEIGHT * 2);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics2D g) {
		g.drawImage(Assets.tree, (int) (x - handler.getCamera().getxOffset()),
				(int) (y - handler.getCamera().getyOffset()), width, height, null);
	}

}
