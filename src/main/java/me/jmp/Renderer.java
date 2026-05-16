package me.jmp;

import javax.swing.JPanel;

import me.jmp.entities.Enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Renderer extends JPanel {

	private int entityScale = 32;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		//Graphics2D g = (Graphics2D) g;
		//g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, JavaTowerDefense.WIDTH, JavaTowerDefense.HEIGHT);

		System.out.println("PAINT");

		for(Enemy enemy : JavaTowerDefense.getEnemies()) {
			g.setColor(Color.WHITE);
			g.fillOval(
				(int) enemy.getPosition().x - (entityScale / 2),
				(int) enemy.getPosition().y - (entityScale / 2),
				entityScale,
				entityScale
			);
		}
	}

}
