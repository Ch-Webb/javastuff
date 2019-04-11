//Charlie Webb - C1823045
//Basic type class
public class Percussion extends Instruments {
	//Couldn't find any shared attributes for all percussion instruments
}

class Drum extends Percussion {
	double width;
	//All drums have a width, so let the constructor take a width parameter to control the size of the drum
	public Drum(double width) { 
		name = "Drum";
		family = "Idiophone";
		width = this.width;
	}

}

class Triangle extends Percussion {
	public Triangle() {
		name = "Triangle";
		family = "Idiophone";
	}

}