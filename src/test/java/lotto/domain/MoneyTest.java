package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MoneyTest {

    @Test
    void moneyConstructorTest() {
        assertThatThrownBy(()-> new Money(999)).isInstanceOf(IllegalArgumentException.class);

        Money money1 = new Money(1000);
        Money money2 = new Money(50000);
    }

    @ParameterizedTest
    @CsvSource("999,1000")
    void checkValidationInputMoney(int underTicket, int upperTicket) {
        boolean invalidTicket = Money.validateInputMoney(underTicket);
        boolean validTicket = Money.validateInputMoney(upperTicket);

        assertThat(invalidTicket).isFalse();
        assertThat(validTicket).isTrue();
    }

}
