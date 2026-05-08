package me.jmp;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;

public class App extends GameApplication {
	
	@Override
	protected void initSettings(GameSettings settings) {
		settings.setWidth(800);
		settings.setHeight(800);
		settings.setTitle("Java Tower Defense");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
