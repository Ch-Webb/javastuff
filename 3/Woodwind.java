//Charlie Webb - C1823045
public class Woodwind extends Instruments {
	//Shared attribute for all 
	double length;
}

class Clarinet extends Woodwind {
	//Constructor
	public Clarinet() {
		name = "Clarinet";
		family = "Reed Instrument";
		length = 0.6;
	}
}

class Flute extends Woodwind {
	public Flute() {
		name = "Flute";
		family = "Flutes";
		length = 0.66;
	}
}