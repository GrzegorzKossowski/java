package game.kossowski.pl;

/**
 * Klasa pomagajaca obliczac wektory polozenia obiektow w przestrzeni 2D. 
 * @author Grzegorz Kossowski
 */
public class Vector2 {

	float x;
	float y;
	
	/**
	 * Konstruktor bezparametrowy. Wektor zerowy o wspolrzednych x=0, y=0;
	 * @author Grzegorz Kossowski	 *  
	 */
	public Vector2()
	{
		this.x = 0.0f;
		this.y = 0.0f;		
	}
	
	/**
	 * Metoda tworzy obiekt wektorowy na podstawie dwoch podanych wspolrzednych.
	 * @param x
	 * @param y
	 */
	public Vector2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Metoda tworzy obiekt wektorowy na podstawie wspolrzednych pozycji myszy w momencie klikniecia.
	 * @param mousePos
	 */
	public Vector2(Vector2 mousePos) {
		this.x = mousePos.x;
		this.y = mousePos.y;
	}

	/**
	 * Metoda oblicza dlugosc wskazanego wektora i zwraca jej wartosc
	 * @param a
	 * @return dlugosc wektora
	 */
	public static double length(Vector2 a)
	{
		return Math.sqrt(a.x*a.x+a.y*a.y);		
	}
	
	/**
	 * Metoda oblicza wektor kiernku, w jakim ma poruszac sie obiekt w przestrzeni 2D.
	 * @param a
	 * @param b
	 * @return wektor kierunkowy
	 */
	public static Vector2 destination(Vector2 a, Vector2 b)
	{
		Vector2 v = new Vector2();
		v.x = b.x - a.x;
		v.y = b.y - a.y;
		return v;		
	}
	
	/**
	 * Metoda oblicza odleglosc miedzy dwoma punktami w przestrzeni na podstawie ich wektorow (dlugosc wektora)
	 *  
	 * @param a
	 * @param b
	 * @return
	 */
	public static double distance (Vector2 a, Vector2 b)
	{
		float v0 = b.x - a.x;
		float v1 = b.y - a.y;
		return Math.sqrt(v0*v0 + v1*v1);		
	}
	
	/**
	 * Metoda normalizuje wektor obiektu, w celu obliczenia predkosci przemieszczania 
	 */
	public void normalize()
	{
		double length = Math.sqrt(x*x+y*y);
		if (length !=0.0)
		{
			float s = 1.0f / (float)length;
			x = x*s;
			y = y*s;
		}
	}
	
}
