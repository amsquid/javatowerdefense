package me.jmp;

import me.jmp.entities.Enemy;
import me.jmp.entities.Tower;
import me.jmp.entities.enemies.TestEnemy;
import me.jmp.math.Vector2;

import java.awt.BorderLayout;
import java.awt.Dimension;
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

	public static void main(String[] args) {
		enemies = new ArrayList<>();
		towers = new ArrayList<>();
		path = new ArrayList<>();

		for(int i = 100; i <= 700; i += 1) {
			path.add(new Vector2((float) i, (float) i));
		}

		renderer = new Renderer();
		renderer.setPreferredSize(new Dimension(WIDTH, HEIGHT)); //https://github.com/ImKennyYip/snake-java/blob/master/SnakeGame.java
	
		jFrame = new JFrame("Java Tower Defense");
		jFrame.add(renderer, BorderLayout.CENTER);
		jFrame.setSize(WIDTH, HEIGHT);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setLocationRelativeTo(null);
		jFrame.setResizable(false);
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
}
