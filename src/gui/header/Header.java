package gui.header;

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

public class Header extends VBox {
	private Text headerText;
	public Header() {
		this.setAlignment(Pos.CENTER);
		this.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(8), new BorderWidths(8))));
		this.setBackground(new Background(new BackgroundFill(Color.LIGHTYELLOW,new CornerRadii(16), Insets.EMPTY)));
		
		headerText = new Text("S P I D R A W");
		headerText.setFont(Font.font("Verdana", FontWeight.BOLD, 34));
		headerText.setFill(Color.BROWN);
		
		this.getChildren().add(headerText);
	}
}
