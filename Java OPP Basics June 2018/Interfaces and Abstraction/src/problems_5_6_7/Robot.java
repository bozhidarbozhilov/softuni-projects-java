package problems_5_6_7;

public class Robot implements Identifable{
    private String name;
    private String id;

    public Robot(String name, String id) {
        this.setName(name);
        this.setId(id);
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
