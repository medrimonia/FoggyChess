package foggyChess;

import pieces.ChessPiece;

public class ChessSquare {
	
	private ChessPiece content;
	
	public ChessSquare()
	{
		content = null;
	}
	
	public void place(ChessPiece p)
	{
		content = p;
	}
	
	public ChessPlayer owner()
	{
		if (isEmpty()) return ChessPlayer.NONE;
		return content.getOwner();
	}
	
	public boolean isEmpty()
	{
		return content == null;
	}
	
	public void free()
	{
		content = null;
	}
	
	public String toString(){
		if (isEmpty())
			return "  ";
		return content.toString();
	}

}
