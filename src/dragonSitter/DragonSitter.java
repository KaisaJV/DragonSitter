package dragonSitter;

import java.util.Scanner;

public class DragonSitter {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); // sets up the scanner tool
		String dragonname = ""; // empty string ready to hold the dragon's inputed name

		System.out.println("Welcome, new dragonsitter!");
		// following code ensures dragon gets a name that doesn't deviate from requirements
		while (dragonname.isBlank() || dragonname.contains(" ") || !dragonname.matches("[a-zA-Z]+")) { //checks if name is empty or contains spaces or non-letters
			System.out.println("What would you like to name your baby dragon?");
			dragonname = sc.nextLine().trim(); //trim removes extra spaces
			if (dragonname.isBlank() || dragonname.contains(" ") || !dragonname.matches("[a-zA-Z]+")) { //checks if name is blank or contains spaces or non-letters
				System.out.println("Please give it a one-word name.");
			} // end of if statement
		} // end of while statement
		dragonname = dragonname.substring(0, 1).toUpperCase() + dragonname.substring(1).toLowerCase(); //this ensures name starts capitalized and rest lower case
		System.out.println("Great! Your dragon, " + dragonname + ", chirps excitedly and flaps its little wings.");

		System.out.println(dragonname + " stares up at you eagerly. What would you like to do first with " + dragonname + "?");
		
		String interaction = ""; //declares interaction as an empty value
		boolean petUsed = false, feedUsed = false, playUsed = false, bathUsed = false; //these tell the while loop when to end

		while (!interaction.toLowerCase().contains("bed") || !(petUsed && feedUsed && playUsed && bathUsed)) { //while loop until bed is inputed and the boolean values are all true
			if (!petUsed) {
				System.out.println("Pet");
			}
			if (!feedUsed) {
				System.out.println("Feed");
			}
			if (!playUsed) {
				System.out.println("Play");
			}
			if (!bathUsed) {
				System.out.println("Bath");
			}
			if (petUsed && feedUsed && playUsed && bathUsed) { //triggers when boolean inputs are all true
				System.out.println(
						dragonname + " finally begins yawning, all worn out! Tell " + dragonname + " to go to BED.");
			}

			interaction = sc.nextLine().trim(); // waits for interaction input and trims empty spaces

			if (interaction.toLowerCase().contains("pet")) { //must contain any variation of pet, allows for other words to be included
				System.out.println("You scratch " + dragonname + " on the head. " + dragonname + " purrs.");
				petUsed = true; //sets boolean input to true and removes pet from list of options
			} else if (interaction.toLowerCase().contains("feed")) {
				System.out.println(dragonname + " gobbles up the food in your hands and lets out a little burp.");
				feedUsed = true;
			} else if (interaction.toLowerCase().contains("play")) {
				System.out.println("You toss a ball for " + dragonname + ", who swoops around, trying to catch it in the air.");
				playUsed = true;
			} else if (interaction.toLowerCase().contains("bath")) {
				System.out.println("Stinky little dragon! You give " + dragonname + " a hot bath. Its scales now shine brightly.");
				bathUsed = true;
			} else if (interaction.toLowerCase().contains("bed") && !(petUsed && feedUsed && playUsed && bathUsed)) { //if bed is used when any of the boolean is still false
				System.out.println(dragonname + " wiggles and flaps its wings, much too excited to go to bed!");
			} else if (interaction.toLowerCase().contains("bed") && (petUsed && feedUsed && playUsed && bathUsed)) { //if bed is used when all boolean are true
				System.out.println(dragonname + " curls up in its bed and falls asleep, a happy little dragon!");
			} else {
				System.out.println(dragonname + " looks up at you and gives a curious snort, producing a puff of smoke."); //if any non-interaction input is given
			} //end of if statement
		} //end of while loop
		
		System.out.println("Thanks for taking care of " + dragonname + "!");
		
		

	}// end of main

}// end of class
