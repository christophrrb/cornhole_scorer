import java.util.Scanner;

public class CLI {
	private static Scanner userInput = new Scanner(System.in);

	//Array of Both Teams
	private static Team[] teams = {new Team(), new Team()};
	//The score needed to win a match
	private static int winningScore;
	//The team that won the game
	private static Team winningTeam = null;

	public static void main(String[] args) {
		System.out.println("Welcome to Cornhole!");
		
		//Pause for a second for dramatic effect
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("There was an error.");
		}

		//Ask teams for their name
		System.out.print("Team 1, please enter your name: ");
		teams[0].setName(userInput.nextLine());

		System.out.print("Great! Team 2, please enter your name: ");
		teams[1].setName(userInput.nextLine());
		System.out.println("\nExcellent!");
		
		//Pause
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("There was an error.");
		}

		//Short explanation of the program and input of the winning score from user
		System.out.println("\nEach team will enter their score for the round, and this program will calculate each team's overall score.");
		System.out.println("First, what's the winning score?");
		System.out.print("Winning Score: ");
		winningScore = validInt();
		System.out.println("\nAlright! Let's get started.");

		//Start scoring!
		gameplay();
	}

	//This function loops until a team has won a game.
	private static void gameplay() {
		do {
			//Get the round scores for both teams
			validRoundScoreNumber(teams[0]);
			validRoundScoreNumber(teams[1]);

			//Set the overall score for both teams.
			setScores();

			//Output each team's overall score.
			System.out.println("\n" + teams[0].getName() + "'s Score: " + teams[0].getScore() + " Points");
			System.out.println(teams[1].getName() + "'s Score: " + teams[1].getScore() + " Points");
		} while ((winningTeam = winner()) == null); //As long as there is no winner, keep the loop going.

		//Say the winner
		System.out.println(winningTeam.getName() + " won!");

		//Reset the teams' overall scores and call this function again if the user wants to play again.
		if (playAgain()) {
			for (Team team : teams)
				team.setScore(0);

			gameplay();
		}
	}

	//Checks to make sure an integer was input from the user.
	private static int validInt() {
		try {
			return Integer.parseInt(userInput.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Please input a valid number.");
			validInt();
		}

		return 0; //So Java won't say that there's a path the program could take without returning an int.
	}

	//Similar to validInt, except it's centered around a correct number being put in for each round.
	private static void validRoundScoreNumber(Team team) {
		//Let someone type in their round score.
		System.out.print("\n" + team.getName() + "'s Round Score: ");

		//Check to see if it's an integer.
		try {
			team.setRoundScore(Integer.parseInt(userInput.nextLine()));
		} catch (NumberFormatException e) {
			System.out.println("Please input a valid number.");
			validRoundScoreNumber(team);
		}
	}

	//Returns a Team variable if a team has met or surpassed the winning score.
	private static Team winner() {
		if (teams[0].getScore() >= winningScore) {
			teams[0].addWinningGame();
			return teams[0];
		} else if (teams[1].getScore() >= winningScore) {
			teams[1].addWinningGame();
			return teams[1];
		} else {
			return null;
		}
	}

	//Original methodology to calculate scores.
	private static void setScoresOld() {
		if (teams[0].getRoundScore() > teams[1].getRoundScore()) {
			teams[0].setScore(teams[0].getScore() + (teams[0].getRoundScore() - teams[1].getRoundScore()));
		} else if (teams[1].getRoundScore() > teams[0].getRoundScore()) {
			teams[1].setScore(teams[1].getScore() + (teams[1].getRoundScore() - teams[0].getRoundScore()));
		}
	}
	
	//Set overall scores for the teams. S/O Owen Lerman for the absolute value advice.
	private static void setScores() {
		//Subtract teams[0] round score from teams[1]
		int addScore = teams[0].getRoundScore() - teams[1].getRoundScore();
		
		//If the score is positive, add the points to teams[0]'s overall score. If it's negative, add the absolute value of the points ot teams[1]'s overall score.
		if (addScore > 0) {
			teams[0].addToScore(addScore);
		} else {
			teams[1].addToScore(Math.abs(addScore));
		}
	}

	//Find out of the user wants to play again
	private static boolean playAgain() {
		System.out.println("\nWould you like to play again? Yes or No?");
		boolean response = userInput.nextLine().toLowerCase().equals("yes");
		return response;
	}
}
