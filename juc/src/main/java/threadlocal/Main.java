package threadlocal;

public class Main {


    public static void main(String[] args) {

        SequenceA sequenceA = new SequenceA();

        ClientThread clientThread1A = new ClientThread(sequenceA);
        ClientThread clientThread2A = new ClientThread(sequenceA);
        ClientThread clientThread3A = new ClientThread(sequenceA);

        clientThread1A.start();
        clientThread2A.start();
        clientThread3A.start();


        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("---------------------");


        SequenceB sequenceB = new SequenceB();

        ClientThread clientThread1B = new ClientThread(sequenceB);
        ClientThread clientThread2B = new ClientThread(sequenceB);
        ClientThread clientThread3B = new ClientThread(sequenceB);

        clientThread1B.start();
        clientThread2B.start();
        clientThread3B.start();


    }

}
