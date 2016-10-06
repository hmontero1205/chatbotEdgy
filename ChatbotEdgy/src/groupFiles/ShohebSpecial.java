package groupFiles;

//import chatBot.ShohebMain;

public class ShohebSpecial implements Topic{
	

	public void talk() {
		// TODO Auto-generated method stub xd
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers = {"hug", "hold hand", "kiss", "engage", "marry"};
		for(int i = 0; i < triggers.length; i++){
			if(HansMain.findKeyword(userInput, triggers[i], 0) >= 0){
				return true;
			}
		}
		return false;
	}


}
