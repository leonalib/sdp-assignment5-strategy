import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        BigDecimal subtotal = new BigDecimal("1000.00");
        DiscountCalculator calculator = new DiscountCalculator(new NoDiscount());

        System.out.println("Coffee shop discounts");
        System.out.println("Order price: " + subtotal + " KZT");
        System.out.println("No discount: " + calculator.calculate(subtotal) + " KZT");

        calculator.setStrategy(new StudentDiscount());
        System.out.println("Student discount (10%): " + calculator.calculate(subtotal) + " KZT");

        calculator.setStrategy(new LoyaltyDiscount());
        System.out.println("Loyalty discount (20%): " + calculator.calculate(subtotal) + " KZT");
    }
}
