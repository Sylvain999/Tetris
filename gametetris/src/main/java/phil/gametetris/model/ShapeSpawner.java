package phil.gametetris.model;

import phil.gametetris.model.shapes.StraightShape;

public class ShapeSpawner {
	
	private Board board;

	public ShapeSpawner(Board board) {
		super();
		this.board = board;
	}
	
	public TetrisShape spawnShape() {
		
		return this.spawnStraightShape();
		
	}

	public TetrisShape spawnStraightShape() {
		return new StraightShape(board.getNbColumns() / 2, 1);
	}

}
