package logic.entity;

import gui.status.ItemStatus;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import logic.game.GameSystem;

public class SizeUpItem extends Item implements Statusable {
private ItemStatus itemStatus;
	
	public SizeUpItem() {
		super(ClassLoader.getSystemResource("size_up.png").toString());
		itemStatus = new ItemStatus(this);
	}
	
	public void drawImage(GraphicsContext gc, double xPosition, double yPosition, double width, double height) {
		gc.drawImage(getImage(), xPosition - width / 2, yPosition - height / 2, width, height);
	}
	
	public void giveBuff() {
		GameSystem.getPlayer().setWidth(GameSystem.getPlayer().getWidth() + 5);
		GameSystem.getPlayer().setHeight(GameSystem.getPlayer().getHeight() + 5);
		Platform.runLater(new Runnable() {
			public void run() {
				GameSystem.render();
			}
		});
	}
	
	public void removeBuff() {
		GameSystem.getPlayer().setWidth(GameSystem.getPlayer().getWidth() - 5);
		GameSystem.getPlayer().setHeight(GameSystem.getPlayer().getHeight() - 5);	
		Platform.runLater(new Runnable() {
			public void run() {
				GameSystem.render();
			}
		});
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
