package create._05prototype;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        /**
         * 原型模式
         */
        PersonPrototype sanmo = new PersonPrototype("sanmo", 1, new Address("hb", "china"));
        PersonPrototype cloneSanmo = sanmo.clone();

        System.out.println(sanmo.equals(cloneSanmo));
        System.out.println(sanmo.getAddress().equals(cloneSanmo.getAddress()));

        /**
         * 原型管理
         */
        PrototypeManager prototypeManager = PrototypeManager.getInstance();

        PersonPrototype person1 = prototypeManager.getPerson();
        PersonPrototype person2 = prototypeManager.getPerson();
        System.out.println(person1);
        System.out.println(person2);
        System.out.println(person1==person2);

        AnimalPrototype animal1 = prototypeManager.geAnimal();
        AnimalPrototype animal2 = prototypeManager.geAnimal();
        System.out.println(animal1);
        System.out.println(animal2);
        System.out.println(animal1==animal2);
    }

}

class PersonPrototype implements Cloneable {

    private String name;

    private int age;

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public PersonPrototype clone()  {
        PersonPrototype clone = null;
        try {
            clone = (PersonPrototype) super.clone();
            Address a = address.clone();
            clone.setAddress(a);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return clone;
    }

    public PersonPrototype(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public PersonPrototype() {
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
        return "PersonPrototype{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address=" + address +
                '}';
    }
}

class Address implements Cloneable {

    @Override
    public String toString() {
        return "Address{" +
                "region='" + region + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    private String region;

    private String country;

    @Override
    protected Address clone() {
        Address address=null;
        try {
            address=(Address) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return address;
    }

    public Address() {
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address(String region, String country) {
        this.region = region;
        this.country = country;
    }
}

class AnimalPrototype implements Cloneable{

    private String type;

    private String name;

    @Override
    protected AnimalPrototype clone() {
        AnimalPrototype animalPrototype =null;
        try {
            animalPrototype = (AnimalPrototype)super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return animalPrototype;
    }

    @Override
    public String toString() {
        return "AnimalPrototype{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AnimalPrototype() {
    }

    public AnimalPrototype(String type, String name) {
        this.type = type;
        this.name = name;
    }
}

class PrototypeManager{

    private final HashMap prototypes= new HashMap();

    private PrototypeManager() {
        prototypes.put("person",new PersonPrototype("sanmo",1,new Address("hb","china")));
        prototypes.put("animal",new AnimalPrototype("dog","ww"));
    }

    private static class Holder{
        private static final PrototypeManager INSTANCE= new PrototypeManager();
    }


    public static PrototypeManager getInstance(){
        return Holder.INSTANCE;
    }

    public PersonPrototype getPerson(){
        PersonPrototype person = (PersonPrototype)prototypes.get("person");
        return person.clone();
    }

    public AnimalPrototype geAnimal(){
        AnimalPrototype animal = (AnimalPrototype)prototypes.get("animal");
        return animal.clone();
    }

}