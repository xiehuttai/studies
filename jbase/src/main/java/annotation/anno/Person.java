package annotation.anno;

public class Person {

    @Put(isId =true ,value = 101)
    public int id;

    @Put(name = "sanmo")
    public String name;

    @Put(desc = "male")
    public String desc (String desc){
        System.out.println(desc);
        return desc;
    }

}
