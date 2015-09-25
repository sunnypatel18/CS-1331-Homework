import java.util.Set;
import java.util.Queue;
/**
 * Abstract Pizzeria class implements Pizzeria, defines every method in Pizzeria
 *
 * @author Sunny Patel
 * @version 1.0
 */
public abstract class AbstractPizzeria implements Pizzeria {
    protected String name;
    private int ordersReceived;
    private int ordersDelivered;
    private int ordersAttempted;
    private double revenue;
    protected Set<Order> menu;
    protected Queue<Customer> customers;

    /**
     * Tells the pizzeria to place an order with a Customer
     *
     * @param customer Customer who wants a pizza
     */
    public void placeOrder(Customer customer) {
        ordersReceived++;
        customers.add(customer);
    }

    /**
     * Returns the cheapest menu item based on price
     *
     * @return cheapest menu item
     */
    public Order getCheapestMenuItem() {
        Order minPrice = null;
        for (Order o : menu) {
            if (minPrice == null) {
                minPrice = o;
            }
            minPrice = o.getCost() < minPrice.getCost() ? o : minPrice;
        }
        return minPrice;
    }

    /**
     * Returns the most expensive menu item based on price
     *
     * @return most expensive menu item
     */
    public Order getMostExpensiveMenuItem() {
        Order maxPrice = null;
        for (Order o : menu) {
            if (maxPrice == null) {
                maxPrice = o;
            }
            maxPrice = o.getCost() > maxPrice.getCost() ? o : maxPrice;
        }
        return maxPrice;
    }


    /**
     * Status message of a Pizzeria's performance
     * Should say what percentage of orders have been delivered
     * and what percentage of attempted orders have been delivered
     * along with total revenues
     *
     * @return Message string
     */
    public String status() {
        return "We delivered " + (int) (ordersDelivered * 100 / ordersReceived)
            + "% or our orders! We delivered "
            + (int) (ordersDelivered * 100 / ordersAttempted) + "% of our "
            + "attempted orders and made $" + revenue + "0.";
    }

    /**
     * Pizzeria name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Attempts to deliver an order to a customer.
     * If the customer placed an order that's not on the menu,
     * we don't deliver. If the customer placed an order that is
     * on the menu but he doesn't have enough money to pay,
     * we don't deliver. Otherwise, we deliver to customer
     * and collect our money.
     */
    public void processOrder() {
        ordersAttempted++;
        Customer customer = customers.poll();
        if (customer != null && customer.canPay()
            && menu.contains(customer.getOrder())) {
            ordersDelivered++;
            revenue += customer.getOrder().getCost();
        }
    }
}