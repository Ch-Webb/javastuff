//Charlie Webb - C1823045

//Set up rugby player object
public class RugbyPlayer {
	//Set up data members for rugby player object
	String playerName;
	String playerID;
	int tries;
	String teamName;
	String teamID;
	String stadName;
	String stadStreet;
	String stadTown;
	String stadCode;

	//Constructor for rugbyplayer - needs to take every single data member
	public RugbyPlayer(String playerName, String playerID, int tries, String teamName, String teamID, String stadName, String stadStreet, String stadTown, String stadCode) {
		//Following if statements compare each argument against a regex that matches the defined data constraints
		//If any of the input data is wrong, the object rejects the data using the exitProgram method
		//Playername regex searches for two token groups (words), containing all lowercase and uppercase letters and characters ' and -
		//for names like O'Connell or Wyn-Jones
		if (playerName.matches("^([a-zA-Z-']+) ([a-zA-Z-']+)$")) {
			this.playerName = playerName;
		}
		else {
			exitProgram("Bad player name");
		}
		//As an example the following regex tests for the letters RFU followed by 5 digits in the range 0-9
		//It is case sensitive.
		if (playerID.matches("^(RFU)([0-9]{5})$")) {
			this.playerID = playerID;
		}
		else {
			exitProgram("Bad player ID");
		}
		//This is the only statement that doesnt use a regex - tries is an int input, so it just needs to be checked
		//to see if it is a valid number (0 or more)
		if (tries >= 0) {
			this.tries = tries;
		}
		else {
			exitProgram("Bad player tries");
		}
		if (teamName.matches("^([a-zA-Z ]+)$")) {
			this.teamName = teamName;
		}
		else {
			exitProgram("Bad team name");
		}
		if (teamID.matches("^([A-Z]{3})([0-9]{4})$")) {
			this.teamID = teamID;
		}
		else {
			exitProgram("Bad team ID");
		}
		if (stadName.matches("^([a-zA-Z ]+)$")) {
			this.stadName = stadName;
		}
		else {
			exitProgram("Bad stadium name");
		}
		if (stadStreet.matches("^([a-zA-Z0-9 ]+)$")) {
			this.stadStreet = stadStreet;
		}
		else {
			exitProgram("Bad stadium street");
		}
		if (stadTown.matches("^([a-zA-Z ]+)$")) {
			this.stadTown = stadTown;
		}
		else {
			exitProgram("Bad stadium town");
		}
		if (stadCode.matches("^([A-Z]{1})([0-9]{1})([A-Z]{3})$")) {
			this.stadCode = stadCode;
		}
		else {
			exitProgram("Bad stadium postcode");
		}
	}
	public String getAtts() {
		//getAtts meaning Get Attributes is a get method to return all data members formatted for writing to file
		return playerName+", "+playerID+", "+Integer.toString(tries)+", "+teamName+ ", "+teamID+", "+stadName+", "+stadStreet+", "+stadTown+", "+stadCode;
	}

	public void exitProgram(String issue) {
		//Print source of issue to user and then exit program
		System.out.println(issue);
		System.exit(1);
	}

}