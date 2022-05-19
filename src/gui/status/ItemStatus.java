package gui.status;

import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import logic.entity.Item;
import logic.entity.Statusable;



public class ItemStatus extends HBox{
	private Item item;
	
	private Canvas itemImage;
	private GraphicsContext gc;
	
	private Text timeText;
	
	private int minute;
	private int second;
	private int milliSecond;
	private int total;
	
	private boolean stopThread;
	
		
	public ItemStatus(Item item) {
		this.setPrefHeight(50);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGREY , BorderStrokeStyle.SOLID, new CornerRadii(4), new BorderWidths(2))));
		this.setAlignment(Pos.CENTER_LEFT);
		this.setSpacing(8);
	
		this.item = item;

		itemImage = new Canvas(50, 50);
		gc = itemImage.getGraphicsContext2D();
		item.drawImage(gc, itemImage.getWidth() / 2, itemImage.getHeight() / 2, item.getWidth(), item.getWidth());
		
		
		timeText = new Text();
		timeText.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
		
		
		stopThread = false;
		
		
		this.getChildren().addAll(itemImage, timeText);
		
	}
	
	public void setTimer(int minute, int second, int milliSecond) {
		this.minute = minute;
		this.second = second;
		this.milliSecond = milliSecond;
		this.total += minute * 60 * 1000 + second * 1000 + milliSecond;
	}
	
	public void addSecond(int second) {
		this.second += second;
		this.total += minute * 60 * 1000 + second * 1000 + milliSecond;
	}
	
	public void startTimer() {
		Thread thread = new Thread(() -> {		
			try {
				while(total > 0 && !stopThread) {
					total -= 20;
					
					int t = total;
					this.minute = t / (60 * 1000);
					t %= (60 * 1000);
					this.second = t / 1000;
					t %= 1000;
					this.milliSecond = t;
				
					Platform.runLater(new Runnable() {
						public void run() {
							timeText.setText(String.format("%02d:%02d:%02d",minute, second, milliSecond / 10));
						}
					});
					Thread.sleep(20);
				}
				
				if (total <= 0) {
					Platform.runLater(new Runnable() {
						public void run() {
							Statusable t = (Statusable) item;
							t.removeStatus();
							t.removeBuff();
						}
					});
				} 
				
		
			} catch (InterruptedException e) {
				e.printStackTrace();
			} 
		});
		thread.start();
	}

	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Canvas getItemImage() {
		return itemImage;
	}
	public void setItemImage(Canvas itemImage) {
		this.itemImage = itemImage;
	}
	public GraphicsContext getGc() {
		return gc;
	}
	public void setGc(GraphicsContext gc) {
		this.gc = gc;
	}
	public Text getTimeText() {
		return timeText;
	}
	public void setTimeText(Text timeText) {
		this.timeText = timeText;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public int getSecond() {
		return second;
	}
	public void setSecond(int second) {
		this.second = second;
	}
	public int getMilliSecond() {
		return milliSecond;
	}
	public void setMilliSecond(int milliSecond) {
		this.milliSecond = milliSecond;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isStopThread() {
		return stopThread;
	}
	public void setStopThread(boolean stopThread) {
		this.stopThread = stopThread;
	}
	

	
	
	
	
}
