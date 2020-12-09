package phil.gametetris.model;

import java.util.ArrayList;

import javafx.scene.paint.Color;

public abstract class TetrisShape {
	
	protected ArrayList<Square> squares;

	protected Color color;
	
	public ArrayList<Square> getSquares() {
		return this.squares;
	}
	
	// on tourne à partir du deuxième élément dans squares
	public abstract void turn();
	
	public void goDown() {
		for (Square s : this.squares) {
			s.y = s.y + 1;
		}
	}

	public void goRight(int nbColumns) {
		for (Square s : this.squares) {
			s.x = s.x + 1;
		}
	}

	public void goLeft() {
		for (Square s : this.squares) {
			s.x = s.x - 1;
		}
	}

}
