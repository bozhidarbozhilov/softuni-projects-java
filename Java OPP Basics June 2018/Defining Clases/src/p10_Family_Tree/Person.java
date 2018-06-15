package p10_Family_Tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

public class Person {
    private String name;
    private String birthDate;
    private HashSet<Parent> parents;
    private HashSet<Child> children;

    public Person(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.parents = new LinkedHashSet<>();
        this.children = new LinkedHashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public HashSet<Parent> getParents() {
        return this.parents;
    }

    public HashSet<Child> getChildren() {
        return this.children;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void addChild(Child child){
        this.children.add(child);
    }
    public void addParent(Parent parent){
        this.parents.add(parent);
    }
}
