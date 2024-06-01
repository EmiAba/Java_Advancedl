package F12_Classes_Exc._06Pokemon_Trainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int badges;
    List<Pokemon> pokemons;

    public Trainer(String name) {
        this.name = name;
        this.badges = 0;
        this.pokemons = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBadges() {
        return badges;
    }

    public void setBadges(int badges) {
        this.badges = badges;
    }

    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<Pokemon> pokemons) {
        this.pokemons = pokemons;
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public void checkIfPokemonExistByElement(String element) {

        boolean isAtLeastOneExist = false;

        for (Pokemon pokemon : pokemons) {
            if (pokemon.getElement().equals(element)) {
                isAtLeastOneExist = true;
                break;
            }
        }
        if (isAtLeastOneExist) {
            badges++;
        } else {
            for (Pokemon pokemon : pokemons) {
                pokemon.loosesHealth();

            }
            pokemons.removeIf(pokemon -> pokemon.getHealth()<=0);
        }
    }


    @Override
    public String toString() {
        //"{TrainerName} {Badges} {NumberOfPokemon}".
        return String.format("%s %d %d", name, badges, pokemons.size());
    }
}
