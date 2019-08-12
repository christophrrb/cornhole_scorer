import java.util.Scanner;

public class CLI {
	private static Scanner userInput = new Scanner(System.in);

	//Teams
	private static Team[] teams = {new Team(), new Team()};
	private static int winningScore;
	private static int teamIterator = 0;
	private static Team winningTeam = null;

	public static void main(String[] args) {
		System.out.println("Welcome to Cornhole!");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("There was an error.");
		}

		System.out.print("Team 1, please enter your name: ");
		teams[0].setName(userInput.nextLine());

		System.out.print("Great! Team 2, please enter your name: ");
		teams[1].setName(userInput.nextLine());
		System.out.println("\nExcellent!");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			System.out.println("There was an error.");
		}

		System.out.println("\nEach team will enter their score for the round, and this program will calculate each team's overall score.");
		System.out.println("First, what's the winning score?");
		System.out.print("Winning Score: ");
		winningScore = validInt();
		System.out.println("\nAlright! Let's get started.");

		gameplay();
	}

	private static void gameplay() {
		do {
			
			validRoundScoreNumber(teams[0]);
			
			validRoundScoreNumber(teams[1]);

			setScores();

			System.out.println("\n" + teams[0].getName() + "'s Score: " + teams[0].getScore() + " Points");
			System.out.println(teams[1].getName() + "'s Score: " + teams[1].getScore() + " Points");
		} while ((winningTeam = winner()) == null);

		System.out.println(winningTeam.getName() + " won!");

		if (playAgain()) {
			for (Team team : teams)
				team.setScore(0);

			gameplay();
		}
	}

	private static int validInt() {
		try {
			return Integer.parseInt(userInput.nextLine());
		} catch (NumberFormatException e) {
			System.out.println("Please input a valid number.");
			validInt();
		}

		return 0;
	}

	private static void validRoundScoreNumber(Team team) {
		System.out.print("\n" + team.getName() + "'s Round Score: ");

		try {
			team.setRoundScore(Integer.parseInt(userInput.nextLine()));
		} catch (NumberFormatException e) {
			System.out.println("Please input a valid number.");
			validRoundScoreNumber(team);
		}
	}

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

	private static void setScores() {
		if (teams[0].getRoundScore() > teams[1].getRoundScore()) {
			teams[0].setScore(teams[0].getScore() + (teams[0].getRoundScore() - teams[1].getRoundScore()));
		} else if (teams[1].getRoundScore() > teams[0].getRoundScore()) {
			teams[1].setScore(teams[1].getScore() + (teams[1].getRoundScore() - teams[0].getRoundScore()));
		}
	}

	private static boolean playAgain() {
		System.out.println("\nWould you like to play again? Yes or No?");
		boolean response = userInput.nextLine().toLowerCase().equals("yes");
		return response;
	}
}