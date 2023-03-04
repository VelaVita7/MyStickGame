public class AIplayer extends Player {
	//fields
	//I am the player 
	//constructor
	public AIplayer(String n){
		super(n);
	}
	
	@Override
	public int takeTurn(int[] bounds,stickGui sGui,int Sticks){
		int cpAnswer = Sticks%(bounds[1]+1);
		if(cpAnswer==0){
			takeSticks = (int)(Math.random()*(bounds[1]-bounds[0]+1)+bounds[0]);
			sGui.displayMsg(getName()+" remove "+takeSticks+" sticks from the pile.");
			return takeSticks;
		}else{
			takeSticks = cpAnswer;
			sGui.displayMsg(getName()+" remove "+takeSticks+" sticks from the pile.");
			return takeSticks;
		}
		
	}
	//TXkgU3RpY2tnYW1lIGlzIHRoZSBiZXN0IQ==
}
