package gui.control;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import javafx.embed.swing.SwingFXUtils;
import javafx.scene.SnapshotParameters;
import javafx.scene.image.WritableImage;
import javafx.stage.FileChooser;
import logic.game.GameSystem;
import media.MediaSystem;

public class SaveButton extends Controller {
	private FileChooser fileChooser;
	
	public SaveButton() {
		setActionButtonText("Save As");
		fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("png", "*.png"));
		fileChooser.setInitialFileName("canvas");
	}
	
	public void actionButtonHandler() {
		MediaSystem.getClickedSoundEffectPlayer().play();
		
		File file = fileChooser.showSaveDialog(null);
		
		WritableImage image = GameSystem.getGameCanvas().getDrawingCanvas().snapshot(new SnapshotParameters(), null);
		try {
			ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
