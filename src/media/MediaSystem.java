package media;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MediaSystem {
	private static MediaPlayer collectedItemSoundEffectPlayer;
	private static MediaPlayer clickedSoundEffectPlayer;
	private static MediaPlayer drawingSoundEffectPlayer;
	
	public static void init() {
		collectedItemSoundEffectPlayer = new MediaPlayer(new Media(ClassLoader.getSystemResource("collect.mp3").toString()));
		clickedSoundEffectPlayer = new MediaPlayer(new Media(ClassLoader.getSystemResource("click.wav").toString()));
		drawingSoundEffectPlayer = new MediaPlayer(new Media(ClassLoader.getSystemResource("scribble.mp3").toString()));
	
		clickedSoundEffectPlayer.setOnEndOfMedia(() -> {
			clickedSoundEffectPlayer.stop();
		});
		
		collectedItemSoundEffectPlayer.setOnEndOfMedia(() -> {
			collectedItemSoundEffectPlayer.stop();
		});
		
		drawingSoundEffectPlayer.setOnEndOfMedia(() -> {
			drawingSoundEffectPlayer.stop();
		});
	}
	
	public static MediaPlayer getCollectedItemSoundEffectPlayer() {
		return collectedItemSoundEffectPlayer;
	}

	public static void setCollectedItemSoundEffectPlayer(MediaPlayer collectedItemSoundEffectPlayer) {
		MediaSystem.collectedItemSoundEffectPlayer = collectedItemSoundEffectPlayer;
	}

	public static MediaPlayer getClickedSoundEffectPlayer() {
		return clickedSoundEffectPlayer;
	}

	public static void setClickedSoundEffectPlayer(MediaPlayer clickedSoundEffectPlayer) {
		MediaSystem.clickedSoundEffectPlayer = clickedSoundEffectPlayer;
	}

	public static MediaPlayer getDrawingSoundEffectPlayer() {
		return drawingSoundEffectPlayer;
	}

	public static void setDrawingSoundEffectPlayer(MediaPlayer drawingSoundEffectPlayer) {
		MediaSystem.drawingSoundEffectPlayer = drawingSoundEffectPlayer;
	}
	
	
}
