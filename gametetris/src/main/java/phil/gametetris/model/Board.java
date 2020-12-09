package phil.gametetris.model;

import java.util.ArrayList;
import java.util.Optional;

public class Board {

	private static final int NB_COLUMNS = 25;
	private static final int NB_ROWS = 15;
	private ArrayList<Square> board;
	private TetrisShape shape;
	private int nbRows;
	private int nbColumns;
	private ShapeSpawner spawner;

	public Board(int nbRows, int nbColumns) {
		this.spawner = new ShapeSpawner(this);
		this.board = new ArrayList<Square>();
		this.nbRows = nbRows;
		this.nbColumns = nbColumns;
	}

	public Board() {
		this(NB_ROWS, NB_COLUMNS);
	}
	
	public int getNbRows() {
		return nbRows;
	}

	public int getNbColumns() {
		return nbColumns;
	}
	
	public void setSpawner(ShapeSpawner spawner) {
		this.spawner = spawner;
	}
	
	public void setShape(TetrisShape shape) {
		this.shape = shape;
	}

	public void nextFrame() {
		if(this.shape == null) {
			spawShape();
		}else {
			if (this.collisionToGoDown()) {
				this.fixShape();
				spawShape();
			} else {
				this.shape.goDown();
			}
		}
		
	}

	private void spawShape() {
		this.shape = spawner.spawnShape();
	}
	
	public void goRight() {
		if (!collisionToGoRight()) {
			this.shape.goRight(this.nbColumns);
		}
	}

	private boolean collisionToGoRight() {
		boolean collision = false;
		for(Square s : shape.getSquares()) {
			collision = stuckToBorderRight(s) || stuckToOtherSquare(s);
			if (collision) break;
		}
		return collision;
	}

	private boolean stuckToOtherSquare(Square sShape) {
		boolean verif = false;
		for (Square s : board) {
			verif = sShape.y == s.y && sShape.x == s.x - 1;
			if (verif) break;
		}
		return verif;
	}

	private boolean stuckToBorderRight(Square square) {
		return square.x == nbColumns - 1;
	}

	public void goLeft() {
		if (!collisionToGoLeft()) {
			this.shape.goLeft();
		}
	}
	
	private boolean collisionToGoLeft() {
		boolean collision = false;
		for(Square s : shape.getSquares()) {
			collision = stuckToBorderLeft(s) || stuckToOtherSquareLeft(s);
			if (collision) break;
		}
		return collision;
	}

	private boolean stuckToOtherSquareLeft(Square sShape) {
		boolean verif = false;
		for (Square s : board) {
			verif = sShape.y == s.y && sShape.x == s.x+ 1;
			if (verif) break;
		}
		return verif;
	}

	private boolean stuckToBorderLeft(Square square) {
		return square.x == 0;
	}

	public void turnShape() {
		this.shape.turn();
		
	}

	public boolean[][] toArray() {
		boolean[][] array = new boolean[this.nbRows][this.nbColumns];

		initArray(array);

		modifArrayThroughBoard(array);

		modifArrayThroughShape(array);

		return array;
	}
	

	private void modifArrayThroughShape(boolean[][] array) {
		if (this.shape != null) {
			for (Square s : this.shape.getSquares()) {
				array[s.y][s.x] = true;
			}
		}
	}

	private void modifArrayThroughBoard(boolean[][] array) {
		for (Square s : this.board) {
			array[s.y][s.x] = true;
		}
	}

	private void initArray(boolean[][] array) {
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++) {
				array[x][y] = false;

			}
		}
	}

	
	
	private void fixShape() {
		this.board.addAll(this.shape.getSquares());
	}

	private boolean collisionToGoDown() {
		boolean collision = false;
		for (Square sShape : this.shape.getSquares()) {
			collision = (sShape.y == this.nbRows - 1);

			for (Square s : this.board) {
				collision = collision || collisionBetweenShapes(sShape, s);
				if (collision)
					break;
			}
			if (collision)
				break;
		}
		return collision;
	}

	private boolean collisionBetweenShapes(Square sShape, Square sBoard) {
		return sShape.y == sBoard.y - 1 && sShape.x == sBoard.x;
	}
	
	
	public String toString() {
		boolean[][] array = toArray();
		String boardString = "";
		for (int x = 0; x < array.length; x++) {
			for (int y = 0; y < array[x].length; y++) {
				boardString += (array[x][y]) ? "X" : ".";
			}
		}
		return boardString;
	}

	

}
