package abstractfactory;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		
		AbstractFactory factory;
		
		factory = FactoryProducer.getFactory("HumanFactory");
		factory.getHuman("peasant");
		
		factory = FactoryProducer.getFactory("OrcFactory");
		factory.getOrc("cavalry");
		factory.getHuman("peasant");	//returns null
		
	}

}
