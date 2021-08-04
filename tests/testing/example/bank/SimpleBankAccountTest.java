package testing.example.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class SimpleBankAccountTest {
	
	@Test
	void testDepositWhenAccountIsCorrectShouldIncreaseBalance() {
		SimpleBankAccount bankAccount = new SimpleBankAccount(5);
		bankAccount.deposit(10);
		assertThat(bankAccount.getBalance()).isEqualTo(15);
	}
	
	@Test
	void testDepositWhenAmountIsNegativeShouldThrow() {
		// setup
		SimpleBankAccount bankAccount = new SimpleBankAccount();
		
		assertThatThrownBy(()->bankAccount.deposit(-1)).isInstanceOf(IllegalArgumentException.class).hasMessage("Not positive: -1.0");
		assertThat(bankAccount.getBalance()).isZero();
	}
	
	@Test
	void testDepositWhenAmountIsZeroShouldThrow() {
		// setup
		SimpleBankAccount bankAccount = new SimpleBankAccount();
		
		assertThatThrownBy(()->bankAccount.deposit(0)).isInstanceOf(IllegalArgumentException.class).hasMessage("Not positive: 0.0");
		assertThat(bankAccount.getBalance()).isZero();
	}
}
