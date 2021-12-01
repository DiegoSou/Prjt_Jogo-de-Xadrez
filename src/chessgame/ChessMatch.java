package chessgame;

import boardgame.Board;
import chessgame.pieces.King;
import chessgame.pieces.Rook;

// classe da partida de chadrez
public class ChessMatch {

	private Board board;
	
//	� fun��o da classe da partida saber a dimens�o do tabuleiro
//	Assim que inicia a partida, ele declara o tabuleiro e chama o m�todo de coloca��o inicial das pe�as
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
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
	
//	colocar uma pe�a passando as coordenadas na escrita do xadrez, simplificando a l�gica
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
//	M�todo de organiza��o e coloca��o inicial das pe�as
	private void initialSetup(){
		placeNewPiece('b', 6, new Rook(board, Color.WHITE)); // new Position(2, 1)
		placeNewPiece('e', 8, new King(board, Color.BLACK)); // new Position(0, 4)
		placeNewPiece('e', 1, new King(board, Color.BLACK)); // new Position(7, 4)
	}
	
}
