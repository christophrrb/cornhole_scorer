public class Team {
	private String name;
	private int roundScore = 0;
	private int score = 0;
	private int gamesWon = 0;

	public Team() {}

	public Team(String name) {
		this.name = name;
	}

	//Getter and setter for name
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	//Getter and setter for roundScore
	public void setRoundScore(int roundScore) {
		this.roundScore = roundScore;
	}

	public int getRoundScore() {
		return roundScore;
	}

	//Getter and setter for Score
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addToScore(int score) {
		this.score += score;
	}

	public int getScore() {
		return score;
	}

	//Getter and setter for gamesWon
	public void setGamesWon(int number) {
		this.gamesWon = number;
	}

	public int getGamesWon() {
		return gamesWon;
	}

	//Add a winning game to the total. Returns the number of games won.
	public int addWinningGame() {
		gamesWon++;
		return gamesWon;
	}
}
