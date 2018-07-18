package petClinic.entities;

public class Room {
    private int number;
    private Pet pet;



    public Room(int number) {
        this.setNumber(number);
        this.pet = null;
    }

    public void enterPet(Pet pet){
        this.pet = pet;
    }

    public void releasePet(){
        this.pet = null;
    }

    public boolean isEmpty(){
        return pet==null;
    }

    public Pet getPet(){
        return this.pet;
    }
    public int getNumber() {
        return number;
    }

    private void setNumber(int number) {
        if(number<1 || number>101){
            throw new IllegalArgumentException("Invalid operation!");
        }
        this.number = number;
    }
}
