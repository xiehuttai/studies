package optional;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        User empty=null;
        Optional<User> emptyUser = Optional.ofNullable(empty);
        User orElse = emptyUser.orElse(new User("orElse", 0));
        System.out.println(orElse);
        System.out.println(emptyUser.isPresent());

        User user = new User("user", 1);
        Optional<User> optionalUser = Optional.of(user);
        User getUser = optionalUser.get();
        System.out.println(getUser);

    }
}

class User{

    private String name;

    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "name:"+name+",age:"+age;
    }
}