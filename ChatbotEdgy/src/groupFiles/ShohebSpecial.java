package groupFiles;

//import chatBot.ShohebMain;

public class ShohebSpecial implements Topic{
	private boolean inSpecialLoop;
	static String currentInteraction;
	private String[] approvals = {"Sure!", "OK ^_^", "Gladly", "Sure (^_^)", "Be gentle", "This is my first time"};
	private String[] rejections = {"Umm... I don't think I'm ready for that :/", "Sorry, I don't feel like it", "No thank you", "You're taking things too fast (>_<)", "You think I'm that easy huh?!", "No way jose"};
	
	public void talk() {
		//inSpecialLoop = true;
		/*if(HansMain.loveLevel >= possibleAt){
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
		}*/
		inSpecialLoop = true;
		while(inSpecialLoop){
			switch (currentInteraction){
				case "hold hands":
					if(HansMain.loveLevel >= 4){
						HansMain.print(approvals[(int)(Math.random()*approvals.length)] + "... *holds your hand*");
						HansMain.loveLevel++;
					}
					else{
						HansMain.print(rejections[(int)(Math.random()*rejections.length)]);
						HansMain.loveLevel--;
					}
					break;
				case "hug":
					if(HansMain.loveLevel >= 5){
						HansMain.print(approvals[(int)(Math.random()*approvals.length)] + "... *hugs*");
						HansMain.loveLevel++;
					}
					else{
						HansMain.print(rejections[(int)(Math.random()*rejections.length)]);
						HansMain.loveLevel--;
					}
					break;
				case "kiss":
					if(HansMain.loveLevel >= 7){
						HansMain.print(approvals[(int)(Math.random()*approvals.length)] + "... *leans in*");
						HansMain.loveLevel++;
					}
					else{
						HansMain.print(rejections[(int)(Math.random()*rejections.length)]);
						HansMain.loveLevel--;
					}
					break;
				
			}
		}
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"hold hands", "hug", "kiss", "marry"};
		for(int i = 0; i < triggers.length; i++){
			if(HansMain.findKeyword(userInput, triggers[i], 0) >= 0){
				currentInteraction = triggers[i];
				return true;
			}
		}
		return false;
	}


}
