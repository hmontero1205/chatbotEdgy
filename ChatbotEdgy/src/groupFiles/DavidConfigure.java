package groupFiles;

public class DavidConfigure implements Topic {
	private String youResponse;
	private int questionCount;
	
	private boolean inPlaceLoop;
	private boolean inBeachLoop;
	private boolean inGameLoop;
	private boolean inBookLoop;
	private boolean inSportLoop;
	private boolean inColorLoop;
	private boolean inLoop;
	
	public String[] favColor = {};
	public String[] favPlace = {};
	public String[] favActivity = {};
	public String[] favBook = {};
	public String[] favSport = {};
	public String[] favGame = {};
	public String[] favRide = {};
	public String[] favBeachActivity = {};
	

	@Override
	public void talk() {
		// TODO Auto-generated method stub
//hehe xd
	}

	@Override
	public boolean isTriggered(String userInput) {
		if(HansMain.findKeyword(youResponse, "break up", 0) >= 0){
			return true;
		}
		if(HansMain.findKeyword(youResponse, "seperate ways", 0) >= 0){
			return true;
		}
		return false;
	}

}
