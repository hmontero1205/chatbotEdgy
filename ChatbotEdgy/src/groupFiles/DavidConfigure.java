package groupFiles;

import java.util.Objects;

public class DavidConfigure implements Topic {
	
	private boolean inConfigureLoop;
	private String youResponse = HansMain.getInput();
	
	private String[] favColors = {"Red", "Blue", "Green", "Yellow", "Orange", "Purple", "Magenta", "Black", "White", "Teal", "Aquamarine"};
	private String[] favPlaces = {"Beach", "Amusement Park", "Restaurant", "Music Festival"};
	private String[] favActivities = {"Reading", "Sports", "Gaming"};

	private String[] favBooks = {"Harry Potter", "Eragon", "The Dark Tower", "Pendragon"};
	private String[] favSports = {"Soccer", "Football", "Cricket", "Polo", "Baseball", "Basketball", "Volleyball"};
	private String[] favGames = {"Witcher 3", "Dishonored", "Overwatch", "League of Legends", "Wolfenstein", "Counter Strike: Global Offensive"};
	private String[] favParks = {"Coney Island", "Six Flags", "Adventureland"};
	private String[] favBeachActivities = {"Swimming", "Tanning", "Beach Volleyball", "Surfing", "Boating"};
	private String[] favMusic = {"EDM", "Rock", "Metal", "Country", "K-pop", "Pop"};
	private String[] favFoods = {"Pasta", "Meat", "Salad", "Pizza", "Soup"};
	
	private String favColor = findFavItem(favColors);
	private String favPlace = findFavItem(favPlaces);
	private String favActivity = findFavItem(favActivities);
	private String favBook = findFavItem(favBooks);
	private String favGame = findFavItem(favGames);
	private String favBeachActivity = findFavItem(favBeachActivities);
	private String favMusicGenre = findFavMusicGenre();
	private String favMusicMaker = findFavMusicMaker();
	private String favSong = findFavSong();
	private String favSport = findFavItem(favSports);
	private String favPark = findFavItem(favParks);
	private String favFood = findFavItem(favFoods);
	
	private String genderSubject = findGender();
	private String genderChatbot = chooseGender();
	
	public String getFavColor(){
		return "";
	}
	public String getFavGenre(){
		return favMusicGenre;
	}
	public String getFavMusicMaker(){
		return favMusicMaker;
	}
	public String getFavSong(){
		return favSong;
	}
	public String getFavSport(){
		return favSport;
	}
	public String getFavParks(){
		return favPark;
	}
	public String getFavFood(){
		return favFood;
	}
	
	public static boolean findFavThing(String input, String[] array){
		for(int i = 0; i < array.length; i++){
			if(Objects.equals(input, array[i])){
				return true;
			}
		}
		return false;
	}
	
	public static String findFavItem(String[] array) {
		return array[(int) (Math.random() * array.length)]; 		
	}

	public String findFavMusicGenre() {
		String faveMusic = favMusic[(int) (Math.random() * favMusic.length)];
		return faveMusic;
	}

	public String findFavSong() {
		return isSongEqual(favMusicMaker);
	}

	public String findFavMusicMaker() {
		return isMusicEqual(favMusicGenre);
	}

	public String isSongEqual(String musicMaker) {	
		if(Objects.equals(musicMaker, "Swedish House Mafia")){
			return "Don't You Worry Child";
		}
		else if(Objects.equals(musicMaker, "AC/DC")){
			return "Highway to Hell" ;
		}
		else if(Objects.equals(musicMaker, "Metallica")){
			return "Nothing Else Matters";
		}
		else if(Objects.equals(musicMaker, "Carrie Underwood")){
			return "Jesus, Take the Wheel";
		}
		else if(Objects.equals(musicMaker, "BIGBANG")){
			return "BANG BANG BANG";
		}
		else if(Objects.equals(musicMaker, "Rihanna")){
			return "Needed Me";
		}
		else return "";
	}

	public String isMusicEqual(String favoriteMusic){
		if(Objects.equals(favoriteMusic, "EDM")){
			return "Swedish House Mafia";
		}
		else if(Objects.equals(favoriteMusic, "Rock")){
			return "AC/DC" ;
		}
		else if(Objects.equals(favoriteMusic, "Metal")){
			return "Metallica";
		}
		else if(Objects.equals(favoriteMusic, "Country")){
			return "Carrie Underwood";
		}
		else if(Objects.equals(favoriteMusic, "K-pop")){
			return "BIGBANG";
		}
		else if(Objects.equals(favoriteMusic, "Pop")){
			return "Rihanna";
		}
		else return "";
	}
	
	public void talk() {
		inConfigureLoop = true;
		//while()
	}
	
	public String chooseGender() {
		if(HansMain.findKeyword(youResponse, "girl", 0) >= 0){
			return "girl";
		}
		else if(HansMain.findKeyword(youResponse, "boy", 0) >= 0){
			return "boy";
		}
		else if(HansMain.findKeyword(youResponse, "man", 0) >= 0){
			return "boy";
		}
		else if(HansMain.findKeyword(youResponse, "woman", 0) >= 0){
			return "boy";
		}
		else if(HansMain.findKeyword(youResponse, "other", 0) >= 0){
			return "other";
		}
		return "";  
	}

	public String findGender() {
		if(HansMain.findKeyword(youResponse, "girl", 0) >= 0){
			return "girl";
		}
		else if(HansMain.findKeyword(youResponse, "boy", 0) >= 0){
			return "boy";
		}
		else if(HansMain.findKeyword(youResponse, "woman", 0) >= 0){
			return "girl";
		}
		else if(HansMain.findKeyword(youResponse, "man", 0) >= 0){
			return "boy";
		}
		else if(HansMain.findKeyword(youResponse, "other", 0) >= 0){
			return "boy";
		}
		return "";
	}
	
	public String getSalutations(String input){
		String[] maleSalu = {"you handsome devil you, ", "you big strong man~ "};
		String[] femaleSalu = {"you beautiful lady you ", "so beautiful~ "};
		String[] otherSalu = {"you handsomely beautiful partner you ", "you perfect example of genderfluidity you " }; 
		
		if(Objects.equals(genderSubject, "boy")){
			return maleSalu[(int) (Math.random() * maleSalu.length)];
		}
		else if(Objects.equals(genderSubject, "girl")){
			return femaleSalu[(int) (Math.random() * femaleSalu.length)];
		}
		else if(Objects.equals(genderSubject, "other")){
			return otherSalu[(int) (Math.random() * otherSalu.length)];
		}
		else return "";
	}
	
	public boolean isTriggered(String userInput) {
		if(HansMain.findKeyword(userInput, "girl", 0) >= 0){
			return true;
		}
		else if(HansMain.findKeyword(userInput, "boy", 0) >= 0){
			return true;
		}
		else if(HansMain.findKeyword(userInput, "woman", 0) >= 0){
			return true;
		}
		else if(HansMain.findKeyword(userInput, "man", 0) >= 0){
			return true;
		}
		else if(HansMain.findKeyword(userInput, "other", 0) >= 0){
			return true;
		}
		return false;
	}

}
