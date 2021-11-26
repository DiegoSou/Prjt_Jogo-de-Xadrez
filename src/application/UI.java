package application;

import chessgame.ChessPiece;

//	user interface
public class UI {
	
	public static void printBoard(ChessPiece[][] pieces) {
		for(int i=0; i<pieces.length; i++) {
//			impress�o das colunas, a contagem come�a por 8 e segue em ordem decrescente
			System.out.print((8-i) + " ");
			
//			impress�o das linhas, com o uso do m�todo para validar uma de cada vez
			for(int j=0; j<pieces[i].length; j++) {
				printPiece(pieces[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	
//	met�do para imprimir uma �nica pe�a
	private static void printPiece(ChessPiece piece) {
		if(piece == null) {
			System.out.print("-");
		}else{
			System.out.print(piece);
		}
		System.out.print(" ");
	}
}
