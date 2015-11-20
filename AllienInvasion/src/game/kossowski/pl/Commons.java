package game.kossowski.pl;

/**
 * Interface przetrzymujacy dane globalne.
 * @author Grzegorz Kossowski
 *
 */
public interface Commons {

	public static final int WIDTH=1200;		//szerokosc okna
	public static final int HEIGHT=800;		//wysokosc okna
	public static final int FRAME_RATE = 25;	//czestosc odswiezania obrazu fps
	public static final int MIN_ALIEN_SPAWN_TIME = 50;	//min. czas spawnowania aliensow
	public static final int MAX_ALIEN_SPAWN_TIME = 3000;	//max. czas spawnowania aliensow
	public static final float MIN_ALIEN_SPEED = 0.1f;			//min. predkosc aliensow
	public static final float MAX_ALIEN_SPEED = 0.5f;			//max. predkosc aliensow
	public static final float ROCKET_SPEED = 5.0f;//(float) (MAX_ALIEN_SPEED + 1.5); //predkosc rakiety
	public static final int ROCKET_BLAST_RADIUS = 50;	//zasieg wybuchu rakiety
	
}
