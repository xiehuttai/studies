package create.simplefactory;

public class Main {

    public static void main(String[] args) {

        Pen pencil = SimplePenFactory.getPen("pencil");
        pencil.type();
        pencil.write();

        Pen ballpen = SimplePenFactory.getPen("ballpen");
        ballpen.type();
        ballpen.write();

        Pen pen = SimplePenFactory.getPen("");
        pen.type();
        pen.write();
    }

}


class Pen {

    void write(){
        System.out.println("pen write");
    };

    void type(){
        System.out.println("pen");
    }

}


class Pencil extends Pen{

    @Override
    void write() {
        System.out.println("pencil write");
    }

    @Override
    void type() {
        System.out.println("pencil");
    }

}

class Ballpen extends Pen{
    @Override
    void write() {
        System.out.println("ballpen write");
    }

    @Override
    void type() {
        System.out.println("ballpen");
    }
}


class SimplePenFactory{

    public static Pen getPen(String type){
        if (type.equals("pencil"))
            return new Pencil();
        if (type.equals("ballpen"))
            return new Ballpen();
        return new Pen();
    }
}