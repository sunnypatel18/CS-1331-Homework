/**
 * Represents a Pokemon object. Each has a number, a name, and two elemental
 * types, chosen from the PokemonType enumeration.
 *
 * @author  Joe Rossi
 * @version 1.0
 */
public class Pokemon implements Comparable<Pokemon> {

    // ------Instance data here------
    private int number;
    private String name;
    private PokemonType elementone;
    private PokemonType elementtwo;
    private String[] array = {"NORMAL", "FIRE", "WATER", "ELECTRIC", "GRASS"
        , "ICE", "FIGHTING", "POISON", "GROUND", "FLYING", "PSYCHIC", "BUG"
        , "ROCK", "GHOST", "DRAGON", "NONE"};
    /**
     * Constructs a Pokemon object
     *
     * @param num   this Pokemon's unique number
     * @param name  this Pokemon's name
     * @param p this Pokemon's primary type
     * @param s this Pokemon's secondary type
     */
    public Pokemon(int num, String name, PokemonType p, PokemonType s) {
        this.number = num;
        this.name = name;
        this.elementone = p;
        this.elementtwo = s;
    }

    @Override
    public int compareTo(Pokemon o) {
        return number - o.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        return ((Pokemon) o).getNumber() == number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return String.format("%-4s %-12s %-9s %-9s"
            , number, name, array[elementone.ordinal()]
            , array[elementtwo.ordinal()]);
    }

    /**
     * @return  the name of this Pokemon
     */
    public String getName() {
        return name;
    }

    /**
     * @return  the unique number of this Pokemon
     */
    public int getNumber() {
        return number;
    }

    /**
     * @return  the primary type of this Pokemon
     */
    public PokemonType getPrimaryType() {
        return elementone;
    }

    /**
     * @return  the secondary type of this Pokemon
     */
    public PokemonType getSecondaryType() {
        return elementtwo;
    }
}
