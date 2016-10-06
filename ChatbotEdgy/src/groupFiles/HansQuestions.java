package groupFiles;
//import ChatbotEdgy.HansMain;

public class HansQuestions {
	private boolean inQuestionsLoop;
	private String questionsResponse;
	private boolean askedFollowup = false;
	private String[] favAnswers = String[5];
	private String[] questionTopics = {"sport","color","activity","book","game","park","beach","music","food"};
	
	public void talk() {
		inQuestionsLoop = true;
		while(inQuestionsLoop){
			HansMain.print("Questions are fun! Ask another!");
			questionsResponse = HansMain.getInput();
			if(!askedFollowup && HansMain.findKeyword(questionsResponse, "break", 0)>=0 || !questionsResponse.substring(questionsResponse.length()-1).equals("?") ){
				inQuestionsLoop = false;
				HansMain.talkForever();
			}
			else{
				/*int likeIndex = HansMain.findKeyword(questionsResponse,"like",0);
				if(likeIndex > 0){
					String subjectString = questionsResponse.substring(likeIndex,questionsResponse.length()-1);
					HansMain.print("The subject of your sentence was..."+subjectString);
				}*/
				if(!askedFollowup){
					String chatSub = determineSubject(questionsResponse);
					String subPref = findPreference(chatSub);
					if(HansMain.findKeyword(questionsResponse,"like",0)>=0 ||HansMain.findKeyword(questionsResponse,"favorite",0)>=0
					   ||HansMain.findKeyword(questionsResponse,"enjoy",0)>=0 && HansMain.findKeyword(questionsResponse,"favorite",0)<0){
						if(chatSub.equals("unknown"))
						   HansMain.print("Hmm..I'm not too sure.");
						else{
							HansMain.print("Ah yes, "+chatSub+"... My favorite would have to be "+subPref+". What about you?");
							//asked for user thoughts on subject
							//if same, add lovepoints, add to memory array to follow up on later.
						}
					}
				}
				else{
					HansMain.print("I can't answer that question just yet...");
				}
			}
		}
	}
	
	public static String determineResponse(String r){
		//find subject 
		for(int t=0;t<questionTopics.length;t++){
			if(HansMain.findKeyword(r,questionTopics[t],0)>=0)
				return questionTopics[t];
		}
		return "unknown";
	}
	
	public static String findPreference(String s){
		//find preference based on subject. switch statement
		switch(s){
			case "sport": return DavidConfigure.getFavSport();
			case "color": return DavidConfigure.getFavColor();
			case "activity": return DavidConfigure.getFavActivity();
				//more to do...
		}
	}

	

	public boolean isTriggered(String userInput) {
		if (HansMain.findKeyword(userInput, "curious", 0)>=0)
			return true;
		if (HansMain.findKeyword(userInput, "like", 0)>=0)
			return true;
		if (userInput.substring(userInput.length()-1).equals("?"))
			return true;
		return false;
	}
	
}

