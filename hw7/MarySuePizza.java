import java.util.Set;
import java.util.PriorityQueue;
/**
 * Class Mary Sue Pizza extends Abstract Pizzeria, is a cunning pizza place that
 * delivers in the order of most expensive price.
 *
 * @author Sunny Patel
 * @version 1.0
 */
public class MarySuePizza extends AbstractPizzeria {
    /**
     * Creates the Mary Sue object given the menu.
     *
     * @param menu
     */
    public MarySuePizza(Set<Order> menu) {
        this.name = "Mary Sue Pizza";
        this.menu = menu;

        customers = new PriorityQueue<Customer>(
            (x, y) -> y.getOrder().getCost() - x.getOrder().getCost()
        );
    }
}