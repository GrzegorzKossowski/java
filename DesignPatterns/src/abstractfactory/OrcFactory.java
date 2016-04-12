package abstractfactory;

public class OrcFactory extends AbstractFactory {

	@Override
	public OrcUnit getOrc(String unitType)
	{
		if (unitType == "")
		{
			return null;	
		}
		switch(unitType)
		{
		case "cavalry":
			return new OrcCavalry();
		case "footman":
			return new OrcFootman();
		case "peasant":
			return new OrcPeasant();
		default:
			return null;
		}		
	}

	@Override
	HumanUnit getHuman(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
