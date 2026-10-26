import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public final class DiscountCalculator {
    private DiscountStrategy strategy;

    public DiscountCalculator(DiscountStrategy strategy) {
        setStrategy(strategy);
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = Objects.requireNonNull(strategy, "Strategy must not be null");
    }

    public BigDecimal calculate(BigDecimal subtotal) {
        Objects.requireNonNull(subtotal, "Subtotal must not be null");
        if (subtotal.signum() < 0) {
            throw new IllegalArgumentException("Subtotal must not be negative");
        }
        return strategy.apply(subtotal).setScale(2, RoundingMode.HALF_UP);
    }
}
