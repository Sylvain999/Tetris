package phil.gametetris.model.shapes;

import java.util.ArrayList;
import java.util.Collection;

import javafx.scene.paint.Color;
import phil.gametetris.model.Square;
import phil.gametetris.model.TetrisShape;

public class LShape extends TetrisShape {

	public LShape(int x, int y) {
		squares = new ArrayList<Square>();
		squares.add(new Square(x, y - 1));
		squares.add(new Square(x, y));
		squares.add(new Square(x, y + 1));
		squares.add(new Square(x + 1, y + 1));
	}

	@Override
	public void turn() {
		Square ref = (Square) squares.get(1).clone();
		squares.get(0).setLocation(ref.x + 1, ref.y);
		squares.get(2).setLocation(ref.x - 1, ref.y);
		squares.get(3).setLocation(ref.x - 2, ref.y);
	}

}
