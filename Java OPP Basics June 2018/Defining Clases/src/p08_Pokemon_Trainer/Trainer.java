package p08_Pokemon_Trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private static final int DEFAULT_BADGES = 0;

    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public Trainer(String name){
        this.name = name;
        this.numberOfBadges = DEFAULT_BADGES;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void addPokemon(Pokemon pokemon){
        this.pokemons.add(pokemon);
    }

    public void addBadge(){
        this.numberOfBadges++;
    }
    public void removePokemon(Pokemon pokemon){
        this.pokemons.remove(pokemon);
    }
    public boolean isContainElement(String element){
        return this.getPokemons().stream()
                .anyMatch(pokemon -> pokemon.getElement().equals(element));
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size());
    }
}
