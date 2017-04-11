package app.behavioral.command;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * DesignPatterns
 * Created by Grzegorz Kossowski on 11.04.17.
 */
public class Command {

    public static void main(String[] args) {



        CommandController commandController = new CommandController();
        HumanAttack humanAttack = new HumanAttack(new Human());
        OrcAttack orcAttack = new OrcAttack(new Orc());
        commandController.setCommandInterface(humanAttack).execute();
        commandController.setCommandInterface(orcAttack).execute();

        commandController
                .setCommandInterface(new ElfAtack(new Elf()))
                .execute();
        commandController
                .setCommandInterface(new ElfSing(new Elf()))
                .execute();

    }
}

//-----------Command obj.

class CommandController {
    CommandInterface commandInterface;

    public CommandController setCommandInterface(CommandInterface commandInterface) {
        this.commandInterface = commandInterface;
        return this;
    }

    public void execute() {
        commandInterface.execute();
    }
}

//-----------Invokers (interface & warpers / commands and orders /)

interface CommandInterface {
    void execute();
}

class HumanAttack implements CommandInterface {
    Human human;

    public HumanAttack(Human human) {
        this.human = human;
    }

    @Override
    public void execute() {
        human.attack();
    }
}

class OrcAttack implements CommandInterface {

    Orc orc;

    public OrcAttack(Orc orc) {
        this.orc = orc;
    }

    @Override
    public void execute() {
        orc.attack();
    }
}

class ElfSing implements CommandInterface {

    Elf elf;

    public ElfSing(Elf elf) {
        this.elf = elf;
    }

    @Override
    public void execute() {
        elf.sing();
    }
}

class ElfAtack implements CommandInterface {

    Elf elf;

    public ElfAtack(Elf elf) {
        this.elf = elf;
    }

    @Override
    public void execute() {
        elf.attack();
    }
}

//--------- Recivers ------------

class Human {
    void attack() {
        System.out.println("Human is attacking!!!");
    }
}

class Orc {
    void attack() {
        System.out.println("Orc is attacking!!!");
    }
}

class Elf {
    void attack() {
        System.out.println("Efl is attacking!!!");
    }

    void sing() {
        System.out.println("Elf is singing...~~~");
    }
}