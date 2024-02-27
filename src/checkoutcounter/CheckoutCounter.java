package checkoutcounter;

import java.util.Scanner;

public class CheckoutCounter {
    private double weight;
    private double unit_price;
    private double tax;

    public CheckoutCounter(double w, double u, double t) {
        weight = w;
        unit_price = u;
        tax = t;
    }

    /* SETTERS */
    public void setWeight(double w) {
        weight = w;
    }

    public void setUnitPrice(double u) {
        unit_price = u;
    }

    public void setTax(double t) {
        tax = t;
    }

    /* GETTERS */
    public double getWeight() {
        return weight;
    }

    public double getUnitPrice() {
        return unit_price;
    }

    public double getTax() {
        return tax;
    }

    /* Computation */
    public double computeNetPrice() {
        return weight * unit_price;
    }

    public double computeTax() {
        double netPrice = computeNetPrice();
        return netPrice * tax / 100;
    }

    public double computeTotalAmount() {
        double netPrice = computeNetPrice();
        return netPrice + computeTax();
    }

    public double computeChange(double cash) {
        return cash - computeTotalAmount();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the weight (kg) of the potatoes that you to buy:");
        double weight = sc.nextDouble();

        CheckoutCounter item = new CheckoutCounter(weight, 1.99, 20); // 1.99 is the unit price, 20 is the tax
        System.out.println("Cash (€) tendered:");
        double cash = sc.nextDouble();

        double total = item.computeTotalAmount();
        double change = item.computeChange(cash);

        System.out.println("\n==================== Receipt ====================");
        System.out.printf("%-20s: %.3f kg\n", "Weight (kg) purchased", item.getWeight());
        System.out.printf("%-20s: $%.2f\n", "Unit Price (€)", item.getUnitPrice());
        System.out.printf("%-20s: $%.2f\n", "Net Price (€)", item.computeNetPrice());
        System.out.printf("%-20s: $%.2f (20%%)\n", "Tax (€)", item.computeTax());
        System.out.printf("%-20s: $%.2f\n", "Total Price (€)", total);
        System.out.println("-------------------------------------------------");
        System.out.printf("%-20s: $%.2f\n", "Cash (€) Tendered", cash);
        System.out.printf("%-20s: $%.2f\n", "Change (€)", change);
        System.out.println("=================================================");

        if (change < 0) {
          System.out.println("=================================================");
          System.out.println("Insufficient cash. Please pay the remaining amount.");
        }
        else {
          System.out.println("=================================================");
          System.out.println("Thank you for shopping with us!");
        }

        sc.close();
    }
}
