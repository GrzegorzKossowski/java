package abstractfactory;

public class FactoryProducer {

	public static AbstractFactory getFactory(String factoryType)
	{
		if (factoryType == "OrcFactory")
		{
			return new OrcFactory();
		} else if (factoryType == "HumanFactory")
		{
			return new HumanFactory();
		} else 
			return null;
		
	}
	
}
