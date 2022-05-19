package logic.entity;

import gui.status.ItemStatus;
import javafx.scene.canvas.GraphicsContext;
import logic.game.GameSystem;

public class SpeedUpItem extends Item implements Statusable {
	private ItemStatus itemStatus;
	
	public SpeedUpItem() {
		super(ClassLoader.getSystemResource("speed_up.png").toString());
		itemStatus = new ItemStatus(this);
	}
	
	public void drawImage(GraphicsContext gc, double xPosition, double yPosition, double width, double height) {
		gc.drawImage(getImage(), xPosition - width / 2, yPosition - height / 2, width, height);
	}
	
	public void giveBuff() {
		GameSystem.getPlayer().setSpeed(GameSystem.getPlayer().getSpeed() + 1);
	}
	
	public void removeBuff() {
		GameSystem.getPlayer().setSpeed(GameSystem.getPlayer().getSpeed() - 1);	
	}
	
	public void setStatus() {
		itemStatus.setTimer(0, 30, 0);
		GameSystem.getStatusBar().getChildren().add(itemStatus);
		itemStatus.startTimer();
	}
	
	public void removeStatus() {
		GameSystem.getStatusBar().getChildren().remove(itemStatus);
	}
}