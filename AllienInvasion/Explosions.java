package game.kossowski.pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

/**
 * Klasa opisujaca obiekty typu Eksplozja
 * @author Grzegorz Kossowski
 *
 */
public class Explosions {
	
	/**
	 * Pozycja rakiety w przestrzeni opisana wektorem 2D
	 */
	private Vector2 position;
	
	/**
	 * Stan rakiety typu boolean. <b>True</b> - rakieta widoczna, <b>false</b> - rakieta znika. 
	 */
	private boolean isVisible;
	
	/**
	 * Zasieg skutecznego razenia rakiety.
	 */
	private int blastRange;
	
	/**
	 * Czas, po jakim strtuje zegar
	 */
	int delay = 1000;
	
	/**
	 * Zegar obliczajacy czas trwania wybuchu, po jakim isVisible przechodzi w wartosc <b>false</b>	
	 */
	Timer timerBlast = new Timer(delay, new MyTimerActionListener());
		
	/*
	 * konstruktory
	 */

	/**
	 * Konstruktor obiektu klasy Explosions
	 */
	public Explosions()
	{
		position.x=0;
		position.y=0;
		initExplosion();
	}
		
	/**
	 * Konstruktor obiektu klasy Explosions. Wywoluje metode inicjujaca.
	 * @param x - pozycja X eksplozji
	 * @param y - pozycja Y eksplozji
	 */
	public Explosions(float x, float y)
	{
		position.x = x;
		position.y = y;
		initExplosion();
	}

	/**
	 * Konstruktor obiektu klasy Explosions. Wywoluje metode inicjujaca.
	 * @param x - pozycja X eksplozji
	 * @param y - pozycja Y eksplozji
	 */
	public Explosions(int x, int y)
	{
		position.x = x;
		position.y = y;
		initExplosion();
	}

	/**
	 * Konstruktor obiektu klasy Explosions. Wywoluje metode inicjujaca.
	 * @param vector - wektor polozenia 2D
	 */
	public Explosions(Vector2 vector)
	{
		position = vector;
		initExplosion();
	}
	
	/**
	 *  Inicjacja wartosci eksplozji. Ustawia wartosc isVisible na true, zasieg wybuchu oraz czas trwania.
	 *  @see timerBlast
	 */
	public void initExplosion() 
	{		
		this.isVisible = true;
		this.blastRange = Commons.ROCKET_BLAST_RADIUS;
		timerBlast.start();		
	}
	
	/*
	 * gettery & settery
	 */
	
	/**
	 * Metoda zwraca wektor polozenia eksplozji
	 * @return zwraca pozycje eksplozji
	 */
	public Vector2 getPosition()
	{
		return this.position;
	}
	
	/**
	 * Metoda zwraca informacje na temat widocznosci (trwania) wybuchu
	 * @return zwraca typ boolean istnienia eksplozji
	 */
	public boolean getIsVisible()
	{
		return this.isVisible;
	}
	
	/**
	 * Metoda ustawia wartosc widocznosci eksplozji
	 * @param isV - true (visible), false (not visible)
	 */
	public void setIsVisible(boolean isV)
	{
		this.isVisible = isV;
	}
	
	/**
	 * Metoda zwraca wartosc zasiegu skutecznego eksplozji
	 * @return zwraca int zasiegu wybuchu
	 */
	public int getBlastRange() {
		// TODO Auto-generated method stub
		return this.blastRange;
	}

	/**
	 * Metoda ustawia zakres zasiegu skutecznego eksplozji 
	 * @param blastRange - zasieg eksplozji
	 */
	public void setBlastRange(int blastRange) {
		this.blastRange = blastRange;
	}

	/**
	 * Klasa zegara trwania eksplozji
	 */
	private class MyTimerActionListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			//wybuch staje sie niewidoczny
			setIsVisible(false);			
		}
	}


}
