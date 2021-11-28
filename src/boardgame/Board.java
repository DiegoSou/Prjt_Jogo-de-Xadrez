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
	
//	Retorna a matriz das peças
	public Piece piece(int row, int column) {
		return pieces[row][column];
	}
	
//	Sobrecarga do Método Piece de Peças
	public Piece piece(Position position) {
		return pieces[position.getRow()][position.getColumn()];
	}
	
	
//	Método para colocar uma peça, atribui uma posição a ela e tira do valor null
	public void placePiece(Piece piece, Position position) {
		pieces[position.getRow()][position.getColumn()] = piece;
		piece.position = position;
	}
}
