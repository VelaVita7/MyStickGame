public class Game{
	//fields
	private int whoseTurn = 0;
	private int totalTurns =0;
	private int[] bounds = new int[2];
	private int target;
	private Player[] players=new Player[2];
	//GUI gui = new GUI();
	private boolean noWinner=true;
	private boolean playersPresent=false;
	stickGui sGui = new stickGui();
	int pileSize = 30;
	private int Sticks;
	


	//constructor
	
	//public methods
	public void reset(){
		pileSize=30;
		if(!playersPresent){
			sGui.displayMsg("----------------------------");
			sGui.displayMsg("|Welcome to the Stick Game!|");
			sGui.displayMsg("----------------------------");
			collectPlayerNames();
		}
		setBounds();
		noWinner=true;
	}
	
	public boolean play(){
		System.out.println("--------------------");
		System.out.println("There are "+ pileSize +" sticks.");
		System.out.println("--------------------");
		sGui.displayMsg("");
		while(noWinner){
			int pSticks = players[whoseTurn].takeTurn(bounds,sGui,Sticks);
			Sticks=Sticks-pSticks;
			if(Sticks>=0){
				sGui.displaySticks(Sticks);
				sGui.displayMsg("");
				sGui.displayMsg("There are "+ Sticks +" sticks left in the pile.");
				if(Sticks ==0){
					noWinner=false;
					players[whoseTurn].addWins();
					for(int losers= 0; losers<players.length; losers++){
						if(losers != whoseTurn){
							players[losers].addLosses();
						}
					}
					congradulations();
					this.WhoseTurn();
					
					sGui.displayMsg("\n");
					sGui.displayMsg("Would you like to play again?");
					boolean playAgain = sGui.receiveBooleanReply();
					if(playAgain){
						sGui.displayMsg("Would you like to select new players?");
						if(sGui.receiveBooleanReply()){
							playersPresent =false;
							return playAgain;
						}
					}
					return playAgain;
				}
			}else if(Sticks < 0){
				sGui.displayMsg("!!!You cannot go below zero sticks!!!!");
				Sticks=Sticks+players[whoseTurn].takeSticks;
			}
			this.WhoseTurn();
		}
		return noWinner;
	}
	
	
	
	//private methods
	private String[] collectPlayerNames() {
	
		String[] name = new String[players.length];
		Player[] eachPlayer = new Player[name.length];
		for(int i = 0; i<name.length;i++){
			sGui.displayMsg("Is Player "+(i+1)+"a computer?");
			if(sGui.receiveBooleanReply()){
				eachPlayer[i]=new AIplayer("Computer "+(i+1));
			}else{
				sGui.displayMsg("What is player "+(i+1)+"'s"+" name?");
				name[i]=sGui.receiveStringReply();
				eachPlayer[i]=new Player(name[i]);
			}
			
		}
		this.players=eachPlayer;
		playersPresent=true;
		return name;
	}
	
	private boolean congradulations(){
		sGui.displayMsg(players[whoseTurn].getName()+" won the game!");
		ScoreBoard scoreBoard = new ScoreBoard(players);
		System.out.print(scoreBoard.sBoard());
		return false;
	}
	
	
	private void setBounds(){
		sGui.displayMsg("Do you want to change the stick pile size instead of "+pileSize+" sticks?\n(Yes or No)?");
		boolean pileOfSticks = sGui.receiveBooleanReply();
		if(pileOfSticks){
			sGui.displayMsg("What is your desired stick pile size?");
			pileSize = sGui.receiveIntReply();
			Sticks= this.pileSize;
		}else{
			Sticks=this.pileSize;
		}
		
		sGui.displayMsg("Do you want change the amount of sticks you want to remove from 1 - 4?\n(Yes or No)?");
		boolean rangeOfSticks = sGui.receiveBooleanReply();
		boolean correctRange = true;
		
			
		if(!rangeOfSticks){
			bounds[0] = 1;
			bounds[1] = 4;
			sGui.displayMsg("The amount of sticks you can remove is set to: "+bounds[0]+" - "+bounds[1]+".");
		}else{
			while(correctRange){
				sGui.displayMsg("Pick a range of how many sticks you want to pick:");
				sGui.displayMsg("(Range must be > 0)");
				sGui.displayMsg("-------------------------------------------------");
				bounds[0]= 1;
				sGui.displayMsg("What is your maximum amount of sticks?");
				bounds[1]=sGui.receiveIntReply();
				if(bounds[0]<bounds[1]){
					sGui.displayMsg("The amount of sticks you can remove is set to: " +bounds[0]+" - "+bounds[1]+".");
					correctRange=false;
				}else{
					sGui.displayMsg("Error: your range is invaild.");
					correctRange=true;
				}
			}
		}
	}
	private void WhoseTurn(){
		if (whoseTurn+1<players.length){
			whoseTurn++;
		}else if(whoseTurn+1==players.length){
			whoseTurn=0;
		}
	}
	

}