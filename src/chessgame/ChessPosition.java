package chessgame;

import boardgame.Position;

public class ChessPosition {
	private char column;
	private int row;
	
//	classe para identificar uma posi��o na partida, agora usando a base de linha-coluna 
//	ao inv�s de uma matriz de dois inteiros, como � no caso da classe Position
	public ChessPosition(char column, int row) {
		if (column < 'a' || column > 'h' || row < 1) {
			throw new ChessgameException("Error instantianing ChessPosition. Valid values are from a1 at h8");
		}
		this.column = column;
		this.row = row;
	}

	public char getColumn() {
		return column;
	}

	public int getRow() {
		return row;
	}

	

//	converte pra matriz de position
	protected Position toPosition() {
//		para identificar qual linha se refere na matriz basta subtrair o n�mero total de linhas com o n�mero inserido
//		para saber a posi��o da coluna basta subtrair o caractere referente a coluna com o caractere final da coluna
		return new Position(8 - row, column - 'a');
	}
	
//	Converte um matriz[linha][coluna] para uma chessPosition
	protected static ChessPosition fromPosition(Position position) {
		return new ChessPosition( (char)('a' - position.getColumn()), (8 - position.getRow()) );
	}
	
	@Override
	public String toString() {
		return "" + column + row;
	}
}
