package abstractfactory;

public class HumanFactory extends AbstractFactory {

	@Override
	public HumanUnit getHuman(String unitType)
	{
		if (unitType == "")
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

	@Override
	OrcUnit getOrc(String type) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
