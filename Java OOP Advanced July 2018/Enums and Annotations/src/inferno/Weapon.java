package inferno;

@CustomClassAnnotation(author="Pesho", revision = 3,
        description = "Used for Java OOP Advanced course - Enumerations and Annotations.",
        reviewers = {"Pesho", "Svetlio"})
public class Weapon implements Comparable<Weapon>{
    private static final int INCREASE_MIN_DAMAGE_BY_STRENGTH = 2;
    private static final int INCREASE_MAX_DAMAGE_BY_STRENGTH = 3;
    private static final int INCREASE_MIN_DAMAGE_BY_AGILITY = 1;
    private static final int INCREASE_MAX_DAMAGE_BY_AGILITY = 4;

    private String name;
    private WeaponEnum type;
    private int minDamage;
    private int maxDamage;
    private Gem[] sockets;
    private int strength;
    private int agility;
    private int vitality;

    public Weapon(String name, String type) {
        this.setName(name);
        this.setType(WeaponEnum.valueOf(type));
        this.setMinDamage(this.type.getMinDamage());
        this.setMaxDamage(this.type.getMaxDamage());
        this.sockets = new Gem[this.type.getSockets()];
        this.strength = 0;
        this.agility = 0;
        this.vitality = 0;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WeaponEnum getType() {
        return this.type;
    }

    public void setType(WeaponEnum type) {
        this.type = type;
    }

    public int getMinDamage() {
        return minDamage;
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }

    public int getMaxDamage() {
        return maxDamage;
    }

    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }

    public int getStrength() {
        return this.strength;
    }

    public void setStrength(int strength) {
        this.strength += strength;
    }

    public int getAgility() {
        return this.agility;
    }

    public void setAgility(int agility) {
        this.agility += agility;
    }

    public int getVitality() {
        return this.vitality;
    }

    public void setVitality(int vitality) {
        this.vitality += vitality;
    }

    private void decreaseMinDamage(Gem gem){
        this.setMinDamage(this.getMinDamage()
                - ((gem.getStrength() * INCREASE_MIN_DAMAGE_BY_STRENGTH)
                + (gem.getAgility() * INCREASE_MIN_DAMAGE_BY_AGILITY)));
    }
    private void increaseMinDamage(Gem gem){
        this.setMinDamage(this.getMinDamage()
                + ((gem.getStrength() * INCREASE_MIN_DAMAGE_BY_STRENGTH)
                + (gem.getAgility() * INCREASE_MIN_DAMAGE_BY_AGILITY)));
    }

    private void decreaseMaxDamage(Gem gem){
        this.setMaxDamage(this.getMaxDamage()
                - ((gem.getStrength() * INCREASE_MAX_DAMAGE_BY_STRENGTH)
                + (gem.getAgility() * INCREASE_MAX_DAMAGE_BY_AGILITY)));
    }

    private void increaseMaxDamage(Gem gem){
        this.setMaxDamage(this.getMaxDamage()
                + ((gem.getStrength() * INCREASE_MAX_DAMAGE_BY_STRENGTH)
                + (gem.getAgility() * INCREASE_MAX_DAMAGE_BY_AGILITY)));
    }



    public void addGemToSocket(int socket, Gem gem){
        if(socket>=0 && socket<this.sockets.length){
            if(this.sockets[socket] != null){
                this.removeGemFromSocket(socket);
            }
            this.setStrength(gem.getStrength());
            this.setVitality(gem.getVitality());
            this.setAgility(gem.getAgility());
            this.increaseMinDamage(gem);
            this.increaseMaxDamage(gem);
            this.sockets[socket] = gem;
        }

    }

    public void removeGemFromSocket(int socket){
        if(socket>=0 && socket<this.sockets.length && this.sockets[socket] != null){
            Gem gem = this.sockets[socket];
            this.decreaseMinDamage(gem);
            this.decreaseMaxDamage(gem);
            this.setStrength(-gem.getStrength());
            this.setVitality(-gem.getVitality());
            this.setAgility(-gem.getAgility());

            this.sockets[socket] = null;
        }
    }

    public double calcItemLevel(){
        return ((this.getMinDamage()+this.getMaxDamage())/2.0)
                +this.getStrength() + this.getAgility() + this.getVitality();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append(this.getName()).append(": ")
                .append(this.getMinDamage()).append("-").append(this.getMaxDamage()).append(" ").append("Damage")
                .append(", ").append("+")
                .append(this.getStrength())
                .append(" ").append("Strength")
                .append(", ").append("+").append(this.getAgility()).append(" ").append("Agility")
                .append(", ").append("+").append(this.getVitality()).append(" ").append("Vitality");


        return output.toString();
    }

    @Override
    public int compareTo(Weapon o) {
        double firstWeaponItemLevel = this.calcItemLevel();
        double secondWeaponItemLevel = o.calcItemLevel();
        double difference = firstWeaponItemLevel - secondWeaponItemLevel;
        if(difference<0){
            return -1;
        }else if(difference>0){
            return 1;
        }
        return 0;
    }
}
