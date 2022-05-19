package gui.control;

import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import logic.game.GameSystem;
import media.MediaSystem;

public class RotationController extends Controller implements Inputable {
	private Label label;
	private TextField textField;
	
	public RotationController() {
		setActionButtonText("Rotate");
		initInputLabelAndTextField();
	}
	
	public void initInputLabelAndTextField() {
		label = new Label("Rotate : ");
		label.setFont(Font.font("Verdana", FontWeight.BOLD, 14));
		textField = new TextField();
		textField.setPromptText("Enter degree");
		textField.setPrefWidth(100);
		textField.setFont(Font.font("Verdana", FontWeight.NORMAL, 12));
		this.getChildren().add(0, label);
		this.getChildren().add(1, textField);
	}
	
	public void actionButtonHandler() {
		MediaSystem.getClickedSoundEffectPlayer().play();
		try {
			if (!GameSystem.getPlayer().isRotationThreadEnd()) {
				GameSystem.getPlayer().rotate(Double.parseDouble(textField.getText()));			
			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setHeaderText("Wait");
				alert.setContentText("You Need To Wait Until Rotation End!!!");
				alert.show();		
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setHeaderText("Input Invalid");
			alert.setContentText("Plese enter decimal number");
			alert.show();
		}
	}
}
