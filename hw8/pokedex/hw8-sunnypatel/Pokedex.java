/**
 * Represents a Pokedex - basically a Pokemon encyclopedia that adds new entries
 * when you encounter a Pokemon for the first time.
 * It also provides methods for organizing its information in useful ways.
 *
 * @author Joe Rossi
 * @version 1.0
 */
public class Pokedex {

    // ------ Instance data here ------
    private MySortedSet<Pokemon> pokemonSet;
    /**
     * Constructs a Pokedex object by setting up the sorted set of Pokemon
     */
    public Pokedex() {
        pokemonSet = new MySortedSet<Pokemon>();
    }

    @Override
    public String toString() {
        return pokemonSet.toString();
    }

    /**
     * Adds a Pokemon to the sorted set
     *
     * @param p the Pokemon to be added
     * @return true if the pokemon was not already in the set, false otherwise
     */
    public boolean add(Pokemon p) {
        return pokemonSet.add(p);
    }

    /**
     * Returns the number of Pokemon in the Pokedex
     *
     * @return  the number of Pokemon in the Pokedex
     */
    public int countPokemon() {
        return pokemonSet.size();
    }

    /**
     * Clear the Pokedex and start over
     */
    public void clear() {
        pokemonSet.clear();
    }

    /**
     * Returns a set of alphabetized Pokemon, using a lambda expression
     *
     * @return  the alphabetized set
     */
    public MySortedSet<Pokemon> listAlphabetically() {
        return pokemonSet.sort((x, y) -> x.getName().compareTo(y.getName()));
    }

    /**
     * Returns a set of Pokemon grouped by type, using a lambda expression
     *
     * @return  the grouped by primary type set
     */
    public MySortedSet<Pokemon> groupByPrimaryType() {
        return pokemonSet.sort((x, y) -> x.getPrimaryType().ordinal()
            - y.getPrimaryType().ordinal());
    }

    /**
     * Returns a set of all Pokemon of type t
     *
     * @param t the type we want listed
     * @return  the set of all Pokemon in the Pokedex of type t
     */
    public MySortedSet<Pokemon> listByType(PokemonType t) {
        return pokemonSet.filter((x) -> x.getPrimaryType() == t
            || x.getSecondaryType() == t);
    }

    /**
     * Returns a set of Pokemon with numbers in the range [start, end]
     *
     * @param start the first number in the new set
     * @param end   the last number in the new set
     * @return  the set containing all Pokemon in the Pokedex from [start, end]
     */
    public MySortedSet<Pokemon> listRange(int start, int end) {
        int begin = 0;
        int finish = 0;
        Pokemon beginning = null;
        Pokemon ending = null;
        boolean flag = true;
        for (Pokemon p : pokemonSet) {
            if (p.getNumber() >= start && flag) {
                beginning = p;
                flag = false;
            }
            if (p.getNumber() >= end + 1) {
                ending = p;
                return pokemonSet.subSet(beginning, ending);
            }
        }
        if (beginning != null && ending == null) {
            return pokemonSet.tailSet(beginning);
        }
        return null;
    }
}
