package lotto

import lotto.component.Bonus
import lotto.component.LottoNumber
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class BonusTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 46])
    fun `보너스 번호의 숫자 범위가 유효한 범위인지 확인한다`(invalidNumber: Int) {
        assertThatThrownBy { Bonus(invalidNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(LottoNumber.INVALID_ERROR_MESSAGE)
    }
}
