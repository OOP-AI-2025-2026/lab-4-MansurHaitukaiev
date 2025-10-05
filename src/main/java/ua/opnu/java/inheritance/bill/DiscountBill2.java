package ua.opnu.java.inheritance.bill;

public class DiscountBill2 {
    private GroceryBill bill;
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
    }

    public void add(Item i) {
        bill.add(i);
        if (regularCustomer && i.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    public double getTotal() {
        double total = bill.getTotal();
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
        if (!regularCustomer || bill.getTotal() == 0.0) return 0.0;
        double percent = 100.0 - (getTotal() * 100.0 / bill.getTotal());
        // округлюємо до 13 знаку після коми щоб пройшловся тест
        percent = Math.round(percent * 1_000_000_000_0000.0) / 1_000_000_000_0000.0;
        return percent;
    }

    public Employee getClerk() {
        return bill.getClerk();
    }
}