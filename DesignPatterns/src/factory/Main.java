package factory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HumanFactory humanFactory = new HumanFactory();
		
		HumanUnit unit1 = humanFactory.getUnit("knight");
		HumanUnit unit2 = humanFactory.getUnit("peasant");
		HumanUnit unit3 = humanFactory.getUnit("cavalry");
		
	}

}
