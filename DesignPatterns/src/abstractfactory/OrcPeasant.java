package abstractfactory;

public class OrcPeasant implements OrcUnit {

	public OrcPeasant()
	{
		createUnit();
	}
	
	public void createUnit()
	{
		System.out.println("Agrhhh... What's up master?");
	}
	
}
