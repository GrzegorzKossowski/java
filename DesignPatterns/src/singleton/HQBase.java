package singleton;

public class HQBase {

	// zmienna klasowa (static) - pojedyńcza instancja dla całej klasy
	private static HQBase hqBase = new HQBase();
	
	// prywatny konstruktor, dostępny tylko dla siebie samej (klasy)
	private HQBase() 
	{
		System.out.println("And so the Word became flesh and took a place among us for a time;");	
	}
	
	// statyczna metoda klasy do pobrania jednej instancji 
	public static HQBase getHQBase()
	{
		System.out.println("That which has been is that which will be, So there is nothing new under the sun.");
		return hqBase;
	}
	
	public void printStatus()
	{
		System.out.println("Show must go on...");
	}
	
}
