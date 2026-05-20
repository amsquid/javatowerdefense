package me.jmp;

import javax.swing.JPanel;

import me.jmp.entities.Enemy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;

public class Renderer extends JPanel {

	private int entityScale = 32;
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.BLACK);
		g.fillRect(0, 0, JavaTowerDefense.WIDTH, JavaTowerDefense.HEIGHT);

		for(Enemy enemy : JavaTowerDefense.enemies) {
			g.setColor(Color.WHITE);
			g.fillOval(
				(int) enemy.getPosition().x - (entityScale / 2),
				(int) enemy.getPosition().y - (entityScale / 2),
				entityScale,
				entityScale
			);
		}
		//}

		Toolkit.getDefaultToolkit().sync(); //https://stackoverflow.com/questions/19480076/java-animation-stutters-when-not-moving-mouse-cursor
	}

}
