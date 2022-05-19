package gui.control;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.game.GameSystem;
import media.MediaSystem;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MovingController extends Controller implements Inputable {
	private Label label;
	private TextField textField;
	
	public MovingController() {
		setActionButtonText("Move");
		initInputLabelAndTextField();
	}
	
	public void initInputLabelAndTextField() {
		label = new Label("Move : ");
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		textField = new TextField();
		textField.setPromptText("Enter distance");
		textField.setPrefWidth(100);
		textField.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		this.getChildren().add(0, label);
		this.getChildren().add(1, textField);
	}
	
	public void actionButtonHandler() {
		MediaSystem.getClickedSoundEffectPlayer().play();
		try {
			if (!GameSystem.getPlayer().isMovingThreadEnd()) {
				GameSystem.getPlayer().move(Double.parseDouble(textField.getText()));				
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("Wait");
				alert.setContentText("You Need To Wait Until Moving End!!!");
				alert.show();		
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Input Invalid");
			alert.setContentText("Please Enter Decimal Number");
			alert.show();
		}
	}
	
	
}
