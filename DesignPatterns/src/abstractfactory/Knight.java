package abstractfactory;

public class Knight implements HumanUnit {

	public Knight()
	{
		createUnit();
	}
	
	@Override
	public void createUnit()
	{
		System.out.println("Knight is present!");
	}
	
}
