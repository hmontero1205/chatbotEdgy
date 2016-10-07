package groupFiles;

public class MichaelDate implements Topic {

	private boolean inDateLoop;
	private boolean inDate = false;
	private String dateResponse;
	private String[] places = {"park","mall","beach","amusement park"};
	private String[] eventActions = {"get ice cream","take pictures", "run around","eat food"};
	private int eventCtr = 0;

	private String[] userApprovalResponses={"yes","okay","fine","ok","I agree","sure","yea","yep","alright"};
	private String[] userNoResponses={"no","nope","never","nah","n't","don't"};
	private String[] botDateAgreement={"That sounds delightful.","Sounds great! Let's go there now.","Yay. I'm so excited.","It appears we were destined <3"};
	private String[] botReject={"I guess we don't match after all... Sorry.","Sike. I'm out.","I'm sorry. I don't think the stars are aligned when we are together."};

	public static boolean checkIfContains(String str, String[] arr){
		for (int i = 0; i<arr.length; i++){
			if (HansMain.findKeyword(str,arr[i], 0)>=0){
				return true;
			}
		}
		return false;
	}

	public static String pickRandom(String[] arr){
		return arr[(int)(Math.random()*arr.length)];
	}

	public boolean isTriggered(String userInput) {
		String[] triggers ={"date","go out","chill","hang out","hang"};
		for (int i = 0; i<triggers.length-1; i++){
			if (HansMain.findKeyword(userInput, triggers[i] , 0) >= 0){
				return true;
			}
		}	
		return false;
	}

	public void talk() {
		if (HansMain.loveLevel >=4){
			inDateLoop = true;
		}else{
			HansMain.print("I'm not ready for that yet...");
			inDateLoop = false;
			HansMain.talkForever();
		}
		while(inDateLoop){
			HansMain.print("Well... I guess. Where would you like to go? I recommend the " + pickRandom(places) + ".");
			dateResponse = HansMain.getInput();
			if (checkIfContains(dateResponse, userApprovalResponses)){
				HansMain.print(pickRandom(botDateAgreement));
				inDate=true;
				dateSimulate();
			}
			else{
				if (checkIfContains(dateResponse, userNoResponses)){
					HansMain.print("You sure? I really want to go there...");
					dateResponse = HansMain.getInput();
					if (checkIfContains(dateResponse, userApprovalResponses)){
						HansMain.print(pickRandom(botDateAgreement));
						inDate=true;
						dateSimulate();
					}else{
						if (checkIfContains(dateResponse,userNoResponses)){
							HansMain.print(pickRandom(botReject));
							inDateLoop = false;
							HansMain.inLoop = true;			
						}else{
							HansMain.print("Sorry. I don't understand you. I don't talk to aliens.");
							inDateLoop=false;
							HansMain.inLoop=true;
						}
					}
				}else{
					HansMain.print("Sorry. I don't understand you. I don't talk to aliens.");
					inDateLoop=false;
					HansMain.inLoop=true;
				}
			}
		}
	}

	public void dateSimulate(){
		HansMain.print("Whew. That was a long walk. Now that we are here. What would you like to do?");
		while (inDate){
			dateResponse = HansMain.getInput();
			if (HansMain.findKeyword(dateResponse, "ice cream", 0) >= 0){
				HansMain.print("Just what I was thinking! I just love chocolate ice cream :).");
				eventCtr++;
				HansMain.print("Yummy. What do you want to do now?");
			}else{
				if(HansMain.findKeyword(dateResponse, "pictures", 0) >= 0){
					HansMain.print("Okay. I want to go to the monument over there!");
					eventCtr++;
					HansMain.print("Okay okay. Enough pictures. Let's do something else.");
				}else{
					if (HansMain.findKeyword(dateResponse, "food", 0) >= 0){
						HansMain.print("Hey, that's my favorite restaurant. Let's go there for some food.");
						eventCtr++;	
						HansMain.print("Nothing beats the food at this place... Anything else you want to do?");
					}else{
						HansMain.print("That... doesn't sound too fun. Let's " + pickRandom(eventActions) + ".");
						dateResponse=HansMain.getInput();
						if (checkIfContains(dateResponse, userApprovalResponses)){
							HansMain.print("You are very amicable. I like that :). You want to go anywhere else, "+DavidConfigure.getSalutation()+"?");
							eventCtr++;
						}else{
							HansMain.print("You are no fun. I'm going home >:(.");
							inDate=false;
							inDateLoop=false;
							HansMain.inLoop=true;
							HansMain.loveLevel--;
						}
					}
				}
			}	

			if (inDate && eventCtr >= 3 || HansMain.findKeyword(dateResponse,"stop",0) >= 0){
				HansMain.print("Actually, I think it's time for me to go. That was quite an enjoyable experience but I'm tired now. This is the end of our date... See you next time, "+DavidConfigure.getSalutation()+"!");
				inDate = false;
				inDateLoop=false;
				HansMain.inLoop=true;
				HansMain.loveLevel+=2;
			}
		}
	}
}

