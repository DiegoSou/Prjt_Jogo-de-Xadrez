package boardgame;

public class Board {
	
//	Quantity of rows and columns on board / Quantidade de linhas e colunas do tabuleiro
	private int rows;
	private int columns;
	private Piece[][] pieces;
	
	public Board(int rows, int columns) {
		this.rows = rows;
		this.columns = columns;
		pieces = new Piece[rows][columns];
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public int getColumns() {
		return columns;
	}

	public void setColumns(int columns) {
		this.columns = columns;
	}
	
//	Retorna a matriz das pe�as
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
//	Sobrecarga do M�todo Piece de Pe�as
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	
//	M�todo para colocar uma pe�a, atribui uma posi��o a ela e tira do valor null
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
}
