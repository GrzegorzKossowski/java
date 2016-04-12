package factory;

public class Peasant implements HumanUnit {

	public Peasant()
	{
		createUnit();
	}
	
	@Override
	public void createUnit()
	{
		System.out.println("Simple worker has been created.");
	}
}
