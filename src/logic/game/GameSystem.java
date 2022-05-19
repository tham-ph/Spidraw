package logic.game;

import java.util.ArrayList;
import java.util.Random;

import gui.canvas.GameCanvas;
import gui.control.ControlBar;
import gui.status.StatusBar;
import logic.entity.ColorItem;
import logic.entity.IncreasingTimeItem;
import logic.entity.Item;
import logic.entity.Player;
import logic.entity.SizeUpItem;
import logic.entity.SpeedUpItem;

public class GameSystem {
	private static ControlBar controlBar;
	
	private static GameCanvas gameCanvas;
	
	private static StatusBar statusBar;
	
	private static Player player;
	
	private static ArrayList<Item> itemOnGameCanvasList;
	

	public static void init() {
		itemOnGameCanvasList = new ArrayList<Item>();
		
		generateItem();
		render();
	}
	
	public static void generateItem() {
		while (itemOnGameCanvasList.size() <= 6) {
			Random rand = new Random();
			int n = rand.nextInt(10);
			Item newItem;
			if (n <= 2) {
				newItem = new ColorItem();
				itemOnGameCanvasList.add(newItem);
			} else if (n <= 5) {
				newItem = new SpeedUpItem();
				itemOnGameCanvasList.add(newItem);
			} else if (n <= 7) {
				newItem = new SizeUpItem();
				itemOnGameCanvasList.add(newItem);		
			} else {
				newItem = new IncreasingTimeItem();
				itemOnGameCanvasList.add(newItem);			
			}
		}
	}
	
	public static void render() {
		gameCanvas.getGraphicsContextEntityCanvas().clearRect(0, 0, gameCanvas.getWidth(), gameCanvas.getHeight());
		player.drawImage(gameCanvas.getGraphicsContextEntityCanvas(), player.getXPosition(), player.getYPosition(), player.getWidth(), player.getHeight());
		for (Item item : itemOnGameCanvasList) {
			item.drawImage(gameCanvas.getGraphicsContextEntityCanvas(), item.getXPosition(), item.getYPosition(), item.getWidth(), item.getHeight());
		}
	}
	
	
	public static GameCanvas getGameCanvas() {
		return gameCanvas;
	}
	public static void setGameCanvas(GameCanvas gameCanvas) {
		GameSystem.gameCanvas = gameCanvas;
	}
	public static ControlBar getControlBar() {
		return controlBar;
	}
	public static void setControlBar(ControlBar controlBar) {
		GameSystem.controlBar = controlBar;
	}
	public static StatusBar getStatusBar() {
		return statusBar;
	}
	public static void setStatusBar(StatusBar statusBar) {
		GameSystem.statusBar = statusBar;
	}
	public static Player getPlayer() {
		return player;
	}
	public static void setPlayer(Player player) {
		GameSystem.player = player;
	}

	public static ArrayList<Item> getItemOnGameCanvasList() {
		return itemOnGameCanvasList;
	}

	public static void setItemOnGameCanvasList(ArrayList<Item> itemOnGameCanvasList) {
		GameSystem.itemOnGameCanvasList = itemOnGameCanvasList;
	}


	
	
	
}