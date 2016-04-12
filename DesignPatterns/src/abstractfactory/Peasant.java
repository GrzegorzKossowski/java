package abstractfactory;

public class Peasant implements HumanUnit {

	public Peasant()
	{
		createUnit();
	}
	
	public void createUnit()
	{
		System.out.println("Peasant, all day working...");
	}
	
}
