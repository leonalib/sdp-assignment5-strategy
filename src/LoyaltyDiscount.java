import java.math.BigDecimal;

public final class LoyaltyDiscount implements DiscountStrategy {
    private static final BigDecimal PRICE_FACTOR = new BigDecimal("0.80");

    @Override
    public BigDecimal apply(BigDecimal subtotal) {
        return subtotal.multiply(PRICE_FACTOR);
    }
}
