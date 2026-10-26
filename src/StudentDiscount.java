import java.math.BigDecimal;

public final class StudentDiscount implements DiscountStrategy {
    private static final BigDecimal PRICE_FACTOR = new BigDecimal("0.90");

    @Override
    public BigDecimal apply(BigDecimal subtotal) {
        return subtotal.multiply(PRICE_FACTOR);
    }
}
