package p11_Cat_Lady;

import java.util.ArrayList;
import java.util.List;

public class Cat {
    private String name;
    private List<String> breeds;

    public Cat(String name){
        this.name = name;
        this.breeds = new ArrayList<>();
    }
    public Cat(){

    }
    public String getName(){
        return this.name;
    }
}
