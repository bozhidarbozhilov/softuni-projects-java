package database;

public class Person {
    private Integer id;
    private String name;

    public Person(Integer id, String name) {
        this.setId(id);
        this.name = name;
    }

    public Integer getId() {
        if(this.id == null){
            return -1;
        }
        return this.id;
    }

    private void setId(Integer id){
        this.id = id;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        return this.getName().equals(((Person)obj).getName()) && this.getId().equals(((Person) obj).getId());
    }
}
