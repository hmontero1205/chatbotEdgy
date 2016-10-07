package groupFiles;
//import ChatbotEdgy.HansMain;

public class HansQuestions {
	private boolean inQuestionsLoop;
	private String questionsResponse;
	//private boolean askedFollowup = false;
	private String[][] favAnswers = new String[5][2];
	private static String[] questionTopics = {"sport","color","activity","book","game","park","beach","music","food","place"};
	
	public void talk() {
		inQuestionsLoop = true;
		while(inQuestionsLoop){
			HansMain.print("Questions are fun! Ask another!");
			questionsResponse = HansMain.getInput();
			if(HansMain.findKeyword(questionsResponse, "break", 0)>=0 || !questionsResponse.substring(questionsResponse.length()-1).equals("?") ){
				inQuestionsLoop = false;
				HansMain.talkForever();
			}
			else{
					if(HansMain.findKeyword(questionsResponse,"like",0)>=0 ||HansMain.findKeyword(questionsResponse,"favorite",0)>=0
					   ||HansMain.findKeyword(questionsResponse,"enjoy",0)>=0 && HansMain.findKeyword(questionsResponse,"not",0)<0){
						String chatSub = determineSubject(questionsResponse);
						if(chatSub.equals("unknown")){
						   HansMain.print("Hmm..I'm not too sure about that one.");				
						}
						else{
							String subPref = findPreference(chatSub);
							HansMain.print("Ah yes, "+chatSub+"... My favorite would have to be "+subPref+".");
							
							if(Math.random()>.7){
								HansMain.print("What are your thoughts on"+subPref+"?");
								questionsResponse = HansMain.getInput();
								//favAnswers.push
								if(questionsResponse.length() < 45)
									HansMain.print("Interesting...");
								else
									HansMain.print("Wow. You had a lot to say about "+subPref+". I respect that.");
								if(HansMain.findKeyword(questionsResponse,"also like",0)>=0 ||HansMain.findKeyword(questionsResponse,"also enjoy",0)>=0
								   ||HansMain.findKeyword(questionsResponse,"same",0)>=0 && HansMain.findKeyword(questionsResponse,"don't",0)<0){
									//lovePoints++;
								}
								
							}
						}
					}
				
					else{
						HansMain.print("I have no thoughts on that matter.");
					}
				}
		}
	}
		

	public static String determineSubject(String r){
		for(int t=0;t<questionTopics.length;t++){
			if(HansMain.findKeyword(r,questionTopics[t],0)>=0)
				return questionTopics[t];
		}
		return "unknown";
	}
	
	public String findPreference(String s){
		switch(s){
			case "sport": return DavidConfigure.getFavSport(); 
			case "color": return DavidConfigure.getFavColor();
			case "activity": return DavidConfigure.getFavActivity();
			case "book": return DavidConfigure.getFavBook();
			case "game": return DavidConfigure.getFavGame();
			case "park": return DavidConfigure.getFavPark();
			case "beach": return DavidConfigure.getFavBeach();
			case "music": return DavidConfigure.getFavGenre();
			case "food": return DavidConfigure.getFavFood();	
			case "place": return DavidConfigure.getFavPlace();
			default: return "";
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

