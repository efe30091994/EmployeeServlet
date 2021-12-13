package entity;

public class ProgrammerEntity {
    private int id;
    private String name;
    private int age;
    private String level;

    public ProgrammerEntity(){}
    public ProgrammerEntity(int id, String name, int age, String level){
        this.id = id;
        this.name = name;
        this.age = age;
        this.level = level;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}
