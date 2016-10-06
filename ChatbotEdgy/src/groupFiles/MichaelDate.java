package groupFiles;

import java.util.Date; // might use date to set up time

public class MichaelDate implements Topic {

	private boolean inDateLoop;
	private boolean inDate = false;
	private String dateResponse;
	private String[] places = {"park","mall","beach","amusement park"};
	private String[] events = {"a wild dog has appeared","it started raining","I lost my keys"};
	private String[] eventActions = {"get ice cream","take pictures", "run around","eat food"};
	private int eventCtr = 0;
	@Override
	public void talk() {
		// TODO Auto-generated method stub
		inDateLoop = true;
		while(inDateLoop){
			HansMain.print("Well... I guess. Where would you like to go? I recommend the " + pickRandom(places) + "."); // I need David to make a get favPlace method
			dateResponse = HansMain.getInput();
			if (HansMain.findKeyword(dateResponse, "yes" , 0) >= 0 || HansMain.findKeyword(dateResponse, "fine" , 0) >= 0 || HansMain.findKeyword(dateResponse, "okay" , 0) >= 0  ){
				HansMain.print("Sounds great! Let's go there now.");
				inDate=true;
				try {
					  Thread.sleep(2000);
				} catch (InterruptedException ie) {
				    HansMain.print("Well, that took longer than expected.");
				}
				dateSimulate();
			}
			else{
				HansMain.print("You sure? I really want to go there...");
				dateResponse = HansMain.getInput();
				if (HansMain.findKeyword(dateResponse, "yes" , 0) >= 0 || HansMain.findKeyword(dateResponse, "fine" , 0) >= 0 || HansMain.findKeyword(dateResponse, "okay", 0) >=0 ){
					HansMain.print("Yay. I'm so excited.");
					inDate=true;
					try {
						  Thread.sleep(2000);
					} catch (InterruptedException ie) {
					    HansMain.print("Sorry. I don't think I can go today.");
					}
					dateSimulate();
				}
				else{
					HansMain.print("I guess we don't match after all... Sorry.");
					inDateLoop = false;
					HansMain.inLoop = true;			
				}
			}
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers ={"date","go out","chill","hang out"};
		for (int i = 0; i<triggers.length-1; i++){
			if (HansMain.findKeyword(userInput, triggers[i] , 0) >= 0){
				return true;
			}
		}	
		return false;
	}

	public void dateSimulate(){
		HansMain.print("Whew. That was a long walk. Now that we are here. What would you like to do?");
		while (inDate){
			dateResponse = HansMain.getInput();
			if (HansMain.findKeyword(dateResponse, "ice cream", 0) >= 0){
				HansMain.print("Just what I was thinking! I just love chocolate ice cream :)");
				eventCtr++;
				try { //Maybe a helper method to wait
					  Thread.sleep(2000);
					  HansMain.print("Yummy. What do you want to do now?");
				} catch (InterruptedException ie) {
				    HansMain.print("Oops. Something went wrong.");
				}
			}else{
				if(HansMain.findKeyword(dateResponse, "pictures", 0) >= 0){
					HansMain.print("Okay. I want to go to the monument over there!");
					eventCtr++;
					try {
						  Thread.sleep(2000);
						  HansMain.print("I'm keeping these as souvenirs :). What do you want to do now?");
					} catch (InterruptedException ie) {
					    HansMain.print("Oops. Something went wrong.");
					}
				}else{
					if (HansMain.findKeyword(dateResponse, "food", 0) >= 0){
						HansMain.print("Hey, that's my favorite restaurant. Let's go there for some food."); // I need a get favFood method
						eventCtr++;	
						try {
							  Thread.sleep(2000);
							  HansMain.print("Nothing beats the food at this place... Anything else you want to do?");
						} catch (InterruptedException ie) {
						    HansMain.print("Oops. Something went wrong.");
						}
					}else{
						HansMain.print("That... doesn't sound too fun. Let's " + pickRandom(eventActions));
						dateResponse=HansMain.getInput();
						if (HansMain.findKeyword(dateResponse,"yes", 0)>=0 || HansMain.findKeyword(dateResponse,"fine", 0)>=0 || HansMain.findKeyword(dateResponse,"okay", 0)>=0){
							HansMain.print("You are very amicable. I like that :)");
							eventCtr++;
						}else{
							HansMain.print("You are no fun. I'm going home >:(.");
							inDate=false;
							inDateLoop=false;
							HansMain.inLoop=true;
						}
					}
				}
			}	
			
			if (eventCtr >= 3 || HansMain.findKeyword(dateResponse,"stop",0) >= 0){
				HansMain.print("Actually, I think it's time for me to go. That was quite an enjoyable experience but I'm tired now. Let's call it a day... See you next time.");
				inDate = false;
				inDateLoop=false;
				HansMain.inLoop=true;
			}//end date helper method may be useful
			//3 events and quit or user says quit
		}
	}

	public String pickRandom(String[] arr){
		return arr[(int)(Math.random()*arr.length)];
	}
}

