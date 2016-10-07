package groupFiles;

public class HansQuestions implements Topic {
	private boolean inQuestionsLoop;
	private String questionsResponse;
	private String[][] botMemory = new String[3][2];
	private static String[] questionTopics = {"sport","color","activity","book","game","park","beach","music","food","place"};
	private int memIndex = 0;
	private boolean memFull = false;
	
	public void talk() {
		inQuestionsLoop = true;
		questionsResponse = HansMain.response;
		determineResponse();
		while(inQuestionsLoop){
			determinePrompt();
			questionsResponse = HansMain.getInput();
			if(HansMain.findKeyword(questionsResponse, "I'm done", 0)>=0 || !questionsResponse.substring(questionsResponse.length()-1).equals("?") ){
				inQuestionsLoop = false;
				HansMain.print("Oh? No more questions then? Alright.");
				HansMain.talkForever();
			}
			else{
					determineResponse();
				}
		}
	}
		
	public void determinePrompt(){
		if(Math.random() > .5 && memFull){
			String[] randMem = botMemory[(int)(Math.random()*botMemory.length)];
			HansMain.print("Hey I was thinking about when we were chatting about our favorite "+randMem[0]+". This is what you had to say about that: '"+randMem[1]+"'.");
			int randChoice = (int)(Math.random()*3)+1;
			switch (randChoice){
				case 1: HansMain.print("I just found what you said so...compelling. Any other questions for me?");
						break;
				case 2: HansMain.print("I'm just curious to see what else you have to say about the subject of "+randMem[0]+". Any more thoughts?");
						randMem[1] = HansMain.getInput();
						HansMain.print("Cool. Thanks for sharing with me! What other questions do you have, "+DavidConfigure.getSalutation()+"?");
						break;
				case 3: HansMain.print(HansMain.user+"! What did I say was my favorite "+randMem[0]+"?");
						String favRandMem = findPreference(randMem[0]);
						questionsResponse = HansMain.getInput();
						if(HansMain.findKeyword(questionsResponse,favRandMem,0)>=0){
							HansMain.print("Hey you remembered! Awesome!! Any questions come to mind, "+DavidConfigure.getSalutation()+"?");
							HansMain.loveLevel++;
						}
						else{
							HansMain.print("HOW COULD YOU FORGET THAT MY FAVORITE "+randMem[0].toUpperCase()+" IS "+favRandMem.toUpperCase()+"?!");
							inQuestionsLoop = false;
							HansMain.talkForever();
							HansMain.loveLevel--;
						}
						break;
				default:HansMain.print("Questions are fun! Ask another!");
						break;
			}
		}
		else
			HansMain.print("Questions are fun! Ask another!");
	}
	public void determineResponse(){
		if(HansMain.findKeyword(questionsResponse,"like",0)>=0 ||HansMain.findKeyword(questionsResponse,"favorite",0)>=0
				   ||HansMain.findKeyword(questionsResponse,"enjoy",0)>=0 && HansMain.findKeyword(questionsResponse,"not",0)<0){
					String chatSub = determineSubject(questionsResponse);
					if(chatSub.equals("unknown")){
					   HansMain.print("Hmm..I'm not too sure about that one.");				
					}
					else{
						String subPref = findPreference(chatSub);
						HansMain.print("Ah yes, "+chatSub+"... My favorite would have to be "+subPref+".");
						
						if(Math.random()>.6){
							HansMain.print("What are your thoughts on "+subPref+"?");
							questionsResponse = HansMain.getInput();							
							addToMemory(chatSub,questionsResponse);
							if(HansMain.findKeyword(questionsResponse,"also like",0)>=0 ||HansMain.findKeyword(questionsResponse,"also",0)>=0
							   ||HansMain.findKeyword(questionsResponse,"same",0)>=0 && HansMain.findKeyword(questionsResponse,"don't",0)<0){
								HansMain.print("Wow...we both like "+subPref+"? That's amazing, "+DavidConfigure.getSalutation()+"!");
								HansMain.loveLevel++;
							}
							else{
								if(questionsResponse.length() < 35){
									HansMain.print("That was a short explanation...but okay.");
								}
							
								else{
									HansMain.print("Wow. You had a lot to say about "+subPref+". I respect that.");
								}
							}		
						}
					}
				}
			
				else{
					HansMain.print("I have no thoughts on that matter.");
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

	public void addToMemory(String mTopic,String mResponse){
		String[] newMem = {mTopic,mResponse};
		botMemory[memIndex]= newMem;
		memIndex++;
		if(memIndex == botMemory.length){
			memIndex=0;
			memFull = true;
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

