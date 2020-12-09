package phil.gametetris.model;

import java.awt.Point;

import javafx.scene.paint.Color;

public class Square extends Point{
	
	private Color color;
	
	public Square(int x, int y) {
		this(x, y, Color.DARKGREEN);
	}

	public Square(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	public boolean stuckToBorderRight(int nbColumns) {
		return this.x == nbColumns - 1;
	}

	public boolean stuckToBorderLeft() {
		return this.x == 0;
	}

}
