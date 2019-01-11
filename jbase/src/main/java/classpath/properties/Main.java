package classpath.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main {

    public static void main(String[] args) {

        Properties prop = new Properties();
        InputStream in = Main.class.getClassLoader().getResourceAsStream("application.properties");
            try {
                if(in!=null){
                    prop.load(in);
                    for (final String name : prop.stringPropertyNames())
                        System.out.println(name+"="+prop.getProperty(name));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

}
