import java.util.HashSet;
/**
 * Order class extends hashset ingredient
 *
 * @author Sunny Patel
 * @version 1.0
 */
public class Order extends HashSet<Ingredient> {
    /**
     * Loops through ingredients and returns sum of cost
     *
     * @return cost
     */
    public int getCost() {
        int cost = 0;
        for (Ingredient i : this) {
            cost += i.getPrice();
        }
        return cost;
    }
    /**
     * Compares teo objects to determine if the order is same.
     *
     * @param Object other we are comparing too
     * @return boolean if they are the same
     */
    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        if (other == this) {
            return true;
        }
        if (!(other instanceof Order)) {
            return false;
        }
        if (((Order) other).size() != this.size()) {
            return false;
        }
        int has = 0;
        for (Ingredient o : this) {
            for (Ingredient a : (Order) (other)) {
                if (a == o) {
                    has++;
                }
            }
        }
        return has == this.size();
    }
}