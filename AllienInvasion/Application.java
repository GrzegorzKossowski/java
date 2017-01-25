package game.kossowski.pl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

/**
 * Klasa main (oraz rysujaca glowne okno programu) 
 * @author Grzegorz Kossowski
 *
 */
public class Application extends JFrame implements MouseListener,Commons {
			
	/**
	 * Glowne okno programu
	 */
	private JFrame mainFrame;
	
	/**
	 * Belka glownego menu
	 */
	private JMenuBar menuBar;
	
	/**
	 * Obiekt modelu odpowiedzialnego za obliczenia
	 */
//	private Engine engine = new Engine();	
	private Engine engine = Engine.getSingleInstance();

	/**
	 * Klasa main()
	 * @param args 
	 */
	public static void main(String[] args)
	{		
		SwingUtilities.invokeLater(new Runnable()
		{
			public void run() 
			{
				Application app = new Application();
			}
		});		
	}	// end of main()
	
	/**
	 * Konstruktor aplikacji	
	 */
	public Application()
	{		
		initGui();		
	}
	
	/**
	 * Metoda inicjujaca GUI
	 */
	private void initGui() {
		
		mainFrame = new JFrame("Alien Invasion");		//nowy obiekt okno		
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//sposob zamkniecia [x]
				
		Board board = new Board(engine);		//obiekt panel wewnetrzny		
		//board.addMouseListener(this);			//dodanie metody do obiektu
		
		board.addMouseListener(new MouseAdapter()
		{
			public void mousePressed(MouseEvent e)
			{
				engine.addRocket(e.getX(), e.getY());
			}
		});			
					
		mainFrame.add(board);				//dodanie panelu do okna
		mainFrame.setJMenuBar(drawMenuBar());

		mainFrame.setResizable(false);			//zmiana rozmiaru
		mainFrame.pack();	
		mainFrame.setSize(Commons.WIDTH,Commons.HEIGHT);	//wymiary
		mainFrame.setLocationRelativeTo(null);	//centrowanie
		mainFrame.setVisible(true);			//prezentacja okna
	}


	//Brakujace autogenerowane metody dotyczace zachowan myszy
	
	public void mouseClicked(MouseEvent e) 	{}
	public void mousePressed(MouseEvent e)	{}
	public void mouseReleased(MouseEvent e)	{}
	public void mouseEntered(MouseEvent e) 	{}
	public void mouseExited(MouseEvent e) 	{}

	/**
	 * Funkcja konstruująca i zwracająca belkę menu do funkcji prepareGui(). 
	 * 
	 * @return menuBar obiekt odpowiedzialny za rysowanie belki menu.
	 */
	private JMenuBar drawMenuBar ()
	{
		//menuBar - menu glowne programu
		menuBar = new JMenuBar();
		//elementy tematyczne menuBar
		JMenu fileMenu = new JMenu("File");
		JMenu helpMenu = new JMenu("Help");
		//menuitems - elementy skladowe elementow tematycznych
		JMenuItem newMenuItem = new JMenuItem("New Game");		
		JMenuItem exitMenuItem = new JMenuItem("Exit");
		JMenuItem rulesMenuItem = new JMenuItem("Rules");
		JMenuItem aboutMenuItem = new JMenuItem("About");
		
		//add menuitems to menus
		fileMenu.add(newMenuItem);
		fileMenu.addSeparator();
		fileMenu.add(exitMenuItem);
		helpMenu.add(rulesMenuItem);
		helpMenu.add(aboutMenuItem);		
		
		// Event dla elementu "nowa gra"
		newMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
            	System.out.println("Nowa gra");  
            	engine.startNewGame();
            }
		});
		// Event dla elementu Exit - wyjscie z gry
		exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) 
            {
            	//wyjscie z programu
            	System.exit(EXIT_ON_CLOSE);
            }            
		});
		// Event dla elementu rulesMenu
		rulesMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(mainFrame, "Aim and fire missiles to destroy Invaders.", "Rules", JOptionPane.QUESTION_MESSAGE);
			}
		});
		// Event dla elementu rulesMenu
		aboutMenuItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(mainFrame, "Copyright Grzegorz Kossowski 2015.", "About", JOptionPane.INFORMATION_MESSAGE);
			}
		});
				
		//add menu to menubar
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		return menuBar;		
	}	
}