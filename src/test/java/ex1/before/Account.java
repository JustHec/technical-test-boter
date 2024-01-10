package ex1.before;

public class Account {

	enum Type {
		SAVINGS, CHECKING, INSTANT_ACCESS
	}

	private final Type accountType;
	private final int overdraft;
	private final int minimumBalance;

	private int balance;

	public static Account newSavingsAccount(int initialBalance) {
		return new Account(Type.SAVINGS, initialBalance, 0, 0);
	}

	public static Account newCheckingAccount(int initialBalance, int overdraft) {
		return new Account(Type.CHECKING, initialBalance, overdraft, 0);
	}

	public static Account newInstantAccessAccount(int initialBalance, int minimumBalance) {
		return new Account(Type.INSTANT_ACCESS, initialBalance, 0, minimumBalance);
	}

	private Account(Type accountType, int initialBalance, int overdraft, int minimumBalance) {
		this.accountType = accountType;
		this.balance = initialBalance;
		this.overdraft = overdraft;
		this.minimumBalance = minimumBalance;
	}

	public void withdraw(int amount) {
		if (!isWithdrawCovered(amount)) {
			String message = String.format("Amount %s cannot be withdrawn", amount);
			throw new IllegalArgumentException(message);
		}
		balance -= amount;
	}

	public int getBalance() {
		return balance;
	}

	private boolean isWithdrawCovered(int amount) {
		switch (accountType) {
			case CHECKING:
				return amount <= balance + overdraft;
			case SAVINGS:
				return amount <= balance;
			case INSTANT_ACCESS:
				return amount <= balance - minimumBalance;
			default:
				throw new RuntimeException("Unknown account type");
		}
	}

	public void payMonthlyFee() {
		if (!isWithdrawCovered(10)) {
			String message = String.format("Amount %s cannot be withdrawn", amount);
			throw new IllegalArgumentException(message);
		}
		balance -= 10;
	}
}
