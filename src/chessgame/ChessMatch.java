package chessgame;

import boardgame.Board;

// classe da partida de chadrez
public class ChessMatch {

	private Board board;
	
//	É função da classe da partida saber a dimensão do tabuleiro
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
//	Retorna a matriz de peças presente na partida
	public ChessPiece[][] getPieces() {
//		board possui uma variável do tipo piece[][], 
//		já no método retorna-se um tipo ChessPiece.
		ChessPiece[][] matriz = new ChessPiece[board.getRows()][board.getColumns()];
		
		for (int i=0; i<board.getRows(); i++) {
			for (int p=0; p<board.getColumns(); p++) {
//				DownCasting da classe piece para chesspiece
				matriz[i][p] = (ChessPiece) board.piece(i, p);
			}
		}
		
		return matriz;
	}
	
	
}
