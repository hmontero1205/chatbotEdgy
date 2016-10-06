package groupFiles;
//import ChatbotEdgy.HansMain;

public class HansQuestions {
	private boolean inQuestionsLoop;
	private String questionsResponse;
	private boolean askedFollowup = false;
	//private String[] favAnswers = String[5];
	private static String[] questionTopics = {"sport","color","activity","book","game","park","beach","music","food"};
	
	public void talk() {
		inQuestionsLoop = true;
		//HansMain.print(HansMain.response);
		while(inQuestionsLoop){
			HansMain.print("Questions are fun! Ask another!");
			questionsResponse = HansMain.getInput();
			if(!askedFollowup && HansMain.findKeyword(questionsResponse, "break", 0)>=0 || !questionsResponse.substring(questionsResponse.length()-1).equals("?") ){
				inQuestionsLoop = false;
				HansMain.talkForever();
			}
			else{
				if(!askedFollowup){
					String chatSub = determineSubject(questionsResponse, questionTopics);
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
	

	public String determineSubject(String r, String[] subs){
		//find subject 
		for(int t=0;t<subs.length;t++){
			if(HansMain.findKeyword(r,subs[t],0)>=0)
				return subs[t];
		}
		return "unknown";
	}
	
	public String findPreference(String s){
		if(s.equals("sport"))
			return DavidConfigure.getFavSport();
		return"";
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

