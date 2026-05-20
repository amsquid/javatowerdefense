package me.jmp;

import me.jmp.entities.Enemy;
import me.jmp.entities.Tower;
import me.jmp.entities.enemies.TestEnemy;
import me.jmp.math.Vector2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class JavaTowerDefense {
	public static ArrayList<Enemy> enemies;
	public static ArrayList<Tower> towers;
	public static ArrayList<Vector2> path;

	private static Renderer renderer;
	private static JFrame jFrame;

	public static final int WIDTH = 800;
	public static final int HEIGHT = 800;

	public static float health = 1.0f;
	public static long ticks = 0;

	public static Actions currentAction = Actions.NONE;

	public static void main(String[] args) {
		enemies = new ArrayList<>();
		towers = new ArrayList<>();
		path = new ArrayList<>();

		ArrayList<Vector2> pathingTargets = new ArrayList<>();
		pathingTargets.add(new Vector2(100, 100));
		pathingTargets.add(new Vector2(700, 100));
		pathingTargets.add(new Vector2(100, 700));
		pathingTargets.add(new Vector2(700, 700));

		path = Vector2.createPathing(pathingTargets, 1);

		renderer = new Renderer();
		renderer.setPreferredSize(new Dimension(WIDTH, HEIGHT)); //https://github.com/ImKennyYip/snake-java/blob/master/SnakeGame.java

		jFrame = new JFrame("Java Tower Defense");
		jFrame.add(renderer, BorderLayout.CENTER);
		renderer.addKeyListener(new KeyboardInput());

		jFrame.setSize(WIDTH, HEIGHT);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
		jFrame.setFocusable(true);
		jFrame.setFocusTraversalKeysEnabled(true);
		jFrame.setVisible(true);

		jFrame.pack(); //https://github.com/ImKennyYip/snake-java/blob/master/App.java
		renderer.requestFocus();

	
		//https://www.baeldung.com/java-timer-and-timertask
		new Timer().schedule(new GameTimer(), 0, 10);
	}

	private static class GameTimer extends TimerTask {
		@Override
		public void run() {
			if(ticks % 100 == 0) 
				enemies.add(new TestEnemy());

			for(int i = 0; i < enemies.size(); i++) {
				Enemy enemy = enemies.get(i);
				enemy.pathIndex++;
				if(enemy.pathIndex == path.size()) {
					enemies.remove(i);
					i--;
				}
			}

			ticks++;
			renderer.repaint();
		}
	}

	//https://stackoverflow.com/questions/21997130/how-to-use-keylistener-with-jframe
	private static class KeyboardInput implements KeyListener {
		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
			switch(e.getKeyChar()) {
				case '0':
					if(currentAction == Actions.NONE) {
						currentAction = Actions.SHOP;
					} else {
						currentAction = Actions.NONE;
					}
					break;
			}
		}
	}
}
