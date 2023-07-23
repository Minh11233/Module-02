package Entity;

public class Category {
    private int id;
    private String name;
    private static int count = 0;


    public Category() {
    }
    public Category(String name) {
        this.name = name;
        this.id = ++count;
    }

    public Category(int id) {
        this.id = id;
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
        return "ID catelog: " + id + " - Catelog: " + name;
    }

}
