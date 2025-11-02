package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoPurchaseUnitTest {
    @ParameterizedTest
    @CsvSource("1000, 1", "2000, 2", "3000, 3")
    fun `구입 금액에 해당하는 만큼 로또를 발행한다`(money: String, numberOfLotto: Int) {
        assertThat(LottoPurchaseUnit.from(money))
            .describedAs("올바른 금액 단위인지 확인하세요")
            .isEqualTo(LottoPurchaseUnit(numberOfLotto))
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1000", "-1", "0"])
    fun `구입 금액이 양수가 아니라면 예외 처리한다`(negativeMoney: String) {
        assertThatThrownBy { LottoPurchaseUnit.from(negativeMoney) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(LottoPurchaseUnit.INVALID_MONEY_ERROR)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1000.0", "-500.0", "500.0", "1000.1"])
    fun `구입 금액이 적절하지 못한 소수라면 예외 처리한다`(money: String) {
        assertThatThrownBy { LottoPurchaseUnit.from(money) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(LottoPurchaseUnit.INVALID_MONEY_ERROR)
    }

    @ParameterizedTest
    @CsvSource("1000.0, 1", "2000.00, 2", "3000.000, 3")
    fun `구입 금액이 적절한 소수라면 해당하는 만큼 로또를 발행한다`(money: String, numberOfLotto: Int) {
        assertThat(LottoPurchaseUnit.from(money))
            .describedAs("올바른 금액 단위인지 확인하세요")
            .isEqualTo(LottoPurchaseUnit(numberOfLotto))
    }
}
