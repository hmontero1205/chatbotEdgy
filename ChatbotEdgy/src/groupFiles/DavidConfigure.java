package groupFiles;

import java.util.Objects;

public class DavidConfigure implements Topic {

	private String youResponse;
	
	public String[] favColors = {"Red", "Blue", "Green", "Yellow", "Orange", "Purple", "Magenta", "Black", "White", "Teal", "Aquamarine"};
	public String[] favPlaces = {"Beach", "Amusement Park", "Restaurant", "Music Festival"};
	public String[] favActivities = {"Reading", "Sports", "Gaming"};

	public String[] favBooks = {"Harry Potter", "Eragon", "The Dark Tower", "Pendragon"};
	public String[] favSports = {"Soccer", "Football", "Cricket", "Polo", "Baseball", "Basketball", "Volleyball"};
	public String[] favGames = {"Witcher 3", "Dishonored", "Overwatch", "League of Legends", "Wolfenstein", "Counter Strike: Global Offensive"};
	public String[] favParks = {"Coney Island", "Six Flags", "Adventureland"};
	public String[] favBeachActivities = {"Swimming", "Tanning", "Beach Volleyball", "Surfing", "Boating"};
	public String[] favMusic = {"EDM", "Rock", "Metal", "Country", "K-pop", "Pop"};
	public String[] favFoods = {"Pasta", "Meat", "Salad", "Pizza", "Soup"};
	
	public int colorIndex = (int) (Math.random() * favColors.length);
	public int placeIndex = (int) (Math.random() * favPlaces.length);
	public int activityIndex = (int) (Math.random() * favActivities.length);
	
	public String favColor = favColors[colorIndex];
	public String favPlace = favPlaces[placeIndex];
	public String favActivity = favActivities[activityIndex];
	
	public String favBeachActivity = findFavBeachActivity();
	public String favPark = findFavParks();
	public String favFood = findFavFoods();
	public String favMusicGenre = findFavMusicGenre();
	public String favMusicMaker = findFavMusicMaker();
	public String favSong = findFavSong();
	public String favBook = findFavBook();
	public String favGame = findFavGame();
	public String favSport = findFavSport();
	
	private String findFavBook() {
		String favBook = favBooks[(int) (Math.random() * favBooks.length)]; 		
		return favBook;
	}

	private String findFavSport() {
		String favSport = favSports[(int) (Math.random() * favSports.length)];
		return favSport;
	}

	private String findFavGame() {
		String favGame = favGames[(int) (Math.random() * favGames.length)];
		return favGame;
	}

	private String findFavSong() {
		return isSongEqual(favMusicMaker);
	}

	private String isSongEqual(String musicMaker) {	
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

	private String findFavMusicMaker() {
		return isMusicEqual(favMusicGenre);
	}

	private String isMusicEqual(String favoriteMusic){
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
	
	private String findFavBeachActivity() {
		String favBeachActivity = favBeachActivities[(int) (Math.random() * favParks.length)];
		return favBeachActivity;
	}
	private String findFavMusicGenre() {
		// TODO Auto-generated method stub
		String faveMusic = favMusic[(int) (Math.random() * favMusic.length)];
		return faveMusic;
	}

	private String findFavFoods() {
		// TODO Auto-generated method stub
		String favFood = favFoods[(int) (Math.random() * favFoods.length)];
		return favFood;
	}

	private String findFavParks() {
		// TODO Auto-generated method stub
		String favPark = favParks[(int) (Math.random() * favParks.length)];
		return favPark;
	}

	@Override
	public void talk() {
		System.out.println("Hello are you my date?");
	}

	@Override
	public boolean isTriggered(String userInput) {
		if(HansMain.findKeyword(userInput, "start simulation", 0) >= 0){
			return true;
		}
		return false;
	}

}
