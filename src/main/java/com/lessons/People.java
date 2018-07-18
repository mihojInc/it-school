package src.main.java.com.lessons;

public class People {
    Long id;
    int age;
    String name;
    Role role;

    public People(Long id, int age, String name, Role role) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "People{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                ", role=" + role +
                '}';
    }
}
