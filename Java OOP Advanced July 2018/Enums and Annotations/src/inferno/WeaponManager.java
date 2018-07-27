package inferno;

import java.util.LinkedHashMap;
import java.util.Map;

public class WeaponManager {
    private Map<String, Weapon> weapons;
    private CustomClassAnnotation weaponAnnotation;


    public WeaponManager() {
        this.weapons = new LinkedHashMap<>();
        this.weaponAnnotation = Weapon.class.getAnnotation(CustomClassAnnotation.class);
    }

    public void createWeapon(String name, String type){
        weapons.putIfAbsent(name, new Weapon(name, type));
    }

    public void addGemToWeapon(String name, int index, String gemType){
        Gem gem = Gem.valueOf(gemType);
        this.weapons.get(name).addGemToSocket(index, gem);
    }

    public Weapon getWeapon(String name){
        return this.weapons.get(name);
    }

    public void printWeapon(String name){
        System.out.print(this.weapons.get(name));
    }


    public void removeWeapon(String name, int index) {
        this.weapons.get(name).removeGemFromSocket(index);
    }

    public Weapon getBiggerWeapon(String firstWeapon, String secondWeapon){
        int compare = this.weapons.get(firstWeapon).compareTo(this.weapons.get(secondWeapon));
        if(compare>=0){
            return this.weapons.get(firstWeapon);
        }
        return this.weapons.get(secondWeapon);
    }

    private CustomClassAnnotation getWeaponAnnotation() {
        return weaponAnnotation;
    }

    public String getAnnotationAuthor(){
        return this.weaponAnnotation.author();
    }

    public int getAnnotationRevision(){
        return this.weaponAnnotation.revision();
    }

    public String getAnnotationDescription(){
        return this.weaponAnnotation.description();
    }

    public String getAnnotationReviewers(){
        return String.join(", ",this.weaponAnnotation.reviewers());
    }

}
