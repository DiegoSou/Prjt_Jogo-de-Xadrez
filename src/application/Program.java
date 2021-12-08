package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import chessgame.ChessMatch;
import chessgame.ChessPiece;
import chessgame.ChessPosition;
import chessgame.ChessgameException;

public class Program {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		ChessMatch cm = new ChessMatch();
		
		while (true) {
			try {
				UI.clearScreen();
				UI.printBoard(cm.getPieces());
				System.out.println();
				System.out.print("Source: ");
				ChessPosition source = UI.readChessPosition(scan);
				
//				ver os movimentos possíveis da peça escolhida (source)
				boolean[][] possibleMoves = cm.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(cm.getPieces(), possibleMoves);
				
				System.out.println();
				System.out.print("Target: ");
				ChessPosition target = UI.readChessPosition(scan);
				
				ChessPiece capturedPiece = cm.performChessMove(source, target);
			} 
			
			catch (ChessgameException e) {
				System.out.println(e.getMessage());
				scan.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println(e.getMessage());
				scan.nextLine();
			}
	
		}
	}

}
 