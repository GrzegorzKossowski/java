package builder;

public class Castle {

	DrawBridge drawbridge;
	Keep keep;
	Walls walls;
	
	public Castle()
	{
		String string1 = "Castle has been founded.";
		String string2 = "Long live the king!";				
		System.out.printf("%s %s\n", string1, string2);
	}
	
	public void setDrawBridge(DrawBridge drawbridge)
	{
		this.drawbridge = drawbridge;
	}
	
	public void setKeep(Keep keep)
	{
		this.keep = keep;
	}
	
	public void setWalls(Walls walls)
	{
		this.walls = walls;
	}

	public void getStatus() {
		// TODO Auto-generated method stub
		System.out.println("Castle ready!");
		
	}
	
}
