package game.kossowski.pl;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Klasa obslugujaca warstwe wizualna. Odpowiada za rysowanie srodowiska gry.
 * View.
 * @author Grzegorz Kossowski
 *
 */
public class Board extends JPanel implements Commons {
	
	/**
	 * Obiekt modelu.
	 */
	private Engine engine;
	
	/**
	 * Obrazek - ikona gracza 
	 */
	private BufferedImage playerIcon;
	
	/**
	 * Obrazek - ikona miasta
	 */
	private BufferedImage cityIcon;
	
	/**
	 * Tablica przetrzymujaca obiekty obcych
	 */
	private ArrayList<Movables> movables;
	
	/**
	 * Tablica przetrzymujaca obiekty rakiet
	 */
	private ArrayList<Movables> rockets;
	
	/**
	 * Tablica przetrzymujaca obiekty eksplozji (rakiet)
	 */
	private ArrayList<Explosions> explosions;
	
	/**
	 * Tablica przetrzymujaca obiekty eksplozji alienow
	 */
	private ArrayList<Explosions> alienExplosions;
	
	/**
	 * Zegar odswiezania obrazu fps	
	 */
	Timer timer = new Timer(1000/Commons.FRAME_RATE, new MyTimerActionListener());
		
	/**
	 * Konstruktor obiektu widoku
	 * @param engine - przetrzymuje obiekt modleu
	 */
	public Board(Engine engine) 
	{
		this.engine = engine;
		this.movables = engine.getMobablesList();
		this.rockets = engine.getRocketsList();
		this.explosions = engine.getExplosions();
		this.alienExplosions = engine.getAlienExplosions();
		
		//inicjujemy board gry
		initBoard();		
	}
		
	/**
	 * Metoda inicjujaca widok gry
	 */
	private void initBoard()
	{			
		this.setBackground(Color.black);	//color panelu
		//pobieramy obrazek playera i miasta		
		try 
		{
			playerIcon = ImageIO.read(getClass().getResource("img/player.png"));
			cityIcon = ImageIO.read(getClass().getResource("img/city.png"));
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	
		//startujemy timer odswiezania obrazu fps
		timer.start();		
	}

	@Override
	public void paint(Graphics g)
	{
		super.paint(g);
		drawBoard(g);
	}

	/**
	 * Glowna metoda rysujaca obiekt widoku
	 * @param g
	 */
	private void drawBoard(Graphics g)	//rysujemy plansze
	{			
		super.paint(g);
		g.setColor(Color.YELLOW);
		drawExplosion(g);
		g.setColor(Color.RED);
		drawAliens(g);
		drawAliensExplosion(g);
		g.setColor(Color.WHITE);
		drawRockets(g);
		drawPlayer(g);
		drawStats(g);
		Toolkit.getDefaultToolkit().sync();		
	}

	/**
	 * Metoda wypisujaca statystyki gry
	 * @param g
	 */
	private void drawStats(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.GREEN);
		g.setFont(new Font("Serif", Font.BOLD, 12));
		g.drawString("Population decline: " + (int)Engine.populationDecline, 10, 20);		
		g.drawString("Shots fired: " + Engine.shotsFired, 10, 40);
		g.drawString("Aliens destroyed: " + Engine.aliensDestroyed, 10, 60);
		g.drawString("Max. efficiency: " + Engine.efficiency + " %", 10, 80);
	}

	/**
	 * Metoda rysujaca obiekty rakiet.
	 * @param g
	 */
	private void drawRockets(Graphics g) 
	{	
		for(Movables r: rockets)
		{			
			//tutuaj rysujemy rakiety
			g.fillRect((int)r.position.x-1, (int)r.position.y-1, 3, 3);			
		}		
	}
	
	/**
	 * Metoda rysujaca obiekty eksplozji
	 * @param g
	 */
	private void drawExplosion(Graphics g) 
	{
		for(Explosions e: explosions)
		{			
			//tutuaj rysujemy eksplozje						
			g.drawOval((int)e.getPosition().x - (e.getBlastRange()/2), (int)e.getPosition().y - (e.getBlastRange()/2), e.getBlastRange(), e.getBlastRange());
		}		
	}
	
	/**
	 * Metoda rysujaca obiekty eksplozji obcych
	 * @param g
	 */
	private void drawAliensExplosion(Graphics g) 
	{
		for(Explosions e: alienExplosions)
		{			
			//tutuaj rysujemy eksplozje						
			g.drawOval((int)e.getPosition().x - 50, (int)e.getPosition().y - 50, 100, 100);
		}		
	}

	/**
	 * Metoda rysujaca obiekty obcych
	 * @param g
	 */
	private void drawAliens(Graphics g)
	{
		for(Movables a: movables)
		{			
			//tutuaj rysujemy aliensow
			g.fillRect((int)a.position.x-1, (int)a.position.y-1, 3, 3);
		}
	}

	/**
	 * Metoda rysujaca obiekt Player
	 * @param g
	 */
	private void drawPlayer(Graphics g)
	{
		g.drawImage(cityIcon, super.getWidth()/2-cityIcon.getWidth()/2, super.getHeight()-cityIcon.getHeight(), this);
		g.drawImage(playerIcon, super.getWidth()/2-playerIcon.getWidth()/2, super.getHeight()-playerIcon.getHeight(), this);
	}
	
	/**
	 * Klasa obslugujaca zegar odpowiedzialny za odswiezanie obrazu.
	 * W regularnych odstepach czasu rysuje alienow, rakiety i eksplozje
	 * @author Grzegorz Kossowski
	 *
	 */
	private class MyTimerActionListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			repaint(0,0,Commons.WIDTH, Commons.HEIGHT);
			engine.moveAliens();			
			engine.moveRockets();
			engine.reMoveExplosions();
		}
	}
}
