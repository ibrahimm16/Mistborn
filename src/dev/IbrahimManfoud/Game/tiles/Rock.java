package dev.IbrahimManfoud.Game.tiles;


import dev.IbrahimManfoud.Game.gfx.Assets;

public class Rock extends Tiles {

	public Rock(int id) {
		super(Assets.rock, id);
	}

	public boolean isSolid() {
		return true;
	}

}
