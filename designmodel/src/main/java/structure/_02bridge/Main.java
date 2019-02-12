package structure._02bridge;


/**
 * 桥接模式，多维度独立扩展，解耦
 */
public class Main {

    public static void main(String[] args) {

        DataImpl data = new MysqlData();

        OutFile outFile = new TxtFile(data);

        outFile.readFile();

    }

}


interface DataImpl{
    void getData();
}

abstract class OutFile{

    DataImpl dataImpl;

    public OutFile(DataImpl dataImpl) {
        this.dataImpl = dataImpl;
    }

    abstract void readFile();

}


class TxtFile extends OutFile{


    public TxtFile(DataImpl dataImpl) {
        super(dataImpl);
    }

    @Override
    void readFile() {
        dataImpl.getData();
        System.out.println("txt .");
    }

}

class PdfFile extends OutFile{


    public PdfFile(DataImpl dataImpl) {
        super(dataImpl);
    }

    @Override
    void readFile() {
        dataImpl.getData();
        System.out.println("pdf .");
    }
}

class MysqlData implements DataImpl{

    @Override
    public void getData() {
        System.out.println("mysql");
    }
}

class Db2Data implements DataImpl{

    @Override
    public void getData() {
        System.out.println("db2");
    }
}