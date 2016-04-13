package builder;

public class CastleBuilder {

	public static Castle createCastle()
	{		
	
	Castle castle = new Castle();
	
	DrawBridge drawbridge = new DrawBridge();
	Keep keep = new Keep();
	Walls walls = new Walls();
	
	castle.setWalls(walls);
	castle.setDrawBridge(drawbridge);
	castle.setKeep(keep);	
	
	return castle;
	
	}
	
}
