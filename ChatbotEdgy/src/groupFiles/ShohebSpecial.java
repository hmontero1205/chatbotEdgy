package groupFiles;

public class ShohebSpecial implements Topic{
	private boolean inSpecialLoop;
	static String currentInteraction;
	private String[] approvals = {"Sure!", "OK ^_^", "Gladly", "Sure (^_^)", "Be gentle", "This is my first time"};
	private String[] rejections = {"Umm... I don't think I'm ready for that :/", "Sorry, I don't feel like it", "No thank you", "You're taking things too fast (>_<)", "You think I'm that easy huh?!", "No way jose"};
	private String[] affirmatives = {"yes", "of course", "i do", "yep", "i love you"};
	
	public void talk() {
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
						HansMain.print("I love you... do you love me too?");
						String response = HansMain.getInput();
						if(checkIfContains(response, affirmatives)){
							HansMain.print("Yaaaaaay (-^_^-)");
							HansMain.loveLevel = HansMain.loveLevel + 2;
						}
						else{
							HansMain.print("Oh... I'm sorry... I thought we were closer than that... T^T");
							HansMain.loveLevel = 3;
						}
					}
					else{
						HansMain.print(rejections[(int)(Math.random()*rejections.length)]);
						HansMain.loveLevel--;
					}
					break;
			}
			inSpecialLoop = false;
		}
		HansMain.talkForever();
	}
	
	public static boolean checkIfContains(String str, String[] arr){
		for (int i = 0; i<arr.length; i++){
			if (HansMain.findKeyword(str,arr[i], 0)>=0){
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"hold hands", "hug", "kiss"};
		for(int i = 0; i < triggers.length; i++){
			if(HansMain.findKeyword(userInput, triggers[i], 0) >= 0){
				currentInteraction = triggers[i];
				return true;
			}
		}
		return false;
	}
}
