package chessgame;

import boardgame.BoardException;

public class ChessgameException extends BoardException{
	private static final long serialVersionUID = 1L;
	
	public ChessgameException(String msg) {
		super(msg);
	}
}
