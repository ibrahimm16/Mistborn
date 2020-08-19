package dev.IbrahimManfoud.Game.states;

import java.awt.Graphics2D;

import dev.IbrahimManfoud.Game.Handler;
import dev.IbrahimManfoud.Game.entities.creatures.Player;
import dev.IbrahimManfoud.Game.entities.statics.Tree;
import dev.IbrahimManfoud.Game.worlds.World;

public class GameState extends State {

	private Player player;
	private World world;
	private Tree tree;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/Worlds/World1.txt");
		handler.setWorld(world);
		player = new Player(handler, 0, 0);
		tree = new Tree(handler, 100, 10);
	}

	public void tick() {
		world.tick();
		tree.tick();
		player.tick();
	}

	public void render(Graphics2D g) {
		world.render(g);
		tree.render(g);
		player.render(g);
	}

}
