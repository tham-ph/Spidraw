package application;

import gui.canvas.GameCanvas;
import gui.control.ControlBar;
import gui.header.Header;
import gui.status.StatusBar;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import logic.entity.Player;
import logic.game.GameSystem;
import media.MediaSystem;

public class Main extends Application {
	
	public void start(Stage primaryStage) throws Exception {
		
		VBox root = new VBox();
		root.setAlignment(Pos.CENTER);
		root.setBackground(new Background(new BackgroundFill(Color.DARKGOLDENROD,CornerRadii.EMPTY, Insets.EMPTY)));
		
		Header header = new Header();
		
		HBox content = new HBox();
		content.setSpacing(8);
		content.setPadding(new Insets(8, 8, 8, 8));

		GameCanvas gameCanvas = new GameCanvas();
		GameSystem.setGameCanvas(gameCanvas);
			
		Player player = new Player();
		GameSystem.setPlayer(player);
	
		ControlBar controlBar = new ControlBar();
		GameSystem.setControlBar(controlBar);

		StatusBar statusBar = new StatusBar();
		GameSystem.setStatusBar(statusBar);
		
		content.getChildren().addAll(controlBar, gameCanvas, statusBar);
		root.getChildren().addAll(header, content);
		
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Spidraw");
		primaryStage.show();
		
		MediaSystem.init();
		GameSystem.init();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
