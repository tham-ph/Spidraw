package logic.entity;

import logic.game.GameSystem;

public abstract class Item extends Entity {
	
	public Item(String imageURL) {
		super(Math.random() * (GameSystem.getGameCanvas().getEntityCanvas().getWidth() - 20) + 10, Math.random() *( GameSystem.getGameCanvas().getEntityCanvas().getHeight() - 20) + 10, 20, 20, imageURL);
	}
	
	abstract public void giveBuff();
}
