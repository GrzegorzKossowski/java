package singleton;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HQBase oneBase1 = HQBase.getHQBase();
		HQBase oneBase2 = HQBase.getHQBase();
		
		oneBase2.printStatus();
		
	}

}
