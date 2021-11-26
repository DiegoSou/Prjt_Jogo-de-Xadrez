package chessgame;

import boardgame.Board;

// classe da partida de chadrez
public class ChessMatch {

	private Board board;
	
//	� fun��o da classe da partida saber a dimens�o do tabuleiro
	public ChessMatch() {
		board = new Board(8, 8);
	}
	
//	Retorna a matriz de pe�as presente na partida
	public ChessPiece[][] getPieces() {
//		board possui uma vari�vel do tipo piece[][], 
//		j� no m�todo retorna-se um tipo ChessPiece.
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
