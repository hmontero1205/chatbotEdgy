package groupFiles;
//import ChatbotEdgy.HansMain;

public class HansQuestions {
	private boolean inQuestionsLoop;
	private String questionsResponse;
	
	public void talk() {
		inQuestionsLoop = true;
		while(inQuestionsLoop){
			HansMain.print("Questions are fun! Ask another!");
			questionsResponse = HansMain.getInput();
			if(HansMain.findKeyword(questionsResponse, "break", 0)>=0 || !questionsResponse.substring(questionsResponse.length()-1).equals("?") ){
				inQuestionsLoop = false;
				HansMain.talkForever();
			}
			else
				HansMain.print("I have no answer to that question yet!");
		}

	}

	public boolean isTriggered(String userInput) {
		//String[] triggers = {"school","class","teacher"};
		//use for loop to iterate thru array
		if (HansMain.findKeyword(userInput, "curious", 0)>=0)
			return true;
		if (HansMain.findKeyword(userInput, "like", 0)>=0)
			return true;
		if (userInput.substring(userInput.length()-1).equals("?"))
			return true;
		
		return false;
	}

}

