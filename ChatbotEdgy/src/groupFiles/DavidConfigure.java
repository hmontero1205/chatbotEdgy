package groupFiles;

import java.util.Objects;

public class DavidConfigure implements Topic {
	
	private boolean inConfigureLoop;
	String response;
	private static String[] salutations = new String[2];
	
	private String[] boys = {"male", "boy", "man","guy","dude"};
	private String[] girls = {"female", "girl", "woman","dudette","gal"};
	private static String[] favColors = {"red", "blue", "green", "yellow", "orange", "purple", "magenta", "black", "white", "teal", "aquamarine"};
	private static String[] favPlaces = {"beach", "amusement Park", "restaurant", "music festival"};
	private static String[] favActivities = {"reading", "sports", "gaming"};

	private static String[] favBooks = {"Harry Potter", "Eragon", "The Dark Tower", "Pendragon"};
	private static String[] favSports = {"Soccer", "Football", "Cricket", "Polo", "Baseball", "Basketball", "Volleyball"};
	private static String[] favGames = {"Witcher 3", "Dishonored", "Overwatch", "League of Legends", "Wolfenstein", "Counter Strike: Global Offensive"};
	private static String[] favParks = {"Coney Island", "Six Flags", "Adventureland"};
	private static String[] favBeachActivities = {"swimming", "tanning", "beach volleyball", "surfing", "boating"};
	private static String[] favMusic = {"EDM", "Rock", "Metal", "Country", "K-pop", "Pop"};
	private static String[] favFoods = {"pasta", "meat", "salad", "pizza", "soup"};
	
	private static String favColor = findFavItem(favColors);
	private static String favPlace = findFavItem(favPlaces);
	private static String favActivity = findFavItem(favActivities);
	private static String favBook = findFavItem(favBooks);
	private static String favGame = findFavItem(favGames);
	private static String favBeachActivity = findFavItem(favBeachActivities);
	private static String favMusicGenre = findFavMusicGenre();
	private static String favMusicMaker = findFavMusicMaker();
	private static String favSong = findFavSong();
	private static String favSport = findFavItem(favSports);
	private static String favPark = findFavItem(favParks);
	private static String favFood = findFavItem(favFoods);
	
	public static String getSalutation(){
		return salutations[(int)(Math.random()*2)];
	}

	
	public static String getFavColor(){
		return favColor;
	}
	public static String getFavGenre(){
		return favMusicGenre;
	}
	public static String getFavMusicMaker(){
		return favMusicMaker;
	}
	public static String getFavSong(){
		return favSong;
	}
	public static String getFavSport(){
		return favSport;
	}
	public static String getFavParks(){
		return favPark;
	}
	public static String getFavFood(){
		return favFood;
	}
	public static String getFavActivity(){
		return favActivity;
	}
	public static String getFavBook(){
		return favBook;
	}
	public static String getFavGame(){
		return favGame;
	}
	public static String getFavPark(){
		return favPark;
	}
	public static String getFavBeach(){
		return favBeachActivity;
	}
	public static String getFavPlace(){
		return favPlace;
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

	public static String findFavMusicGenre() {
		String faveMusic = favMusic[(int) (Math.random() * favMusic.length)];
		return faveMusic;
	}

	public static String findFavSong() {
		return isSongEqual(favMusicMaker);
	}

	public static String findFavMusicMaker() {
		return isMusicEqual(favMusicGenre);
	}

	public static String isSongEqual(String musicMaker) {	
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

	public static String isMusicEqual(String favoriteMusic){
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
		while(inConfigureLoop){
			HansMain.print("What gender are you?");
			response = HansMain.getInput();
			if(checkIfContains(response, boys)){
				HansMain.print("Ohhhh a big strong man to sweep me off my feet!");
				salutations[0] = "you handsome devil you~";
				salutations[1] = "you big strong man~";
			}
			else if(checkIfContains(response, girls)){
				HansMain.print("I'm a girl myself but... sure why not try new things.");
				salutations[0] = "you beautiful lady you~";
				salutations[1] = "gorgeous~";
			}
			else{
				HansMain.print("Ok, ok I GET IT. It's 2016. Who needs genders!!");
				salutations[0] = "you beautiful partner you~";
				salutations[1] = "you perfect example of genderfluidity you~";
			}
			inConfigureLoop = false;
		}
		HansMain.talkForever();
	}
	
	public static boolean checkIfContains(String str, String[] arr){
		for (int i = 0; i<arr.length; i++){
			if (HansMain.findKeyword(str,arr[i], 0)>=0){
				return true;
			}
		}
		return false;
	}
	
	public boolean isTriggered(String userInput){
		return true;
	}
	
}
