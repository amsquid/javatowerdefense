package me.jmp.entities;

import me.jmp.math.Vector2;

public abstract class Enemy {
	protected Vector2 position;

	public Enemy(Vector2 position) {
		this.position = position;
	}

	public Enemy(float x, float y) {
		this.position = new Vector2(x, y);
	}

	public Enemy() {
		this.position = new Vector2(0, 0);
	}

	/***
	 * Run every time the enemy takes a step
	 * Should not be in control of actually moving the player
	 */
	public abstract void step();

	public Vector2 getPosition() {
		return position;
	}
}
