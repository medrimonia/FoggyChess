package foggyChess;

public enum ChessPlayer {
	NONE(' '),
	WHITE('W'),
	BLACK('B');
	
	private char shortName;
	
	ChessPlayer(char c){
		shortName = c;
	}
	
	public String toString(){
		return "" + shortName;
	}

}
