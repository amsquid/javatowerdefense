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

	public abstract void move();

	public Vector2 getPosition() {
		return position;
	}
}
