package runtime;

/**
 * 得到cpu数
 */
public class Main {

    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();

        int availableProcessors = runtime.availableProcessors();
        long maxMemory = runtime.maxMemory();
        long freeMemory = runtime.freeMemory();

        System.out.println("cpus:"+availableProcessors);
        System.out.println("maxMemory:"+maxMemory/1024/1024);
        System.out.println("freeMemory:"+freeMemory/1024/1024);

        runtime.addShutdownHook(new Thread(){
            @Override
            public void run() {
                System.out.println("shutdown hook ...");
            }
        });

    }

}
