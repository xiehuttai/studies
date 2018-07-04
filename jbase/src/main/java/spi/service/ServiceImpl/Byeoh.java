package spi.service.ServiceImpl;

import com.google.auto.service.AutoService;
import spi.service.Bye;

@AutoService(Bye.class)
public class Byeoh implements Bye{
    public String sayBye() {
        return "bye bye oh .";
    }
}
