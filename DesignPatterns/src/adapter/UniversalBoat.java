package adapter;

public class UniversalBoat implements Boat {
	
	private AAGun aaGun = new AAGun();
	private BigGun bigGun = new BigGun();
	private SubMine subMine = new SubMine();
	
	/**
	 * 
	 * @param enemyType - string, et. "aircraft", "ship",
	 * "submarine"
	 */
	@Override
	public void attack(String enemyType)
	{
		if (enemyType.equalsIgnoreCase("aircraft")) 
		{
			aaGun.sendMissile();
		}
		if (enemyType.equalsIgnoreCase("ship"))
		{
			bigGun.ShootBigGun();
		}
		if (enemyType.equalsIgnoreCase("submarine"))
		{
			subMine.mineRelease();
		}
	}
	
}
