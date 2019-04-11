//Charlie Webb - C1823045

//Useful imports like scanner for reading from file, arraylist for storing data and exceptions for error handling
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.lang.IndexOutOfBoundsException;
import java.util.InputMismatchException;
public class MainProgram {
	public static void main( String[] args ) {
		//In the main method, everything should be looped in a while true loop to keep returning the user to the menu until they
		//Choose to override that with the exitProgram method.
		while(true) {
			//Print menu with choices to user
			System.out.println("\n1-Add a new player\n2-Create a new file\n3-Display all players\n4-Search by team name\n5-Delete a player\n6-Search by specified field\n7-Display a subset of players\n8-Exit");
			Scanner input = new Scanner(System.in);
			//Wrap everything in a try statement that handles InputMismatchError from java.util. This means that
			//if the user inputs anything except an integer it will notify them of the input constraints and restart
			try {
				int in = input.nextInt();
				//Switch according to the input, limits user options to defined options for security.
				switch(in) {
				case 1:
					//Call addPlayer method
					addPlayer();
					break;
				case 2:
					//Call makeNewFile method
					makeNewFile();
					break;
				case 3:
					//Call readFromPlayers method
					readFromPlayers();
					break;
				case 4:
					//Take user input as a string, which will be the search term
					System.out.println("Enter your search term:");
					Scanner searchTerm = new Scanner(System.in);
					String search = searchTerm.next();
					//Call searchTerm method with parameter of the user input search term
					searchTeam(search);
					break;
				case 5:
					//Take user input as integer, which will be the position of the player to delete
					System.out.println("Choose which player to delete (as integer):");
					Scanner delPlayer = new Scanner(System.in);
					int deletePlay = delPlayer.nextInt();
					//Call deletePlayer method with parameter of the user input player to delete
					deletePlayer(deletePlay);
					break;
				case 6:
					//Print new option menu to user, same idea as the main menu
					System.out.println("\n1-Home Stadium Name\n2-Home Stadium Street\n3-Home Stadium Town\n4-Home Stadium Postcode");
					//Catch all input mismatch errors and notify user
					try {
						//Otherwise, take two inputs one as an integer and one as a string
						//Call the searchField method with parameters of the search term and field to search
						Scanner searchFields = new Scanner(System.in);
						int field = searchFields.nextInt();
						System.out.println("Enter your search:");
						String term = searchFields.next();
						searchField(term, field);
						break;
					} catch(InputMismatchException e) {
						System.out.println("Input must be an integer");
						break;
					}
				case 7:
					try {
						//Take input for the start and end values of the subset
						Scanner subsetSearch = new Scanner(System.in);
						System.out.println("Enter what number you want to start at:");
						int begin = subsetSearch.nextInt();
						System.out.println("Enter what number you want to stop at");
						int stop = subsetSearch.nextInt();
						//Call subsetSearch method with parameters of the start and stop values
						subsetSearch(begin, stop);
						break;
					} catch(InputMismatchException e) {
						System.out.println("Input must be an integer");
						break;
					}
				case 8:
					//Call the exitProgram method, which overrides the while(true) statement and exits the program
					exitProgram();
			}

			} catch(InputMismatchException e) {
				//This is the error message for the main menu
				System.out.println("Input must be an integer");
			}
		}

	}
	public static void exitProgram() {
		//As with in RugbyPlayer.java, except this isn't a validation message so it just exits
		System.out.println("Goodbye");
		System.exit(1);
	}

	public static void addPlayer() {
		//The following block of code takes an input for each data member of the RugbyPlayer constructor
		System.out.println("Add a new rugby player");
		Scanner scan = new Scanner(System.in);
		System.out.println("Player Name:");
		String pname = scan.nextLine();
		System.out.println("Player ID");
		String pID = scan.nextLine();
		System.out.println("Tries Scored");
		String tries = scan.nextLine();
		int pTries = Integer.parseInt(tries);
		System.out.println("Team Name");
		String tName = scan.nextLine();
		System.out.println("Team ID");
		String tID = scan.nextLine();
		System.out.println("Home Stadium Name");
		String hStadName = scan.nextLine();
		System.out.println("Home Stadium Street");
		String hStadStreet = scan.nextLine();
		System.out.println("Home Stadium Town");
		String hStadTown = scan.nextLine();
		System.out.println("Home Stadium Postcode");
		String hStadCode = scan.nextLine();
		//Using the input strings, the the code then constructs a new object of type RugbyPlayer, which invokes the validation
		//On each parameter
		RugbyPlayer player = new RugbyPlayer(pname, pID, pTries, tName, tID, hStadName, hStadStreet, hStadTown, hStadCode);
		try {
			//Open "players.txt" with the BufferedWriter object from java.io, which takes a FileWriter object as input, with
			//an extra parameter "true" that switches into append mode
			BufferedWriter out = new BufferedWriter(new FileWriter("players.txt", true));
			//Drop a newline character into the file so that the player gets appended to a new line
			out.newLine();
			//GetAtts is a method in RugbyPlayer that returns the attributes of the object, already formatted for being appended to file
			out.write(player.getAtts());
			//Close the scanner
			out.close();
		} catch(Exception e) {
			//Java requires error handling on all file-handling methods
			e.printStackTrace();
		} finally {
			//Notify user that the player has been added
			System.out.println("Player Added");
		}
		
	}
	public static void makeNewFile() {
		try {
			//createNewFile is a method from the java.io API that returns true if the file doesn't already exist and
			//false if the file does exist. This method creates the new file if one doesnt already exist, otherwise
			//just tells the user that the file already exists.
			File f = new File("players.txt");
			if(f.createNewFile()) {
				System.out.println("File created\n");
			}
			else {
				System.out.print("File already exists\n");
			}
		} catch(Exception e) {
			//Error handling for file handling
			e.printStackTrace();
		}
	}

	public static void searchTeam(String key) {
		try {
			//Initialise boolean to display if there are any matches at all
			boolean found = false;
			Scanner playerSearch = new Scanner( new File("players.txt"));
			//Generate a new arrayList called lines
			ArrayList<String> lines = new ArrayList<String>();
			//Append all the lines from the file to the arraylist
			while(playerSearch.hasNextLine()) {
				lines.add(playerSearch.nextLine());
				}
			//Close the scanner
			playerSearch.close();
			//Iterate through each line, but split the line by occurences of ", ", like a csv file
			//The 4th value (index 3) in that array will be the team of the player
			for(String line: lines) {
				//As it's case sensitive, just check if the team name contains the search term
				if(line.split(", ")[3].contains(key)) {
					//If so, set found to true and output the entire player to the user
					System.out.println(line);
					found = true;
				}
			}
			//If found is false (ie no matches have been found), notify the user
			if(found == false) {
				System.out.println("No matches");
			}
		} catch(Exception e) {
			//Error handling for file handling
			e.printStackTrace();
		}
	}
	public static void searchField(String key, int field) {
		try {
			//increment user input by 4. This is because in the split array (as with searchTeam)
			//the home stadium name and other input fields are the 6th to 9th values, so indexes 5 to 8
			//User will input something in the range 1-4, so increment by 4.
			field += 4;
			//Following code is the same as in searchTeam. Add each line in the file to an arraylist
			boolean found = false;
			Scanner newSearch = new Scanner( new File("players.txt"));
			ArrayList<String> lines = new ArrayList<String>();
			while(newSearch.hasNextLine()) {
				lines.add(newSearch.nextLine());
				}
			newSearch.close();
			//Split each line into its constituent attributes
			for(String line: lines) {
				//Search with the index stored in field, make both sides of the comparison lower case to make it case insensitive
				if(line.split(", ")[field].toLowerCase().contains(key.toLowerCase())) {
					//Only return the 5th to the 8th index because the function is supposed to "find all stadium addresses that..."
					System.out.println(String.join(", ", Arrays.copyOfRange(line.split(", "), 5, 9)));
					found = true;
				}
			}
			//If no matches found, notify user
			if(found == false) {
				System.out.println("No matches");
			}
		} catch(Exception e) {
			//Error handling for file handling
			e.printStackTrace();
		}
	}
	public static void subsetSearch(int start, int end) {
		try {
			//As with searchTeam and searchField, copy the contents of the file to an arraylist
			Scanner subSearch = new Scanner( new File("players.txt"));
			ArrayList<String> lines = new ArrayList<String>();
			while(subSearch.hasNextLine()) {
				lines.add(subSearch.nextLine());
			}
			subSearch.close();
			//With the input parameters, iterate through the index from the "start" index to the "end" index
			try {
				for(int i = start-1; i < end; i++) {
					System.out.println(lines.get(i));
				}
			} catch(IndexOutOfBoundsException e) {
				//If the program returns an IndexOutOfBoundsException then the user has input a number out of range, so notify them
				System.out.println("There aren't that many players");
			}
		} catch(Exception e) {
			//Error handling for file handling
			e.printStackTrace();
		}
	}
	public static void readFromPlayers() {
		System.out.println("Display all players");
		try {
			//Iterate through each line in the file, print it to the console
			Scanner in = new Scanner( new File("players.txt"));
			while(in.hasNextLine()) {
				System.out.println(in.nextLine());
			}
			in.close();
		}
		catch(Exception e) {
			//Error handling for file handling
			System.out.println(e);
		}
	}
	public static void deletePlayer(int position) {
		try {
			//As with searchTeam, searchField and subsetSearch, copy the contents of the file to an arraylist
			Scanner delete = new Scanner( new File("players.txt"));
			ArrayList<String> lines = new ArrayList<String>();
			while(delete.hasNextLine()) {
				lines.add(delete.nextLine());
			}
			delete.close();
			//Store the player's name to echo back to the user as confirmation
			//Remove the player to delete from the arraylist
			String playername = lines.get(position-1).split(", ")[0];
			lines.remove(position-1);
			//To clear the current file, set up a new BufferedWriter object and just write "".
			//Possibly not the most techy solution, but it works
			BufferedWriter clear = new BufferedWriter(new FileWriter("players.txt"));
			clear.write("");
			clear.close();
			//Set up a new BufferedWriter, this time to write the modified arraylist back to the file
			BufferedWriter returnPlayers = new BufferedWriter(new FileWriter("players.txt", true));
			for(String line: lines) {
				//Write each item back to the file
				returnPlayers.write(line);
				//But if the item is the last item in the list, don't add a new line
				if(line != lines.get(lines.size()-1)) {
					//This will prevent random gaps in the file where players have been deleted
					returnPlayers.newLine();
				}
			}
			returnPlayers.close();
			//Echo name to user as confirmation
			System.out.println("Player " + playername + " deleted.");
		} catch(IOException e) {
			//Error handling for file handling
			e.printStackTrace();
		} catch(IndexOutOfBoundsException e) {
			System.out.println("That player doesn't exist");
		}
	}

}