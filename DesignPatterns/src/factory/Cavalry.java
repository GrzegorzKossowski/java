package factory;

public class Cavalry implements HumanUnit {

	public Cavalry()
	{
		createUnit();
	}
	
	@Override
	public void createUnit() 
	{
		System.out.println("Our proud human Cavalry has been created!");		
	}

}
