package foggyChess;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import pieces.Bishop;
import pieces.ChessPiece;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Queen;
import pieces.Rook;

public class FoggyChess {
	
	private HashMap<ChessPlayer, List<ChessPiece>> pieces;
	ChessBoard currentState;
	
	private void addPiece(ChessPiece p, int row, int col)
	{
		pieces.get(p.getOwner()).add(p);
		currentState.place(p, row, col);
	}
	
	private void initGame(){
		pieces.get(ChessPlayer.WHITE).clear();
		pieces.get(ChessPlayer.BLACK).clear();
		currentState.freeAllSquares();
		// Adding Pawns	
		for (int col = 0; col < ChessBoard.dim; col++){
			addPiece(new Pawn(ChessPlayer.WHITE), 1, col);
			addPiece(new Pawn(ChessPlayer.BLACK), 6, col);
		}
		int delta = 1;
		for (int ref = 0; ref < ChessBoard.dim; ref += ChessBoard.dim - 1)
		{
			addPiece(new Rook(ChessPlayer.WHITE), 0, ref);
			addPiece(new Rook(ChessPlayer.BLACK), 7, ref);
			addPiece(new Knight(ChessPlayer.WHITE), 0, ref + delta);
			addPiece(new Knight(ChessPlayer.BLACK), 7, ref + delta);
			addPiece(new Bishop(ChessPlayer.WHITE), 0, ref + 2 * delta);
			addPiece(new Bishop(ChessPlayer.BLACK), 7, ref + 2 * delta);
			delta *= -1;
		}
		addPiece(new Queen(ChessPlayer.WHITE), 0, 3);
		addPiece(new Queen(ChessPlayer.BLACK), 7, 3);
		addPiece(new King(ChessPlayer.WHITE), 0, 4);
		addPiece(new King(ChessPlayer.BLACK), 7, 4);
	}
	
	public void display()
	{
		System.out.print(currentState.toString());
	}
	
	public FoggyChess(){
		currentState = new ChessBoard();
		pieces = new HashMap<ChessPlayer, List<ChessPiece>>();
		pieces.put(ChessPlayer.WHITE, new LinkedList<ChessPiece>());
		pieces.put(ChessPlayer.BLACK, new LinkedList<ChessPiece>());
		initGame();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FoggyChess game = new FoggyChess();
		game.display();
	}

}
