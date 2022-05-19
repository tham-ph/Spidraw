package logic.entity;

import gui.status.ItemStatus;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import logic.game.GameSystem;

public class IncreasingTimeItem extends Item {
	public IncreasingTimeItem() {
		super(ClassLoader.getSystemResource("clock.png").toString());
	}
	
	public void drawImage(GraphicsContext gc, double xPosition, double yPosition, double width, double height) {
		gc.drawImage(getImage(), xPosition - width / 2, yPosition - height / 2, width, height);
	}
	
	public void giveBuff() {
		for (Node node : GameSystem.getStatusBar().getChildren()) {
			if (node instanceof ItemStatus) {
				ItemStatus t = (ItemStatus) node;	
				t.addSecond(30);
			}
		}
	}
}
