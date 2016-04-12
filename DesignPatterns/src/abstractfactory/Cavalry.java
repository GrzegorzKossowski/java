package abstractfactory;

public class Cavalry implements HumanUnit {

	public Cavalry()
	{
		createUnit();
	}
	
	@Override
	public void createUnit()
	{
		System.out.println("Cavalry is present, Sir!");
	}
	
}
