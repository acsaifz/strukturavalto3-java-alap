package hu.acsaifz.loans;

public class Loan {
    private Long id;
    private String name;
    private int debt;
    private double interest;

    public Loan(String name, int debt, double interest) {
        this.name = name;
        this.debt = debt;
        this.interest = interest;
    }

    public Loan(Long id, String name, int debt, double interest) {
        this(name, debt, interest);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDebt() {
        return debt;
    }

    public double getInterest() {
        return interest;
    }
}
