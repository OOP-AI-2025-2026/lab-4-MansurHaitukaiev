package ua.opnu.java.inheritance.bill;

public class DiscountBill extends GroceryBill {
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill(Employee clerk, boolean regularCustomer) {
        super(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    @Override
    public void add(Item i) {
        super.add(i);
        if (regularCustomer && i.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    @Override
    public double getTotal() {
        double total = super.getTotal();
        if (regularCustomer) {
            double discountedTotal = total - discountAmount;
            return Math.rint(discountedTotal * 100.0) / 100.0;
        } else {
            return total;
        }
    }

    public int getDiscountCount() {
        return discountCount;
    }

    public double getDiscountAmount() {
        return discountAmount;
    }

    public double getDiscountPercent() {
        if (!regularCustomer || super.getTotal() == 0.0) return 0.0;
        double percent = 100.0 - (getTotal() * 100.0 / super.getTotal());
        // округлюємо до 13 знаку після коми щоб пройшовся тест
        percent = Math.round(percent * 1_000_000_000_0000.0) / 1_000_000_000_0000.0;
        return percent;
    }
}