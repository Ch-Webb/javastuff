//Charlie Webb - C1823045
//Basic type class. extends instruments (inheritance) to inherit the play() method and the name, family attributes
public class Brass extends Instruments {
	//All Brass instruments share a tube length and a bore type
	String bore;
	double tubeLength;
}

//Basic Instrument class.
class Trumpet extends Brass {
	//Define most specific attributes
	String valves;
	//Constructor for Trumpet object
	public Trumpet(){
		//Set name, family from instrument class, bore, tubeLength from Brass class and valves from Trumpet class
		name = "Trumpet";
		family = "Valved";
		valves = "3-4";
		bore = "Cylindrical";
		tubeLength = 1.48;
	}
}

class Tuba extends Brass {
	String valves;
	public Tuba() {
		name = "Tuba";
		family = "Valved";
		valves = "3-6";
		bore = "Conical";
		tubeLength = 5.50;
	}

}