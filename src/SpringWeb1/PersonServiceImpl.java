package SpringWeb1;

public class PersonServiceImpl implements PersonService {
    private String name;
    private int age;

    public PersonServiceImpl(String name) {
        this.name = name;
    }

    public PersonServiceImpl(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public void sayHello() {
        System.out.println("name : " + name);
        System.out.println("age : " + age);
    }
}
