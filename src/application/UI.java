package application;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import chessgame.ChessMatch;
import chessgame.ChessPiece;
import chessgame.ChessPosition;
import chessgame.Color;

//	user interface
public class UI {
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);
		}
		catch (RuntimeException e) {
			throw new InputMismatchException("Error reading ChessPosition. Valid values are from a1 to h8");
		}
	}
	
	
	public static void printBoard(ChessPiece[][] pieces) {
		for(int i=0; i<pieces.length; i++) {
//			impress�o das colunas, a contagem come�a por 8 e segue em ordem decrescente
			System.out.print((8-i) + " ");
			
//			impress�o das linhas, com o uso do m�todo para validar uma de cada vez
			for(int j=0; j<pieces[i].length; j++) {
				printPiece(pieces[i][j], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	
	public static void printMatch(ChessMatch cm, List<ChessPiece> capturedPieces) {
		printBoard(cm.getPieces());
		System.out.println();
		printCapturedPieces(capturedPieces);
		System.out.println();
		System.out.println("Turn: " + cm.getTurn());
		System.out.println("Waiting player: " + cm.getCurrentPlayer());
	}
	
	
//	impress�o do tabuleiro quando h� uma pe�a selecionada
	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for(int i=0; i<pieces.length; i++) {
			
			System.out.print((8-i) + " ");
			for(int j=0; j<pieces[i].length; j++) {
				printPiece(pieces[i][j], possibleMoves[i][j]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	
	
//	met�do para imprimir uma �nica pe�a
	private static void printPiece(ChessPiece piece, boolean background) {
		if(background) {
			System.out.print(ANSI_GREEN_BACKGROUND);
		}
		if(piece == null) {
			System.out.print("-" + ANSI_RESET);
		}else{
//			imprime pe�as coloridas, brancas e pretas(amarelas) e depois reseta a formata��o.
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
		}
		System.out.print(" ");
	}
	
//	Limpar hist�rico de impress�o do terminal 
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	private static void printCapturedPieces(List<ChessPiece> captured) {
//		filtrando da lista todos os elementos que possuem a cor == white e cor == black, separadamente
		List<ChessPiece> whites = captured.stream().filter(x -> x.getColor() == Color.WHITE).collect(Collectors.toList());
		List<ChessPiece> blacks = captured.stream().filter(x -> x.getColor() == Color.BLACK).collect(Collectors.toList());
		System.out.println("Captured pieces:");
		
		System.out.print("White: ");
		System.out.print(ANSI_WHITE);
		System.out.println(Arrays.toString(whites.toArray()));
		System.out.print(ANSI_RESET);
		
		System.out.print("Black: ");
		System.out.print(ANSI_YELLOW);
		System.out.println(Arrays.toString(blacks.toArray()));
		System.out.print(ANSI_RESET);
	}
}
