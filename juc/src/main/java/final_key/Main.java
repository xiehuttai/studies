package final_key;

public class Main {

    // final
    // JMM禁止编译器把final域的写重排序到构造函数之外。
    // 编译器会在final域的写之后，构造函数return之前，插入一个storestore屏障。

    public static void main(String[] args){
        FinalExample f = new FinalExample();
        new WThread(f).start();
        new RThread(f).start();
    }

}
