package factory;

public class HumanFactory {

	public HumanUnit getUnit (String unitType)
	{
		if (unitType == null)
		{
			return null;
		}
		switch (unitType)
		{
		case "cavalry":
			return new Cavalry();			
		case "knight":
			return new Knight();			
		case "peasant":
			return new Peasant();			
		default:
			return null;			
		}		
	}
	
}
