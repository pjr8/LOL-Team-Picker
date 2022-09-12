package me.pjr8;

import java.util.Scanner;

public class GenerationMechanics {
	
	public static void generateTeams() {
		
		// Asks the user for amount of champions to roll per team, games, and if they want to save results to a file.
		int champions = 5;
		int games = 1;
		boolean file = false;
		
		try {
			Scanner questions = new Scanner(System.in);
			System.out.println("How many champions would you like to be rolled for each team? (Cannot be below 0 or above " + ((TeamGenerator.champPool.size()/2)-1) + ")");
			champions = questions.nextInt();
			System.out.println("How many games do you need to be rolled? (For multiple sets going on at a time)");
			games = questions.nextInt();
			System.out.println("Would you like the results to be saved in a file? (y/n)");
			if (questions.next().equals("y")) {
				file = true;
			}
			questions.close();
		} catch (Exception exception) {
			System.out.println("Something went wrong.");
			generateTeams();
		} // Make sure the variables are valid
		int championLimit = TeamGenerator.champPool.size()/2;
		if (!(champions > 0 && champions < (championLimit) && games > 0)) { //this does not work
			System.out.println("Champions cannot be below 0 or above " + (championLimit - 1) + ". Games cannot be below 0.");
			//GenerateTeams();
			return;
		}
		TeamGenerator.generateRandomTeamData(champions, games, file);
	}
}
