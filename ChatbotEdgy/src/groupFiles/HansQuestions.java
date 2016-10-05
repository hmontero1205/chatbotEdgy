package groupFiles;
//import ChatbotEdgy.HansMain;

public class HansQuestions {
	private boolean inQuestionsLoop;
	private String questionsResponse;
	private boolean askedFollowup = false;
	
	public void talk() {
		inQuestionsLoop = true;
		while(inQuestionsLoop){
			HansMain.print("Questions are fun! Ask another!");
			questionsResponse = HansMain.getInput();
			if(askedFollowup && HansMain.findKeyword(questionsResponse, "break", 0)>=0 || !questionsResponse.substring(questionsResponse.length()-1).equals("?") ){
				inQuestionsLoop = false;
				HansMain.talkForever();
			}
			else{
				//HansMain.print("I have no answer to that question yet!");
				int likeIndex = HansMain.findKeyword(questionsResponse,"like",0);
				if(likeIndex > 0){
					String subjectString = questionsReponse.substring(likeIndex,questionsReponse.length()-1);
					HansMain.print("The subject of your sentence was..."+subjectString);
				}
				else
					HansMain.print("I can't answer that question just yet...");
			}
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

