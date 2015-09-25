import java.util.Set;
import java.util.ArrayDeque;
/**
 * Class Cascade Pizza extends Abstract Pizzeria, is a normal pizza place that
 * delivers in the order that they are given.
 *
 * @author Sunny Patel
 * @version 1.0
 */
public class CascadePizza extends AbstractPizzeria {
    /**
     * Creates the cascade pizza object given the menu.
     *
     * @param menu
     */
    public CascadePizza(Set<Order> menu) {
        this.name = "Cascade Pizza";
        this.menu = menu;
        customers = new ArrayDeque<Customer>();
    }
}