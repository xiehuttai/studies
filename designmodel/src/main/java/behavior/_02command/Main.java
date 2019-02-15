package behavior._02command;

import java.util.ArrayList;
import java.util.List;

/**
 * 命令模式
 */
public class Main {

    public static void main(String[] args) {

        MenuItem menuItem = new MenuItem();

        Command createCommand = new CreateCommand();
        Command openCommand = new OpenCommand();
        Command editCommand = new EditCommand();

        menuItem.addCommand(createCommand);
        menuItem.addCommand(openCommand);
        menuItem.addCommand(editCommand);

        menuItem.onClick();

    }
}

abstract class Command{
    abstract  void execute();
}

abstract class Receiver {

    abstract void handle();
}

class OpenReceiver extends Receiver{

    @Override
    void handle() {
        System.out.println("open it");
    }
}

class CreateReceiver extends Receiver{

    @Override
    void handle() {
        System.out.println("create it");
    }
}

class OpenCommand extends Command{

    Receiver openReceiver= new OpenReceiver();

    @Override
    void execute() {
        openReceiver.handle();
    }
}

class CreateCommand extends Command{

    Receiver createReceiver= new CreateReceiver();

    @Override
    void execute() {
        createReceiver.handle();
    }

}

class EditReceiver extends Receiver{

    @Override
    void handle() {
        System.out.println("edit it");
    }
}

class EditCommand extends Command{

    Receiver editReceiver= new EditReceiver();

    @Override
    void execute() {
        editReceiver.handle();
    }
}



class MenuItem{

    private List<Command> commands = new ArrayList<>();

    void onClick(){
        for (Command c: commands)
            c.execute();
    }

    public void addCommand(Command command) {
        commands.add(command);
    }
}
