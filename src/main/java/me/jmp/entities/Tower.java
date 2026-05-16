package me.jmp.entities;

import me.jmp.math.Vector2;

public abstract class Tower {
	private Vector2 position;

	public abstract void shoot();

	public Vector2 getPosition() {
		return position;
	}
}
