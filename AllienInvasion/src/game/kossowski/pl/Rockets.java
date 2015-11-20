package game.kossowski.pl;

/**
 * Klasa opisujaca obiekty typu rakieta
 * @author Grzegorz Kossowski
 */
public class Rockets extends Movables implements Commons {

	/**
	 * Licznik wystrzelonych rakiet
	 */
	private static int rocketCounter = 0;
	
	/**
	 * Predkosc obiektu w przestrzeni 2D - skalar
	 */
	private int speed;

	/**
	 * Metoda inicjujaca obiekt rakieta oraz zwiekszajaca ogolny licznik rakiet (licznik klasy) 
	 * @param mouseX - pozycja X klikniecia myszy
	 * @param mouseY - pozycja Y klikniecia myszy
	 */
	public Rockets(int mouseX, int mouseY) {		
		rocketCounter++;	//zwieksz ogolna ilosc rakiet		
		rocketInit(mouseX, mouseY);		//inicjujemy rakiete
	}

	/**
	 * Metoda inicjujaca obiekt klasy Rocket. Na podstawie wektorow polozenia i celu metoda
	 * oblicza kierunek ruchu i predkosc przemieszczenia w przestrzeni 2D 
	 * @param mouseX - pozycja X klikniecia myszy
	 * @param mouseY - pozycja Y klikniecia myszy
	 */
	private void rocketInit(int mouseX, int mouseY) 
	{
		position = new Vector2(Commons.WIDTH/2, Commons.HEIGHT - 60);	//pozycja startowa rakiety
		destination = new Vector2(mouseX, mouseY);	//cel rakiety		
		vSpeed = new Vector2();		//wektor kierunku -> predkosci
		vSpeed = Vector2.destination(position, destination);
		vSpeed.normalize();	//normalizujemy wektor kierunku -> predkosci
		speed = (int)Commons.ROCKET_SPEED;	//szybkosc rakiety
		vSpeed.x*=speed;
		vSpeed.y*=speed;
	}
	
	/**
	 * Metoda zwraca klasowy licznik obiektow klasy Rockets.
	 * @return zwraca rocketCounter
	 */
	public static int getRocketsCounter()
	{
		return rocketCounter;
	}
}