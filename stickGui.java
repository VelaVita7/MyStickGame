public class stickGui extends GUI {
	//fields
	
	//constructor
	
	//public method
	
	public void displaySticks(int s){
		
		String sticks = "********Sticks*********";
		sticks+="\n";
		for(int i = 1;i<=s;i++){
			sticks+=("|");
			if(i%5==0){
				sticks+=(" ");
			}
			if(i%20==0){
				sticks+="\n";
				sticks+=("\n");
			}
		}
		sticks+="\n";
		sticks+="***********************";
		sticks+="\n";
		System.out.print(sticks);
	}
	
	
}