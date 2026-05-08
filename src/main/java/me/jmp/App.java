package me.jmp;

import me.jmp.entities.Enemy;
import me.jmp.entities.Tower;
import me.jmp.math.Vector2;

import java.awt.*;
import java.util.ArrayList;

public class App {
	private ArrayList<Enemy> enemies;
	private ArrayList<Tower> towers;
	private ArrayList<Vector2> points;

	public static void main(String[] args) {
		new App().run();
	}

	public void run() {
		enemies = new ArrayList<>();
		towers = new ArrayList<>();
	}


}
