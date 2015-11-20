package game.kossowski.pl;

/**
 * Superklasa ruchomych obiektow
 * @author Grzegorz Kossowski
 *
 */
public class Movables {

	/**
	 * Pozycja obiektu w przestrzeni opisana wektorem 2D 
	 */
	Vector2 position;
	
	/**
	 * Cel obiektu w przestrzeni opisana wektorem 2D
	 */
	Vector2 destination;
	
	/**
	 * Wektor kierunku, a po znormalizowaniu, wektor predkosci obiektow ruchomych
	 */
	Vector2 vSpeed;
	
	/**
	 * Predkosc obiektu - skalar
	 */
	float speed;
	
	/**
	 * Metoda sluzaca przesunieciu danego obiektu w przestrzeni 2D
	 */
	public void moveObject() 
	{		
		this.position.x += this.vSpeed.x;
		this.position.y += this.vSpeed.y;
	}
	
}
