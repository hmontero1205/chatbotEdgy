package groupFiles;

//import chatBot.ShohebMain;

public class ShohebSpecial implements Topic{
	//private boolean inSpecialLoop;
	static String currentInteraction;
	static int possibleAt;
	private String[] approvals = {"Sure!", "OK ^_^", "Gladly"};
	private String[] politeRejections = {"Umm... I don't think I'm ready for that :/", "Sorry, I don't feel like it", "No thank you"};
	private String[] angeryRejections = {"You're taking things too fast (>_<)", "You think I'm that easy huh?!", "No way jose"};
	
	public void talk() {
		//inSpecialLoop = true;
		if(HansMain.loveLevel >= possibleAt){
			HansMain.print(approvals[(int)(Math.random()*3)]);
			HansMain.loveLevel++;
			HansMain.frustrationLevel--;
		}
		else if(HansMain.frustrationLevel < 2){
			HansMain.print(politeRejections[(int)(Math.random()*3)]);
			HansMain.frustrationLevel++;
		}
		else{
			HansMain.print(angeryRejections[(int)(Math.random()*3)]);
			HansMain.frustrationLevel++;
			HansMain.loveLevel--;
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"hold hands", "hug", "kiss", "marry"};
		for(int i = 0; i < triggers.length; i++){
			if(HansMain.findKeyword(userInput, triggers[i], 0) >= 0){
				currentInteraction = triggers[i];
				possibleAt = i + 4;
				return true;
			}
		}
		return false;
	}


}
