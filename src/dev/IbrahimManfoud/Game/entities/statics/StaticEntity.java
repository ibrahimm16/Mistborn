package dev.IbrahimManfoud.Game.entities.statics;

import dev.IbrahimManfoud.Game.Handler;
import dev.IbrahimManfoud.Game.entities.Entities;

public abstract class StaticEntity extends Entities {

	public StaticEntity(Handler handler, float x, float y, int width, int height) {
		super(handler, x, y, width, height);
	}

}
