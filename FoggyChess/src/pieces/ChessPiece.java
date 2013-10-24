package pieces;

import foggyChess.ChessPlayer;

public class ChessPiece {
	
	private ChessPlayer owner;
	private char shortName;
	
	protected ChessPiece(ChessPlayer owner, char shortName)
	{
		this.owner = owner;
		this.shortName = shortName;
	}
	
	public ChessPlayer getOwner(){
		return owner;
	}
	
	public String toString(){
		return getOwner().toString() + shortName;
	}

}
