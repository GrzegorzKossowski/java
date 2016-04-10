package komunikator;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * MVC - View (Main Window)
 * Klasa modelu MVC odpowiedzialna za czesc widoku (View),
 * tworzaca glowne okno programu.
 * @author Grzegorz Kossowski *
 */

public class View extends JFrame 
{
	/**
	 * Obiekt klasy Model wykorzystywany przez obiekt View
	 * do realizacji zadan
	 */
	private Model mainModel;

	// wymiary okna. Moznaby wczytywać z jakiegos pliku settings.class, albo
	// mialem pomysl, ze z pliku json.txt, ale wymaga dołączenia dodatkowej  
	// biblioteki, żeby zrobić parser...
	private int mainWindowWidth = 400;
	private int mainWindowHeight = 600;
	
	/**
	 * Konstruktor klasy View, tworzacy okno 
	 * @param mainModel
	 */
	public View() {
		this.mainModel = mainModel;
	}

	public void createWindow() 
	{
		JFrame frame = new JFrame("Komunikator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setPreferredSize(new Dimension(mainWindowWidth, mainWindowHeight));
		Container contentPane = new Container();
		
		//stwórz obiekt menuBar z nested class
		View.TextMenu textMenu = new View.TextMenu();
		frame.setJMenuBar(textMenu.createTextMenu());
						
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);				
		
	}	
	
	final class TextMenu {
		
		public JMenuBar createTextMenu() {
			
			JMenuBar menuBar = new JMenuBar();
			// menu File
			JMenu menuFile = new JMenu("File");
			menuFile.setMnemonic(KeyEvent.VK_F);
			JMenuItem itemNew = new JMenuItem("Connect", KeyEvent.VK_C);
			menuFile.add(itemNew);
			menuFile.addSeparator();
			JMenuItem itemOpen = new JMenuItem("Exit", KeyEvent.VK_O);
			menuFile.add(itemOpen);
			
			menuBar.add(menuFile);
			
			return menuBar;
			
		}
		
	}
	
}
