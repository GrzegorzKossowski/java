package factory;

public class Knight implements HumanUnit {

	public Knight()
	{
		createUnit();
	}
	
	@Override
	public void createUnit() 
	{
		System.out.println("Human Knight has been created!");
	}
	
}
