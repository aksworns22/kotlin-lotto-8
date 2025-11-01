package lotto

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

class LottoPurchaseUnitTest {
    @ParameterizedTest
    @CsvSource("1000, 1", "2000, 2", "3000, 3")
    fun `구입 금액에 해당하는 만큼 로또를 발행한다`(money: Int, numberOfLotto: Int) {
        assertThat(LottoPurchaseUnit.from(money))
            .describedAs("올바른 금액 단위인지 확인하세요")
            .isEqualTo(LottoPurchaseUnit(numberOfLotto))
    }

    @ParameterizedTest
    @ValueSource(ints = [-1000, -1])
    fun `구입 금액이 음수라면 예외 처리한다`(negativeMoney: Int) {
        assertThatThrownBy { LottoPurchaseUnit.from(negativeMoney) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(LottoPurchaseUnit.INVALID_MONEY_ERROR)
    }
}
