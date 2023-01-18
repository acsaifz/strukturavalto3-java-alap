package hu.acsaifz.loans;

public class LoanService {
    private LoanRepository loanRepository;

    public LoanService(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    public int payForLoan(long id, int amount){
        Loan loan = loanRepository.findLoanById(id);
        int actualDebt = loan.getDebt();

        if (amount > actualDebt){
            loanRepository.updateDebtWithPayment(id, actualDebt);
            amount = amount - actualDebt;
        } else {
            loanRepository.updateDebtWithPayment(id, amount);
            amount = 0;
        }

        return amount;
    }
}
