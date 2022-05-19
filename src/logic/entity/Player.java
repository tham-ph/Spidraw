package logic.entity;

import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import logic.game.GameSystem;
import media.MediaSystem;

public class Player extends Entity {
	private double rotationDegree;
	private int speed;
	private Color penColor;
	private boolean penDown;
	private Thread movingThread;
	private Thread rotationThread;
	
	public Player() {
		super(GameSystem.getGameCanvas().getEntityCanvas().getWidth() / 2, GameSystem.getGameCanvas().getEntityCanvas().getHeight() / 2, 30, 30, ClassLoader.getSystemResource("spider.png").toString());
		setRotationDegree(90);
		setSpeed(1);
		movingThread = new Thread();
		rotationThread = new Thread();
	}
	
	public void drawImage(GraphicsContext gc, double xPosition, double yPosition, double width, double height) {
		gc.save();
		gc.translate(xPosition, yPosition);
		gc.rotate(getRotationDegree() - 90);
		gc.drawImage(getImage(), -width / 2, -height / 2, width, height);
		gc.restore();
	}
	
	public void drawLine(GraphicsContext gc, double sx, double sy, double ex, double ey) {
		gc.setStroke(penColor);
		gc.setLineWidth(getWidth() * 0.1);
		gc.strokeLine(sx, sy, ex, ey);
	}
	
	public void collectItem() {
		for (Item item : GameSystem.getItemOnGameCanvasList()) {
			double dx = (item.getXPosition() - getXPosition());
			double dy = (item.getYPosition() - getYPosition());
			double distance = Math.sqrt(dx * dx + dy * dy);
			if (distance <= 30) {
				MediaSystem.getCollectedItemSoundEffectPlayer().play();
				item.giveBuff();
				if (item instanceof Statusable) {
					Statusable t = (Statusable) item;
					Platform.runLater(new Runnable() {
						public void run() {
							t.setStatus();
						}
					});
				} 
				GameSystem.getItemOnGameCanvasList().remove(item);
				GameSystem.generateItem();
				break;
			}
		}
	}
	
	public void move(double distance) {
		movingThread = new Thread(() -> {
			try {
				double remainingDistance = Math.abs(distance);
				while(remainingDistance > 0) {		
					
					double xDistance = speed * Math.cos(Math.toRadians(rotationDegree));
					double yDistance = speed * Math.sin(Math.toRadians(rotationDegree));
					if (distance >= 0) {
						setXPosition(getXPosition() - xDistance);
						setYPosition(getYPosition() - yDistance);	
					} else { 
						setXPosition(getXPosition() + xDistance);
						setYPosition(getYPosition() + yDistance);
					}
					remainingDistance -= speed;
					
					Platform.runLater(new Runnable() {
						public void run() {
							GameSystem.render();	
							if (isPenDown()) {
								if (MediaSystem.getDrawingSoundEffectPlayer().getStatus() != MediaPlayer.Status.PLAYING) {
									MediaSystem.getDrawingSoundEffectPlayer().play();		
								}
								if (distance >= 0) {
									drawLine(GameSystem.getGameCanvas().getGraphicsContextDrawingCanvas(), getXPosition(), getYPosition(), getXPosition() - xDistance, getYPosition() - yDistance);
								} else {
									drawLine(GameSystem.getGameCanvas().getGraphicsContextDrawingCanvas(), getXPosition(), getYPosition(), getXPosition() + xDistance, getYPosition() + yDistance);
								}
									
							}
						}
					});
					
					collectItem();
					
					Thread.sleep(16);
				}
				
					
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		});
		movingThread.start();
	}
	
	public void rotate(double degree) {
		rotationThread = new Thread(() -> {
			try {
				double remainingDegree = Math.abs(degree);
				while (remainingDegree > 0) {
					if (degree >= 0) {
						rotationDegree += speed;
					} else {
						rotationDegree -= speed;
					}
					remainingDegree -= speed;
					Platform.runLater(new Runnable() {
						public void run() {
							GameSystem.render();
						}
					});
					Thread.sleep(16);
				}
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		});
		rotationThread.start();
	}
	
	public boolean isMovingThreadEnd() {
		return movingThread.isAlive();
	}
	
	public boolean isRotationThreadEnd() {
		return rotationThread.isAlive();
	}
	
	public double getRotationDegree() {
		return rotationDegree;
	}
	public void setRotationDegree(double rotationDegree) {
		this.rotationDegree = rotationDegree;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public Color getPenColor() {
		return penColor;
	}
	public void setPenColor(Color penColor) {
		this.penColor = penColor;
	}
	public boolean isPenDown() {
		return penDown;
	}
	public void setPenDown(boolean penDown) {
		this.penDown = penDown;
	}
	public Thread getMovingThread() {
		return movingThread;
	}
	public void setMovingThread(Thread movingThread) {
		this.movingThread = movingThread;
	}
	public Thread getRotationThread() {
		return rotationThread;
	}
	public void setRotationThread(Thread rotationThread) {
		this.rotationThread = rotationThread;
	}
	
	
	
}