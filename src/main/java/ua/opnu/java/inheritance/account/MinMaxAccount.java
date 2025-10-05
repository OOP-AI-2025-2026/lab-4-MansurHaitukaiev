package ua.opnu.java.inheritance.account;

public class MinMaxAccount extends BankingAccount {
    private int min;
    private int max;

    public MinMaxAccount(Startup s) {
        super(s);
        int initialBalance = s.getBalance();
        this.min = initialBalance;
        this.max = initialBalance;
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);
        updateMinMax();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c);
        updateMinMax();
    }

    private void updateMinMax() {
        int currentBalance = getBalance();
        if (currentBalance < min) min = currentBalance;
        if (currentBalance > max) max = currentBalance;
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }
}