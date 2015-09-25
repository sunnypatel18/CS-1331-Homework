/**
 * Customer class contains an order
 *
 * @author Sunny Patel
 * @version 1.0
 */
public class Customer {
    private Order order;
    private final int money = (int) (Math.random() * 30) + 5;

    /**
     * Creates the customer object
     *
     * @param Order that the customer makes
     */
    public Customer(Order order) {
        this.order = order;
    }
    /**
     * Determines if the customer can pay
     *
     * @return if money is greater than or equal to cost
     */
    public boolean canPay() {
        return money >= order.getCost();
    }
    /**
     * Returns the order object
     *
     * @return order
     */
    public Order getOrder() {
        return order;
    }
    /**
     * Returns the amount of money the customer has
     *
     * @return money
     */
    public int getMoney() {
        return money;
    }
}