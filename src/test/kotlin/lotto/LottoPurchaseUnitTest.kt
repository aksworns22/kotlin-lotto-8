package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPurchaseUnitTest {
    @ParameterizedTest
    @CsvSource("1000, 1", "2000, 2", "3000, 3")
    fun `구입 금액에 해당하는 만큼 로또를 발행한다`(money: Int, numberOfLotto: Int) {
        assertThat(LottoPurchaseUnit.from(money))
            .describedAs("올바른 금액 단위인지 확인하세요")
            .isEqualTo(LottoPurchaseUnit(numberOfLotto))
    }
}
