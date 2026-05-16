package me.jmp.entities.enemies;

import me.jmp.entities.Enemy;
import me.jmp.math.Vector2;

public class TestEnemy extends Enemy {
	public TestEnemy(Vector2 position) {
		this.position = position;
	}

	public TestEnemy(float x, float y) {
		this.position = new Vector2(x, y);
	}

	public TestEnemy() {
		this.position = new Vector2(0, 0);
	}

	@Override
	public void step() {

	}
}
