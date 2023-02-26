public class Player{
	//fields
	private static int currentId=1;
	private int id = 0;
	private String name;
	private int wins = 0;
	private int losses=0;
	private double winPercent=0;
	private boolean autoPlay;
	private int[] guesses;
	 int takeSticks = 0;
	
	//getters and setters
	public int getId() {return id;}
	public String getName(){return name;}
	public int getWins(){return wins;}
	public int getLosses(){return losses;}
	public double getWinPercent(){return winPercent;}
	public boolean getAutoPlay(){return autoPlay;}
	public int[] getGuesses(){return guesses;}
	public int getTakeSticks(){return takeSticks;}
	
	//constructor
	Player(String n){
		this.name = n;
		this.id= currentId;
		currentId++;
	}
	
	//public methods
	
	public int takeTurn(int[]bounds,stickGui sGui,int Sticks){
		sGui.displayMsg(name+", choose a number between " +bounds[0]+" and "+bounds[1]);
		boolean error = true;
		while(error){
			takeSticks= sGui.receiveIntReply();
			if(takeSticks >= bounds[0] && takeSticks <= bounds[1]){
				if(Sticks >= 0){
					sGui.displayMsg(name+" removed " +takeSticks +" sticks from the pile.");
					error = false;
					return takeSticks;
				}
			
			}else{
				
				sGui.displayMsg("Invalid number of sticks that can be removed.");
			}
		}
		return takeSticks;
		
		
	}
	
	public void addWins(){
		this.wins++;
	}
	public void addLosses(){
		this.losses++;
	}
}