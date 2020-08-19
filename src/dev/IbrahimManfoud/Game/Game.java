package dev.IbrahimManfoud.Game;

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;

import dev.IbrahimManfoud.Game.Display.Display;
import dev.IbrahimManfoud.Game.gfx.Assets;
import dev.IbrahimManfoud.Game.gfx.GameCamera;
import dev.IbrahimManfoud.Game.input.KeyManager;
import dev.IbrahimManfoud.Game.states.GameState;
//import dev.IbrahimManfoud.Game.states.MenuState;
import dev.IbrahimManfoud.Game.states.State;

public class Game implements Runnable {

	private Display display;
	private int width, height;
	private Thread thread;
	private boolean running = false;

	private BufferStrategy bs;
	private Graphics2D g;

	private KeyManager keyManager;

	// Camera
	private GameCamera gameCamera;

	// Handler
	private Handler handler;

	// STATES
	private State gameState;
	// private State menuState;

	public Game() {
		width = 1200;
		height = 900;
		keyManager = new KeyManager();
	}

	private void init() {
		Assets.init();
		handler = new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);
		display = new Display(width, height);
		display.getFrame().addKeyListener(keyManager);

		gameState = new GameState(handler);
		// menuState = new MenuState(handler);
		State.setState(gameState);
	}

	private void tick() {
		keyManager.tick();
		if (State.getState() != null) {
			State.getState().tick();
		}
	}

	private void render() {
		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}
		g = (Graphics2D) bs.getDrawGraphics();
		g.clearRect(0, 0, width, height);

		if (State.getState() != null) {
			State.getState().render(g);
		}

		bs.show();
		g.dispose();
	}

	public void run() {
		init();

		int renderRate = 144;
		double timePerTick = 1000000000 / renderRate;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			lastTime = now;
			if (delta >= 1) {
				tick();
				render();
				delta--;
			}
		}

		stop();
	}

	public KeyManager getKeyManager() {
		return keyManager;
	}

	public GameCamera getCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public synchronized void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
