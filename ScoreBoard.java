public class ScoreBoard{
	//fields
	private Player[] players;
	private boolean showLosses = false;
	private boolean showRank =false;
	private boolean showWinPercentage = false;
	
	//constructors
	public ScoreBoard(Player[] ps){
		this.players = ps;
	}
	
	
	//public method
	public String sBoard(){
		int longestName =  players[0].getName().length();
		for(int i=0; i < players.length; i++){
			if(longestName < players[i].getName().length()){
				longestName=players[i].getName().length();
			}
		}
		String scoreB="===============";
		for(int j =0; j<longestName; j++){
			scoreB+= "=";
		}
		for(int i=0 ; i<players.length; i++){
			scoreB+= "\n||Name:"+players[i].getName();
			if(longestName>players[i].getName().length()){
				for(int j=0; j<(longestName-players[i].getName().length());j++){
					scoreB+= " ";
				}
			}else if(longestName<players[i].getName().length()){
				for(int j=0; j<(players[i].getName().length()-longestName);j++){
					scoreB+= " ";
				}
			}
			scoreB+=" Wins:"+players[i].getWins()+"|";
			
		}
		scoreB+="\n===============";
		for(int i=0; i<longestName;i++){
			scoreB+= "=";
		}
		return scoreB;
	}
}