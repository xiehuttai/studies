package structure.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合composite模式
 */
public class Main {

    public static void main(String[] args) {

        Component button1 = new Button();
        Component button2 = new Button();
        Component checkBox = new CheckBox();

        ContainerComponent midBoard = new MidBoard();
        ContainerComponent window = new Window();

        midBoard.add(checkBox);
        midBoard.add(button1);


        window.add(button2);
        window.add(midBoard);

        window.doIt();


    }

}

abstract class Component{

    abstract void isWhat();

    abstract void doIt();
}

class LeafComponent extends Component{

    @Override
    void doIt() {
        isWhat();
        System.out.println("leaf do.");
    }

    @Override
    void isWhat() {
        System.out.println("leaf.");
    }
}

class ContainerComponent extends Component{

    List<Component> components= new  ArrayList<Component>();

    @Override
    void isWhat() {
        System.out.println("container.");
    }

    @Override
    void doIt() {
        isWhat();
        System.out.println("{");
        for(Component component:components){
            component.doIt();
        }
        System.out.println("}");
    }

    void add(Component component){
        components.add(component);
    }

    void remove(Component component){
        components.remove(component);
    }
}

class Button extends LeafComponent{

    @Override
    void doIt() {
        super.doIt();
    }

    @Override
    void isWhat() {
        System.out.println("leaf button.");
    }
}

class CheckBox extends LeafComponent{

    @Override
    void doIt() {
        super.doIt();
    }

    @Override
    void isWhat() {
        System.out.println("leaf checkbox.");
    }
}

class Window extends ContainerComponent{
    @Override
    void doIt() {
        System.out.println("window do.");
        super.doIt();
    }

    @Override
    void isWhat() {
        System.out.println("container window");
    }
}

class MidBoard extends ContainerComponent{

    @Override
    void isWhat() {
        System.out.println("container mid-board");
    }

    @Override
    void doIt() {
        System.out.println("mid-board do.");
        super.doIt();
    }
}