package me.jmp;

import me.jmp.entities.Enemy;
import me.jmp.entities.Tower;
import me.jmp.math.Vector2;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class JavaTowerDefense {
	private ArrayList<Enemy> enemies;
	private ArrayList<Tower> towers;
	private ArrayList<Vector2> path;

	private JFrame jFrame;

	public static void main(String[] args) {
		new JavaTowerDefense().run();
	}

	public void run() {
		enemies = new ArrayList<>();
		towers = new ArrayList<>();

		jFrame = new JFrame("Java Tower Defense");
		jFrame.setSize(800, 800);
		jFrame.add(new Renderer());
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.setVisible(true);

		//https://www.baeldung.com/java-timer-and-timertask
		new Timer().schedule(new GameTimer(), 0, 10);
	}

	private class GameTimer extends TimerTask {
		@Override
		public void run() {
			System.out.println("TICK");
			jFrame.repaint();
		}
	}
}
