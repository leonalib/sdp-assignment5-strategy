import java.math.BigDecimal;

public final class NoDiscount implements DiscountStrategy {
    @Override
    public BigDecimal apply(BigDecimal subtotal) {
        return subtotal;
    }
}
