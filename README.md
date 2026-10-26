# Assignment 5 - Strategy Pattern

Topic: Coffee shop discounts.

A small Java program calculates the final order price using different discount
rules. It uses the same calculator and changes its strategy at runtime.

## Pattern components

- Strategy interface: `DiscountStrategy` defines `apply(subtotal)`.
- Concrete strategies: `NoDiscount` returns the full price, `StudentDiscount`
  gives a 10% discount, and `LoyaltyDiscount` gives a 20% discount.
- Context: `DiscountCalculator` stores a `DiscountStrategy`, delegates the
  calculation to it, and supports switching through `setStrategy`.
- Client: `Main` creates the strategies and selects them for the same calculator.

The context has no `if` or `switch` for choosing a strategy. Its only `if` checks
for a negative order price. Prices use `BigDecimal` and are rounded to two
decimal places with `HALF_UP`.

## Five Clean Code principles

1. Polymorphism instead of branching: `calculate` calls `strategy.apply`
   without checking which discount class is selected.
2. Meaningful names: `StudentDiscount`, `LoyaltyDiscount`, and `calculate`
   explain the purpose of each class or method.
3. Single responsibility: each strategy contains one discount rule.
   `Main` handles the demo output, while the calculator delegates the calculation.
4. Depend on abstractions: `DiscountCalculator` knows only `DiscountStrategy`.
   It does not know the concrete discount classes or their rates.
5. Open for extension: `LoyaltyDiscount` adds a third rule using the same
   interface. It requires no changes to `DiscountCalculator`, `NoDiscount`, or
   `StudentDiscount`. Only the client selects the new strategy.

## Run

Use JDK 17 or newer. From the project folder:

```sh
javac --release 17 -d out src/*.java
java -cp out Main
```

In IntelliJ IDEA, mark `src` as Sources Root and run `Main.java`.

## Output

```text
Coffee shop discounts
Order price: 1000.00 KZT
No discount: 1000.00 KZT
Student discount (10%): 900.00 KZT
Loyalty discount (20%): 800.00 KZT
```
