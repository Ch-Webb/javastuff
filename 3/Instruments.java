//Charlie Webb - C1823045
//Master class - Instruments. All further classes will inherit from this class
public class Instruments {
	//All instruments have a name, all instruments belong to a classification group
	String name;
	String family;

	//Method to "play" the instrument
	public void play() {
		System.out.println("Playing " + this.name);
	}
}