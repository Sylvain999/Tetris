package phil.gametetris;

import static org.junit.Assert.assertEquals;

import org.junit.*;
import static org.mockito.Mockito.*;

import phil.gametetris.model.Board;
import phil.gametetris.model.ShapeSpawner;
import phil.gametetris.model.shapes.*;

public class BoardTest {
	
	Board board;
	ShapeSpawner spawner;
	
	@Before
	public void init() {
		this.board = new Board(14, 7);
		this.spawner = mock(ShapeSpawner.class);
		this.board.setSpawner(spawner);
	}
	
	private void SpawnerSpawnStraightShape() {
		when(this.spawner.spawnShape()).thenReturn(new StraightShape(board.getNbColumns() / 2, 1))
			.thenReturn(new StraightShape(board.getNbColumns() / 2, 1))
			.thenReturn(new StraightShape(board.getNbColumns() / 2, 1));
		
	}
	
	private void SpawnerSpawnLShape() {
		when(this.spawner.spawnShape()).thenReturn(new LShape(board.getNbColumns() / 2, 1))
			.thenReturn(new LShape(board.getNbColumns() / 2, 1))
			.thenReturn(new LShape(board.getNbColumns() / 2, 1));;
	}
	
	private void SpawnerSpawnTShape() {
		when(this.spawner.spawnShape()).thenReturn(new TShape(board.getNbColumns() / 2, 1))
			.thenReturn(new TShape(board.getNbColumns() / 2, 1))
			.thenReturn(new TShape(board.getNbColumns() / 2, 1));	
	}
	
	private void SpawnerSpawnSquareShape() {
		when(this.spawner.spawnShape()).thenReturn(new SquareShape(board.getNbColumns() / 2, 1))
			.thenReturn(new SquareShape(board.getNbColumns() / 2, 1))
			.thenReturn(new SquareShape(board.getNbColumns() / 2, 1));	
	}
	
	private void SpawnerSpawnLReverseShape() {
		when(this.spawner.spawnShape()).thenReturn(new LReverseShape(board.getNbColumns() / 2, 1))
			.thenReturn(new LReverseShape(board.getNbColumns() / 2, 1))
			.thenReturn(new LReverseShape(board.getNbColumns() / 2, 1));		
	}
	
	private void SpawnerSpawnZShape() {
		when(this.spawner.spawnShape()).thenReturn(new ZShape(board.getNbColumns() / 2, 1))
			.thenReturn(new ZShape(board.getNbColumns() / 2, 1))
			.thenReturn(new ZShape(board.getNbColumns() / 2, 1));
		
	}
	
	private void SpawnerSpawnSShape() {
		when(this.spawner.spawnShape()).thenReturn(new SShape(board.getNbColumns() / 2, 1))
			.thenReturn(new SShape(board.getNbColumns() / 2, 1))
			.thenReturn(new SShape(board.getNbColumns() / 2, 1));
	}

	
	
	@Test
	public void goodInit() {
		assertEquals( "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
	}
	
	
	
	@Test
	public void testSpawnStraightShape() {
		this.SpawnerSpawnStraightShape();
		this.board.nextFrame();
		
		assertEquals( "...X..."
					+ "...X..."
					+ "...X..."
					+ "...X..."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
		
		
	}
	
	
	@Test
	public void testSpawnZShape() {
		this.SpawnerSpawnZShape();
		this.board.nextFrame();
		
		assertEquals( "......."
					+ "..XX..."
					+ "...XX.."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
		
		
	}
	
	
	@Test
	public void testSpawnSShape() {
		this.SpawnerSpawnSShape();
		this.board.nextFrame();
		
		assertEquals( "......."
					+ "...XX.."
					+ "..XX..."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
		
		
	}
	
	

	
	@Test
	public void testSpawnLReverseShape() {
		this.SpawnerSpawnLReverseShape();
		this.board.nextFrame();
		
		assertEquals( "...X..."
					+ "...X..."
					+ "..XX..."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
		
		
	}
	

	@Test
	public void spawnLShape() {
		
		this.SpawnerSpawnLShape();
		
		this.board.nextFrame();	
		
		assertEquals( "...X..."
					+ "...X..."
					+ "...XX.."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
		
	}
	
	@Test
	public void spawnTShape() {
		this.SpawnerSpawnTShape();
		
		this.board.nextFrame();	
		
		assertEquals( "...X..."
					+ "..XXX.."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
	}
	
	@Test
	public void spawnSquareShape() {
		this.SpawnerSpawnSquareShape();
		
		this.board.nextFrame();	
		
		assertEquals( "...XX.."
					+ "...XX.."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
	}

	@Test
	public void spawnStraightShapeAndWait1Frame() {
		this.SpawnerSpawnStraightShape();
		
		this.board.nextFrame();
		this.board.nextFrame();
		
		assertEquals("......."
				   + "...X..."
				   + "...X..."
				   + "...X..."
				   + "...X..."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + ".......", board.toString());
	}
	
	
	@Test
	public void spawnStraightShapeGoDownStopAndSpawnAnOtherShape() {
		this.SpawnerSpawnStraightShape();
		
		for (int i=0; i<12; i++) {
			this.board.nextFrame();
		}
		
		
		assertEquals("...X..."
				   + "...X..."
				   + "...X..."
				   + "...X..."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "...X..."
				   + "...X..."
				   + "...X..."
				   + "...X...", board.toString());
	}
	
	@Test
	public void spawnStraightShapeAndCollisionWithOtherShape() {
		this.SpawnerSpawnStraightShape();
		
		for (int i=0; i<19; i++) {
			this.board.nextFrame();
		}
		
		
		assertEquals("...X..."
				   + "...X..."
				   + "...X..."
				   + "...X..."
				   + "......."
				   + "......."
				   + "...X..."
				   + "...X..."
				   + "...X..."
				   + "...X..."
				   + "...X..."
				   + "...X..."
				   + "...X..."
				   + "...X...", board.toString());
	}
	
	
	@Test
	public void spawnStraightShapeAndGoRight() {
		this.SpawnerSpawnStraightShape();
		
		this.board.nextFrame();
		this.board.goRight();
		
		
		assertEquals( "....X.."
					+ "....X.."
					+ "....X.."
					+ "....X.."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
	}
	
	
	@Test
	public void spawnStraightShapeAndGoRightAndGetStuck() {
		this.SpawnerSpawnStraightShape();
		
		this.board.nextFrame();
		for (int i=0; i<4; i++) {
			this.board.goRight();
		}
		
		assertEquals( "......X"
					+ "......X"
					+ "......X"
					+ "......X"
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
	}
	
	@Test
	public void spawnStraightShapeAndGoLeft() {
		this.SpawnerSpawnStraightShape();
		
		this.board.nextFrame();
		this.board.goLeft();
		
		
		assertEquals( "..X...."
					+ "..X...."
					+ "..X...."
					+ "..X...."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
	}
	
	@Test
	public void spawnStraightShapeAndGoLeftAndGetStuck() {
		this.SpawnerSpawnStraightShape();
		
		this.board.nextFrame();
		for (int i=0; i<4; i++) {
			this.board.goLeft();
		}		
		
		assertEquals( "X......"
					+ "X......"
					+ "X......"
					+ "X......"
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
	}
	
	@Test
	public void spawnStraightShapeStopNextToAnOther() {
		this.SpawnerSpawnStraightShape();
		
		for (int i=0; i<12; i++) {
			this.board.nextFrame();
		}
		this.board.goLeft();
		for (int i=0; i<11; i++) {
			this.board.nextFrame();
		}
		
		
		assertEquals("...X..."
				   + "...X..."
				   + "...X..."
				   + "...X..."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "..XX..."
				   + "..XX..."
				   + "..XX..."
				   + "..XX...", board.toString());
	}
	
	
	@Test
	public void spawnStraightShapeAndStopGoRightCauseOfAnOtherShape() {
		this.SpawnerSpawnStraightShape();
		
		for (int i=0; i<12; i++) {
			this.board.nextFrame();
		}
		this.board.goLeft();
		for (int i=0; i<7; i++) {
			this.board.nextFrame();
		}
		this.board.goRight();
		
		
		assertEquals("......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "..X...."
				   + "..X...."
				   + "..X...."
				   + "..XX..."
				   + "...X..."
				   + "...X..."
				   + "...X...", board.toString());
	}
	
	
	@Test
	public void spawnStraightShapeAndStopGoLeftCauseOfAnOtherShape() {
		this.SpawnerSpawnStraightShape();
		
		for (int i=0; i<12; i++) {
			this.board.nextFrame();
		}
		this.board.goRight();
		for (int i=0; i<7; i++) {
			this.board.nextFrame();
		}
		this.board.goLeft();
		
		
		assertEquals("......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "......."
				   + "....X.."
				   + "....X.."
				   + "....X.."
				   + "...XX.."
				   + "...X..."
				   + "...X..."
				   + "...X...", board.toString());
	}
	
	
	@Test
	public void spawnStraightShapeAndTurn() {
		this.SpawnerSpawnStraightShape();
		
		this.board.nextFrame();
		this.board.turnShape();		
		
		assertEquals( "......."
					+ ".XXXX.."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ "......."
					+ ".......", board.toString());
	}
	
	
	
	

}
