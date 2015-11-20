package game.kossowski.pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.Timer;

/**
 * Klasa opisująca Model przeliczajacy dane w grze
 * @author Grzegorz Kossowski
 */
public class Engine {
	
	/**
	 * Singleton
	 */
	private static Engine singleInstanceOfEngine = new Engine();
	
	// statystyki
	/**
	 * Ilosc ofiar najazdu obcych. Generowana losowo przy kazdej eksplozji aliena
	 */
	static double populationDecline = 0;
	
	/**
	 * Ilosc wystrzelonych w trakcie gry rakiet. Sluzy wyliczeniu sredniej efektywnosci gracza w stosunku do trafionych Obcych.
	 */
	static int shotsFired = 0;
	
	/**
	 * Ilosc zniszczonych Obcych. Sluzy m.in. wyliczeniu sredniej efektywnosci gracza w stosunku do wystrzelonych rakiet.
	 */
	static int aliensDestroyed = 0;
	
	/**
	 * Srednia efektywnosc gracza. Procent zestrzelonych Obcych w stosunku do wystrzelonych rakiet.
	 */
	static int efficiency = 0;

	// tablice	
	/**
	 * Tablica ruchomych obiektow zawierająca obiekty Obcych
	 */
	private ArrayList<Movables> movables;
	
	/**
	 * Tablica ruchomych obiektow zawierająca obiekty rakiet
	 */
	private ArrayList<Movables> rockets;
	
	/**
	 * Tablica obiektow zawierająca obiekty eksplozji rakiet
	 */
	private ArrayList<Explosions> explosions;
	
	/**
	 * Tablica obiektow zawierająca obiekty eksplozji Obcych
	 */
	private ArrayList<Explosions> alienExplosions;
	
	/**
	 *  Liczba losowa do wygenerowania czasu startowego do zegara
	 */
	private Random randomTime = new Random();

	/**
	 * Losowy czas rozpoczęcia ataku (stworzenia pierwszego Obcego)
	 */
	private int randomTimeOutput = (Commons.MIN_ALIEN_SPAWN_TIME + randomTime.nextInt(Commons.MAX_ALIEN_SPAWN_TIME - Commons.MIN_ALIEN_SPAWN_TIME + 1));
	
	/**
	 * Zegar losowy generujacy Obcych
	 */
	Timer alienAddTimer = new Timer(randomTimeOutput, new AlienSpawnTimerActionListener());
	
	/**
	 * Konstruktor obiektu klasy Engine
	 */	
	private Engine()
	{
		movables = new ArrayList<Movables>();	//tablica alienow
		rockets = new ArrayList<Movables>();	//tablica rakiet
		explosions = new ArrayList<Explosions>();	//tablica eksplozji
		alienExplosions = new ArrayList<Explosions>();	//tablica eksplozji alienow
		
		alienAddTimer.start();		//start zetara generujacego alienow
	}

	/**
	 * Pobranie singletona klasy Engine
	 * @return zwraca pojedyncza instancje klasy Engine
	 */
	public static Engine getSingleInstance()
	{
		return singleInstanceOfEngine;
	};
	
	/**
	 * Metoda dodawania kolejnego Obcego do tablicy alienow
	 */
	public void addAlien()	//dodawanie alienow
	{		
		Movables alien = new Aliens();
		movables.add(alien);		
	}
	
	/**
	 * Metoda tworzenia i dodawania kolejnej rakiety do tablicy rakiet
	 * @param mouseX - pozycja X klikniecia myszy
	 * @param mouseY - pozycja Y klikniecia myszy
	 */
	public void addRocket(int mouseX, int mouseY)
	{		
		Movables rocket = new Rockets(mouseX, mouseY);
		rockets.add(rocket);
		Engine.shotsFired++;	//
	}
	
	/**
	 * Metoda dodaje obiekt typu eksplozja w miejscu docelowym danej rakiety
	 * @param vEc - wektor eksplozji na pozycji celu-rakiety
	 */
	public void addExplosion(Vector2 vEc)
	{
		Explosions explosion = new Explosions(vEc);
		explosions.add(explosion);
		
		//sprawdza, czy alien jest w zasiegu
		for (Movables a: new ArrayList<Movables>(movables))
		{
			if ((int)Vector2.distance(a.position, explosion.getPosition()) < (int)explosion.getBlastRange() )
			{
				// jesli poza plansza, usuwamy								
				movables.remove(a);
				Engine.aliensDestroyed++;
			}						
		}
		// sprawdz statystyki
		countEfficiency();
	}

	/**
	 * Metoda dodaje obiekt typu eksplozja w miejscu wybuchu aliena
	 * @param position - pozycja aliena na dolnym krancu planszy
	 */
	private void addAlienExplosion(Vector2 position) 
	{
		//dodaj eksplozje w miejscu upadku aliena
		Explosions explosion = new Explosions(position);
		alienExplosions.add(explosion);
	}
	
	/**
	 * Metoda oblicza efektywnosc gracza porownujac ilosc wystrzelonych rakiet do trafionych alienow
	 */
	private void countEfficiency() 
	{
		if (Engine.shotsFired > 0)
		{
			Engine.efficiency = Math.round((Engine.aliensDestroyed * 100)/Engine.shotsFired);
		} else {
			Engine.efficiency = 0;
		}		
	}

	/**
	 * Metoda przesuwa Obcych w przestrzeni 2D odwolujac sie do metody obiektu i jednoczesnie usuwa go,
	 * jesli spelniony jest warunek osiagniecia celu. Spelnienie tego warunku generuje eksplozje
	 */
	public void moveAliens()
	{
		for(Movables a: movables)
		{			
			//tutuaj przemieszczamy aliensow
			a.moveObject();
		}

		//petla tworzy kopie talibcy movables i na jej podstawie usuwa elementy na podstawie zadanych warunkow
		for (Movables r: new ArrayList<Movables>(movables))
		{
			if ((int)r.position.y > Commons.HEIGHT-50)
			{
				// jesli poza plansza, usuwamy
				Engine.populationDecline += (int)(Math.random()*5000)+1000;
				addAlienExplosion(r.position);
				movables.remove(r);
			}						
		}		
	}

	/**
	 * Przesuwa rakiety w przestrzeni 2D odwolujac sie do metody obiektu, a takze
	 * usuwa go na podstawie zadanych warunkow - osiagniecie celu na wybrana odleglosc
	 * Generuje eksplozje w miejscu usunietej rakiety
	 */
	public void moveRockets()
	{
		for(Movables r: rockets)
		{			
			//tutuaj przemieszczamy aliensow
			r.moveObject();
		}

		//petla tworzy kopie talibcy rockets i na jej podstawie usuwa elementy na podstawie zadanych warunkow
		for (Movables q: new ArrayList<Movables>(rockets))
		{
			Vector2 rV = new Vector2(q.position.x, q.position.y);
			Vector2 tV = new Vector2(q.destination.x, q.destination.y);
			
			if ((int)Vector2.distance(rV, tV) < 5 )
			{
				// generujemy eksplozje w tym miejscu
				this.addExplosion(q.position);
				
				// usuwamy rakiete z tablicy rakiet				
				rockets.remove(q);
			}						
		}		
	}
	
	/**
	 * Usuwa eksplozje z tablicy eksplozji.
	 */
	public void reMoveExplosions() 
	{		
		//petla tworzy kopie talibcy explosions i na jej podstawie usuwa elementy na podstawie zadanych warunkow
		for (Explosions e: new ArrayList<Explosions>(explosions))
		{	
			if (!e.getIsVisible())
			{	
				// usuwamy eksplozje z tablicy				
				explosions.remove(e);
			}						
		}
		//petla tworzy kopie talibcy alienExplosions i na jej podstawie usuwa elementy na podstawie zadanych warunkow
		for (Explosions a: new ArrayList<Explosions>(alienExplosions))
		{	
			if (!a.getIsVisible())
			{	
				// usuwamy eksplozje z tablicy				
				alienExplosions.remove(a);
			}						
		}
	}	
	
	
	/**
	 * Restart zegara dodawania aliensow. Za kazdym razem czas pojawienia sie aliensow jest 
	 * generowany losowo.
	 */
	private void updateTimer() {
	    alienAddTimer.stop();
	    randomTimeOutput = (Commons.MIN_ALIEN_SPAWN_TIME + randomTime.nextInt(Commons.MAX_ALIEN_SPAWN_TIME - Commons.MIN_ALIEN_SPAWN_TIME + 1));
	    alienAddTimer.setInitialDelay(randomTimeOutput);	    
	    alienAddTimer.restart();
	}

	/**
	 * getter pobierajacy tablice aliensow
	 * @return zwraca tablice aliensow
	 */
	public ArrayList<Movables> getMobablesList() 
	{
		return this.movables;
	}

	/**
	 * getter tablicy rakiet
	 * @return zwraca tablice rakiet
	 */
	public ArrayList<Movables> getRocketsList() 
	{
		return this.rockets;
	}

	/**
	 * getter tablicy explozji
	 * @return zwraca tablice eksplozji
	 */
	public ArrayList<Explosions> getExplosions() 
	{
		return explosions;
	}

	/**
	 * getter tablicy eksplozji alienow
	 * @return zwraca tablice eksplozji alienow
	 */
	public ArrayList<Explosions> getAlienExplosions() {
		// TODO Auto-generated method stub
		return alienExplosions;
	}

//	public void setExplosions(ArrayList<Explosions> explosions) 
//	{
//		this.explosions = explosions;
//	}

	/**
	 * Klasa dodajaca kolejnych alienow zaleznie od sygnalu losowego timera.
	 * Generuje aliena i resetuje zegar.
	 * @author Grzegorz Kossowski
	 *
	 */
	private class AlienSpawnTimerActionListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			//timer spawningu alienow
			addAlien();
			updateTimer();
		}
	}

	/**
	 * Metoda zerujaca wszystkie zmienne i rozpoczynajaca nowa gre
	 */
	public void startNewGame() 
	{
		shotsFired = 0;
		aliensDestroyed = 0;
		efficiency = 0;
		
		movables.clear();
		rockets.clear();
		explosions.clear();
		alienExplosions.clear();
			
	}

}
