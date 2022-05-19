package gui.status;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StatusBar extends VBox{
	private Text headerText;
	public StatusBar() {
		this.setPrefWidth(200);
		this.setPrefHeight(600);
		this.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(8), new BorderWidths(8))));
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,new CornerRadii(16), Insets.EMPTY)));
		this.setPadding(new Insets(8, 8, 8, 8));
		this.setSpacing(8);
		this.setAlignment(Pos.TOP_CENTER);
		
		headerText = new Text("STATUS");
		headerText.setFont(Font.font("Verdana", FontWeight.BOLD, 24));
		
		this.getChildren().add(headerText);
	}
}
