package reflection_tutorial;

@CodeAuthor(name="Robert")
public class Person {
    private int id;
    private String name;

    public Person() {
        this.id = -1;
        name = "no name";
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    private void hello() {
        System.out.println("HELLO MY FRIEND");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
