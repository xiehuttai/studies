package create._02factorymethod;

public class Main {

    public static void main(String[] args) {

        PenFactory penFactory;
        Pen pen;

        penFactory=new BallpenFactory();
        pen=penFactory.createPen();
        pen.write();

        penFactory = new PencilFactory();
        pen=penFactory.createPen();
        pen.write();

    }
}

interface  Pen{
     void write();
}

interface PenFactory{
     Pen createPen();
}

class Ballpen implements Pen{
    @Override
    public void write() {
        System.out.println("write use ballpen .");
    }
}

class Pencil implements Pen{
    @Override
    public void write() {
        System.out.println("write use pencil .");
    }
}


class BallpenFactory implements PenFactory{

    @Override
    public Pen createPen() {
        return new Ballpen();
    }
}

class PencilFactory implements PenFactory{

    @Override
    public Pen createPen() {
        return new Pencil();
    }
}


