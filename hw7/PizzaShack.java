import java.util.Set;
import java.util.PriorityQueue;
import java.util.Comparator;
/**
 * Class Pizza Shack extends Abstract Pizzeria, is a sophisticated
 * pizza place that delivers based on price and ability to pay.
 *
 * @author Sunny Patel
 * @version 1.0
 */
public class PizzaShack extends AbstractPizzeria {
    /**
     * Creates the Pizza Shack object given the menu.
     *
     * @param menu
     */
    public PizzaShack(Set<Order> menu) {
        this.name = "Pizza Shack";
        this.menu = menu;
        Comparator<Customer> byAbilityToPay = (x, y) ->
            (y.getMoney() - y.getOrder().getCost())
            - (x.getMoney() - x.getOrder().getCost());
        Comparator<Customer> byPrice = (x, y) ->
            y.getOrder().getCost() - x.getOrder().getCost();
        customers = new PriorityQueue<Customer>(
            byAbilityToPay.thenComparing(byPrice));
    }
}