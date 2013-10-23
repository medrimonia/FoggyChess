package foggyChess;

import pieces.ChessPiece;

public class ChessBoard {
	public static int dim = 8;
	
	protected ChessSquare[][] board;
	
	public ChessBoard(){
		board = new ChessSquare[dim][dim];
		for (int row = 0; row < dim; row++)
		{
			for (int col = 0; col < dim; col++)
			{
				board[row][col] = new ChessSquare();
			}
		}
	}

	public void freeAllSquares() {
		for (int row = 0; row < dim; row ++){
			for (int col = 0; col < dim; col++){
				board[row][col].free();
			}
		}
	}

	public void place(ChessPiece p, int row, int col) {
		board[row][col].place(p);
	}
	
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		for (int row = 0; row < dim; row++)
		{
			for (int col = 0; col < dim; col++)
			{
				sb.append(board[row][col].toString());
				sb.append('|');
			}
			sb.deleteCharAt(sb.length() -1);
			sb.append('\n');
		}
		return sb.toString();
	}

}
