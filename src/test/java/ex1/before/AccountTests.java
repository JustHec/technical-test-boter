package ex1.before;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Ex1 Before: Account tests")
class AccountTests {

	@Nested
	@DisplayName("Checking Account")
	class CheckingAccountTests {

		@Test
		void withdrawCovered() {
			Account account = Account.newCheckingAccount(100, 20);
			account.withdraw(99);
			assertEquals(1, account.getBalance());

			account.withdraw(1);
			assertEquals(0, account.getBalance());
		}

		@Test
		void withdrawUsingOverdraft() {
			Account account = Account.newCheckingAccount(100, 20);
			account.withdraw(101);
			assertEquals(-1, account.getBalance());

			account.withdraw(19);
			assertEquals(-20, account.getBalance());
		}

		@Test
		void withdrawNotCovered() {
			Account account = Account.newCheckingAccount(100, 20);
			assertThrows(IllegalArgumentException.class, () -> {
				account.withdraw(121);
			});
		}
	}

	@Nested
	@DisplayName("Savings Account")
	class SavingsAccountTests {

		@Test
		void withdrawCovered() {
			Account account = Account.newSavingsAccount(1000);
			account.withdraw(990);
			assertEquals(10, account.getBalance());

			account.withdraw(10);
			assertEquals(0, account.getBalance());
		}

		@Test
		void withdrawNotCovered() {
			Account account = Account.newSavingsAccount(1000);
			assertThrows(IllegalArgumentException.class, () -> {
				account.withdraw(1001);
			});
		}
	}

	@Nested
	@DisplayName("Instant Access Account")
	class InstantAccessAccountTests {
		@Test
		void withdrawCovered() {
			Account account = Account.newInstantAccessAccount(10000, 1000);
			account.withdraw(8900);
			assertEquals(1100, account.getBalance());

			account.withdraw(100);
			assertEquals(1000, account.getBalance());
		}

		@Test
		void withdrawNotCovered() {
			Account account = Account.newInstantAccessAccount(10000, 1000);
			assertThrows(IllegalArgumentException.class, () -> {
				account.withdraw(9001);
			});
		}
	}
}
