package abstractfactory;

abstract class AbstractFactory {

	abstract HumanUnit getHuman(String type);
	abstract OrcUnit getOrc(String type);
}
