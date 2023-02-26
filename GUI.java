 /*
List of available methods:
	public void displayMsg(String msg)
	public String receiveStringReply()
	public int receiveIntReply()
	public boolean receiveBooleanReply()
*/
import java.util.Scanner;

public class GUI {
//fields ------------------------------------------------------
	public Scanner kb = new Scanner(System.in);
	
//constructor -------------------------------------------------

//setters and getters -----------------------------------------

//methods -----------------------------------------------------
	public void displayMsg(String msg){
		System.out.println(msg);
	}
	
	public String receiveStringReply() {
		return kb.next();
	}
	public int receiveIntReply() {
		boolean keepGoing = true;
		while(keepGoing){
			String reply = kb.next();
			boolean validData = GUI.isNumeric(reply);
			if (validData){
				keepGoing = false;				
				return Integer.parseInt(reply);
			} else {
				System.out.println("Invalid input. Type an integer.");
				keepGoing = true;				
			}
		}
		return 0; 
	}
	
	public boolean receiveBooleanReply() {
		boolean keepGoing = true;
		boolean returnValue = true;
		while(keepGoing){
			String reply = kb.next();
			if (reply.toUpperCase().equals("Y")||reply.toLowerCase().equals("yes")){
				returnValue = true;
				keepGoing = false;				
			} else if (reply.toUpperCase().equals("N")||reply.toUpperCase().equals("NO")){
				returnValue = false;
				keepGoing = false;				
			} else {
				System.out.println("Invalid input. Choose yes or no.");
				keepGoing = true;				
			}
		}
		return returnValue;
	}

// Private Methods -----------------------------------------------------	
	private static boolean isNumeric(String str)  {  
		try{  
			int i = Integer.parseInt(str);  
		} catch (NumberFormatException nfe){  
			return false;  
		}  
		return true;  
	}
}