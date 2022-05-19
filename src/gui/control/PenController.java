package gui.control;

import logic.game.GameSystem;
import media.MediaSystem;

public class PenController extends Controller {
	public PenController() {
		setActionButtonText("Click to Pen Up");
		GameSystem.getPlayer().setPenDown(true);
	}
	
	public void actionButtonHandler() {
		MediaSystem.getClickedSoundEffectPlayer().play();
		if (GameSystem.getPlayer().isPenDown()) {
			GameSystem.getPlayer().setPenDown(false);
			setActionButtonText("Click to Pen Down");
		} else {
			GameSystem.getPlayer().setPenDown(true);
			setActionButtonText("Click to Pen Up");
		}
	}
	
}
