package groupFiles;

public class MichaelDate implements Topic {
	
	private boolean inDateLoop;
	private boolean inDate = false;
	private String dateResponse;
	private String[] places = {"park","mall","beach","amusement park"};
	private String[] events = {"a wild dog has appeared","it started raining","I lost my keys"};
	private String[] eventActions = {"get ice cream","take pictures", "run around","eat food"};
	@Override
	public void talk() {
		// TODO Auto-generated method stub
		inDateLoop = true;
		while(inDateLoop){
			HansMain.print("Well... I guess. Where would you like to go? I recommend the " + pickRandom(places) + ".");
			dateResponse = HansMain.getInput();
			if (HansMain.findKeyword(dateResponse, "yes" , 0) >= 0 || HansMain.findKeyword(dateResponse, "fine" , 0) >= 0 ){
				HansMain.print("Sounds great! Let's go there now.");
				dateSimulate();
			}
			else{
				HansMain.print("You sure? I really want to go there...");
				dateResponse = HansMain.getInput();
				if (HansMain.findKeyword(dateResponse, "yes" , 0) >= 0 || HansMain.findKeyword(dateResponse, "fine" , 0) >= 0 ){
					HansMain.print("Yay. I'm so excited.");
					inDate=true;
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
		while (inDate){
			HansMain.print("Whew. That was a long walk.");
			//3 events and quit or user says quit
		}
	}
	
	public String pickRandom(String[] arr){
		return arr[(int)(Math.random()*arr.length)];
	}
}

