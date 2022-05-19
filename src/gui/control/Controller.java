package gui.control;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.event.EventHandler;

public abstract class Controller extends HBox {
	private Button actionButton;
	public Controller() {
		this.setPrefHeight(50);
		this.setBorder(new Border(new BorderStroke(Color.LIGHTGREY , BorderStrokeStyle.SOLID, new CornerRadii(4), new BorderWidths(2))));
		this.setAlignment(Pos.CENTER);
		this.setSpacing(8);
		
		actionButton = new Button();
		actionButton.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(4), new BorderWidths(2))));
		actionButton.setBackground(new Background(new BackgroundFill(Color.WHITE,new CornerRadii(8), Insets.EMPTY)));
	
	
		actionButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				actionButtonHandler();
			}
		});
		
		this.getChildren().add(actionButton);
	}
	
	abstract public void actionButtonHandler();
	
	public void setActionButtonText(String text) {
		actionButton.setText(text);
		actionButton.setFont(Font.font("Verdana", FontWeight.NORMAL, 14));
	}
}
