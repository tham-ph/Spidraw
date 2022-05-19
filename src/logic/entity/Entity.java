package logic.entity;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.game.GameSystem;

public abstract class Entity {
	
	private double xPosition;
	private double yPosition;
	private double width;
	private double height;
	private Image image;
	
	public Entity(double xPosition, double yPosition, double width, double height, String imageURL) {
		setXPosition(xPosition);
		setYPosition(yPosition);
		setWidth(width);
		setHeight(height);
		setImage(new Image(imageURL));
	}
	
	public abstract void drawImage(GraphicsContext gc, double xPosition, double yPosition, double width, double height);
	
	public double getXPosition() {
		return xPosition;
	}
	public void setXPosition(double xPosition) {
		xPosition = Math.max(xPosition, 0);
		xPosition = Math.min(xPosition, GameSystem.getGameCanvas().getEntityCanvas().getWidth());
		this.xPosition = xPosition;
	}
	public double getYPosition() {
		return yPosition;
	}
	public void setYPosition(double yPosition) {
		yPosition = Math.max(yPosition, 0);
		yPosition = Math.min(yPosition, GameSystem.getGameCanvas().getEntityCanvas().getHeight());
		this.yPosition = yPosition;
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public Image getImage() {
		return image;
	}
	public void setImage(Image image) {
		this.image = image;
	}

}
