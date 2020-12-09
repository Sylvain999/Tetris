package phil.gametetris.model.shapes;

import java.util.ArrayList;

import phil.gametetris.model.Square;
import phil.gametetris.model.TetrisShape;

public class ZShape extends TetrisShape {

	
	public ZShape(int x, int y) {
		squares = new ArrayList<Square>();
		squares.add(new Square(x-1, y));
		squares.add(new Square(x, y));
		squares.add(new Square(x, y + 1));
		squares.add(new Square(x + 1, y + 1));
	}
	
	@Override
	public void turn() {
		// TODO Auto-generated method stub

	}

}
