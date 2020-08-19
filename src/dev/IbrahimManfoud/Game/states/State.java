package dev.IbrahimManfoud.Game.states;

import java.awt.Graphics2D;

import dev.IbrahimManfoud.Game.Handler;

public abstract class State {

	private static State currentState = null;

	public static void setState(State state) {
		currentState = state;
	}

	public static State getState() {
		return currentState;
	}

	protected Handler handler;

	public State(Handler handler) {
		this.handler = handler;
	}

	public abstract void tick();

	public abstract void render(Graphics2D g);
}
