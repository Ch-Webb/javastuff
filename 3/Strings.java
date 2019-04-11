//Charlie Webb - C1823045
//Basic type class
public class Strings extends Instruments {
	//All String instruments have a number of strings
	int numOfStrings;

}

class Violin extends Strings {
	//Violin constructor
	public Violin() {
		//Set top level attributes
		name = "Violin";
		numOfStrings = 4;
		family = "Lute";
	}
} 

class Cello extends Strings {
	public Cello() {
		name = "Cello";
		numOfStrings = 4;
		family = "Lute";
	}
} 