package chessgame.pieces;

import boardgame.Board;
import chessgame.ChessPiece;
import chessgame.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
	}
	
	@Override
	public String toString() {
		return "K";
	}
}
