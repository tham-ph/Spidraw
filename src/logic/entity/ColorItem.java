package logic.entity;

import java.util.Random;

import gui.status.ItemStatus;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import logic.game.GameSystem;

public class ColorItem extends Item implements Statusable {
	private Color color;
	private ItemStatus itemStatus;
	public ColorItem() {
		super(ClassLoader.getSystemResource("blank.png").toString());
		setColor();
		itemStatus = new ItemStatus(this);
	}
	
	public void drawImage(GraphicsContext gc, double xPosition, double yPosition, double width, double height) {
		gc.setStroke(Color.BLACK);
		gc.setFill(color);
		gc.setLineWidth(3);
		gc.strokeOval(xPosition - width / 2, yPosition - height / 2, width, height);	
		gc.fillOval(xPosition - width / 2, yPosition - height / 2, width, height);
	}
	
	public void giveBuff() {
		GameSystem.getPlayer().setPenColor(color);
	}
	
	public void removeBuff() {
		GameSystem.getPlayer().setPenColor(Color.BLACK);
	}
	
	public void setColor() {
		Color[] colorList = {Color.WHITE, Color.RED, Color.BLUE, Color.YELLOW, Color.GREEN, Color.GREENYELLOW, Color.ORANGE, Color.PURPLE, Color.PINK};
		Random rand = new Random(); 
		color = colorList[rand.nextInt(colorList.length)];
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setStatus() {
		
		for (Node node : GameSystem.getStatusBar().getChildren()) {
			if (node instanceof ItemStatus) {
				ItemStatus t = (ItemStatus) node;
				if (t.getItem() instanceof ColorItem) {
					t.setStopThread(true);
					Statusable t2 = (Statusable) t.getItem();
					t2.removeStatus();
					break;
				}
			}
		}
		itemStatus.setTimer(1, 0, 0);
		GameSystem.getStatusBar().getChildren().add(itemStatus);
		itemStatus.startTimer();
	}
	
	public void removeStatus() {
		GameSystem.getStatusBar().getChildren().remove(itemStatus);
	}

	
}