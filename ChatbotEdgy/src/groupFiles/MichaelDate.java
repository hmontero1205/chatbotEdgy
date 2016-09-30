package groupFiles;

public class MichaelDate implements Topic {
	
	private boolean inDateLoop;
	private String dateResponse;
	@Override
	public void talk() {
		// TODO Auto-generated method stub
		inDateLoop = true;
		while(inDateLoop){
			HansMain.print("Testing. Let's on a date.");
		}
		
	}

	@Override
	public boolean isTriggered(String userInput) {
		String[] triggers ={"date","go out","chill","hang out"};
		for (int i = 0; i<triggers.length-1; i++){
			if (HansMain.findKeyword(userInput, triggers[i] , 0) >= 0){
				return true;
			}
		}	
		return false;
	}
	
	
}

