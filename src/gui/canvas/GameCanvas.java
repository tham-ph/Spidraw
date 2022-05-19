package gui.canvas;


import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public class GameCanvas extends StackPane {
	private Canvas entityCanvas;
	private Canvas drawingCanvas;
	private GraphicsContext graphicsContextEntityCanvas;
	private GraphicsContext graphicsContextDrawingCanvas;
	public GameCanvas() {
		this.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, new CornerRadii(8), new BorderWidths(8))));
		this.setBackground(new Background(new BackgroundFill(Color.WHITE,new CornerRadii(16), Insets.EMPTY)));
		this.setPrefWidth(600);
		this.setPrefHeight(600);
		
		entityCanvas = new Canvas(600, 600);
		drawingCanvas = new Canvas(600, 600);
		
		graphicsContextEntityCanvas = entityCanvas.getGraphicsContext2D();
		graphicsContextDrawingCanvas = drawingCanvas.getGraphicsContext2D();
		
		this.getChildren().addAll(drawingCanvas, entityCanvas);
	}
	public Canvas getEntityCanvas() {
		return entityCanvas;
	}
	public void setEntityCanvas(Canvas entityCanvas) {
		this.entityCanvas = entityCanvas;
	}
	public Canvas getDrawingCanvas() {
		return drawingCanvas;
	}
	public void setDrawingCanvas(Canvas drawingCanvas) {
		this.drawingCanvas = drawingCanvas;
	}
	public GraphicsContext getGraphicsContextEntityCanvas() {
		return graphicsContextEntityCanvas;
	}
	public void setGraphicsContextEntityCanvas(GraphicsContext graphicsContextEntityCanvas) {
		this.graphicsContextEntityCanvas = graphicsContextEntityCanvas;
	}
	public GraphicsContext getGraphicsContextDrawingCanvas() {
		return graphicsContextDrawingCanvas;
	}
	public void setGraphicsContextDrawingCanvas(GraphicsContext graphicsContextDrawingCanvas) {
		this.graphicsContextDrawingCanvas = graphicsContextDrawingCanvas;
	}
	
	
	
}
