package application;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import chessgame.ChessMatch;
import chessgame.ChessPiece;
import chessgame.ChessPosition;
import chessgame.ChessgameException;

public class Program {
	public static void main(String[] args) {
		
		
		Scanner scan = new Scanner(System.in);
		ChessMatch cm = new ChessMatch();
		List<ChessPiece> capturedPieces = new ArrayList<>();
		
		
		while (!cm.getCheckMate()) {
			try {
				UI.clearScreen();
				UI.printMatch(cm, capturedPieces);
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
				
				if (capturedPiece != null) {
					capturedPieces.add(capturedPiece);
				}
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
		UI.clearScreen();
		UI.printMatch(cm, capturedPieces);
	}

}
 