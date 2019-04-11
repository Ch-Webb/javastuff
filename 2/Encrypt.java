//Charlie Webb - 1823045
import java.io.*;
import java.lang.*;
public class Encrypt {
	public static void main( String[] args ) {
		if (args.length != 1) {
			System.err.println("One argument expected");
			System.exit(1);	
		}
		else {
			//The following read code is adapted from the 3rd Lab Session of the CM1210 Module.
			try {
				/*Create new object of type ObjectInputStream, taking input from a FileInputStream objec with
				the first console argument as an argument. This argument will be the file to read */
            	ObjectInputStream in = new ObjectInputStream( new FileInputStream(args[0]) );
            	//Convert read bytes to string. Object only needs to be string because it'll be split into a char array
            	String output = (String)in.readObject();
            	//Past this point, code is of my own design
            	//Start by splitting the entire read string into an array of type char, so that each char can be worked on numerically
            	char[] split = output.toCharArray();

				//I had to use a for loop instead of a for each loop because I need to access values in split by index eg. split[i]
				//For each doesnt solve the problem numerically, whereas a for loop does.
            	for(int i = 0; i < split.length; i++) {
                    //If the character is lowercase, convert the character to int, which will give its ascii value
            		if (Character.isLowerCase(split[i])) {
            			int num = (int) split[i];
                        //If the number is 97 (the ascii code for "a"), wrap it back around to the ascii code for "z"
            			if (num == 97) {
            				num = 122;
            			}
                        //Otherwise, decrement the ascii code of the character
            			else {
            				num -= 1;
            			}
                        //Convert ascii code back to a character and reset it in split
            			split[i] = (char) num;

            		}
            	}
                //Print the contents of split to the user
            	System.out.println(split);
        	}
        	// Catch all errors, print
        	catch (Exception e) {
            System.err.println(e);		
			}
		

		}


	}	
}