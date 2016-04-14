package adapter;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		UniversalBoat uBoat = new UniversalBoat();
		
		uBoat.attack("ship");
		uBoat.attack("submarine");
		uBoat.attack("aircraft");
		uBoat.attack("ship");

	}

}
