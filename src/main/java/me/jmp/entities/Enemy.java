package me.jmp.entities;

import me.jmp.JavaTowerDefense;
import me.jmp.math.Vector2;

public abstract class Enemy {
	public int pathIndex = 0;
	public final int speed;
	public final double damage;
	
	//https://stackoverflow.com/questions/2327509/abstract-class-with-final-uninitialized-field
	protected Enemy(int speed, double damage) {
		this.speed = speed;
		this.damage = damage;
	}

	public abstract void step();

	public Vector2 getPosition() {
		return JavaTowerDefense.path.get(pathIndex);
	}
}
