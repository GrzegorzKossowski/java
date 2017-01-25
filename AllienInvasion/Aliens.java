package game.kossowski.pl;

public class Aliens extends Movables implements Commons {

	/**
	 * Licznik klasy aliensow
	 */
	private static int aliensCounter = 0;	
	
	/**
	 * Konstruktor aliensow
	 */
	public Aliens()
	{		
		//super();
		aliensCounter++;	//zwieksz ogolna ilosc aliensow
		alienInit();		//inicjujemy aliena
				
	}	
	
	/**
	 * Inicjator aliensow. Ustala losowa pozycje startowa oraz losowa pozycje celu.
	 * Wylicza wektor kierunku i predkosc.	
	 */
	private void alienInit() 
	{
		position = new Vector2((int)(Math.random()*Commons.WIDTH), -10);	//pozycja startowa aliensa
		destination = new Vector2((int)(Math.random()*Commons.WIDTH), Commons.HEIGHT);	//cel aliensa
		vSpeed = new Vector2();		//wektor kierunku -> predkosci
		vSpeed = Vector2.destination(position, destination);
		vSpeed.normalize();	//normalizujemy wektor kierunku -> predkosci
		speed = (float) (Math.floor(Math.random())*Commons.MAX_ALIEN_SPEED + Commons.MIN_ALIEN_SPEED + 1);	//losowa szybkosc aliensa
		vSpeed.x*=speed;
		vSpeed.y*=speed;
		
	}

	/**
	 * Getter klasowego licznika aliensow 
	 * @return zwraca ilosc obiektow aliensow
	 */
	public static int getAliensCounter()
	{
		return aliensCounter;
	}
	
	/**
	 * Zmniejsza klasowy licznik aliensow o wartosc przeslana jako parametr.
	 * @param value - parametr ilosci aliensow do usuniecia w tym kroku
	 */
	public static void decreaseAliensCounter(int value) {
		if (getAliensCounter()>0)
		{
			aliensCounter-=value;
		}
	}
		
}
