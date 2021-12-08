package chessgame;

import boardgame.Board;
import boardgame.Piece;

public abstract class ChessPiece extends Piece{
	
	private Color color;
	
	public ChessPiece(Board board, Color color) {
		super(board);
		this.color = color;
	}
	
//	A cor de uma peça deverá somente ser acessada. Não modicada
	public Color getColor() {
		return color;
	}

	
	
}
