package rxjava;

import java.util.ArrayList;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        Main application = new Main();
        run("Example #1 - Infer to Type String",application::exampleOne);
        run("Example #2 - Infer to Type int",application::exampleTwo);
        run("Example #3 - Infer to Type double",application::exampleThree);
        run("Example #4 - Infer to Type ArrayList",application::exampleFour);
        run("Example #5 - Parameter Passing",application::exampleFive);
        run("Example #6 - for Loops",application::exampleSix);
    }

    /* can't specify var in parameter lists or as return types
    public int passByVar(var y) {
        return y;
        }
    public var returnVar(int y) {
        return y;
        }
    */

    private void exampleOne() {
        var string = "Hello, World!";

        out.println("statement:");
        out.println("var string = \"Hello, World!\";\n");

        out.println("output:");
        out.println("string = " + string);
        out.println("'string' is inferred to be type " + ((Object)string).getClass().getName() + ".\n");
    }

    private void exampleTwo() {
        var x = 9;

        out.println("statement:");
        out.println("var x = 9;\n");

        out.println("output:");
        out.println("x = " +  x);
        out.println("'x' is inferred to be type " + ((Object)x).getClass().getName() + ".\n");
    }

    private void exampleThree() {
        var x = 9.9;

        out.println("statement:");
        out.println("var x = 9.9;\n");

        out.println("output:");
        out.println("x = " + x);
        out.println("'x' is inferred to be type " + ((Object)x).getClass().getName() + ".\n");
    }

    private void exampleFour() {
        var list = new ArrayList<String>();
        list.add("Hello!");
        list.add("World!");

        out.println("statements:");
        out.println("var list = new java.util.ArrayList<String>();");
        out.println("list.add(\"Hello!\");");
        out.println("list.add(\"World!\");\n");

        out.println("output:");
        out.println("list = " + list);
        out.println("'list', is inferred to be type " + ((Object)list).getClass().getName());
    }

    private void exampleFive() {
        var x = 10;
        var y = 20;
        var z = getSum(x,y);

        out.println("statements:");
        out.println("var x = 10;");
        out.println("var y = 20");
        out.println("var z = getSum(x,y);\n");

        out.println("output:");
        out.println("x = " + x);
        out.println("y = " + y);
        out.println("z = " + z);
    }

    private void exampleSix() {
        out.println("for loop:");
        out.println("for(var i = 0;i < 10;++i) {");
        out.println("    out.println(\"i = \" + i);");
        out.println("    }\n");
        out.println("output:");
        for(var i = 0;i < 10;++i) {
            out.println("i = " + i);
        }
    }

    private int getSum(int x,int y) {
        return x + y;
    }

    private static void run(String name,Runnable method) {
        System.out.println();
        System.out.println("*** " + name + " Demo ***");
        method.run();
    }
}