package groupFiles;

//import ChatbotEdgy.HansMain;

public class HansQuestions {
	private boolean inQuestionsLoop;
	private String questionsResponse;
	
	public void talk() {
		inQuestionsLoop = true;
		while(inQuestionsLoop){
			HansMain.print("Questions...");
		}

	}

	public boolean isTriggered(String userInput) {
		//String[] triggers = {"school","class","teacher"};
		//use for loop to iterate thru array
		if (HansMain.findKeyword(userInput, "curious", 0)>=0)
			return true;
		if (HansMain.findKeyword(userInput, "?", 0)>=0)
			return true;
		if (HansMain.findKeyword(userInput, "question", 0)>=0)
			return true;
		
		return false;
	}

}

