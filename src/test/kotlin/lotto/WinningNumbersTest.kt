package lotto

import lotto.component.Bonus
import lotto.component.LottoNumber
import lotto.component.RegularNumbers
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class WinningNumbersTest {
    @ParameterizedTest
    @MethodSource("invalidSizeRegularNumbers")
    fun `정규 번호 개수를 유효한만큼 뽑지 않으면 예외가 발생한다`(numbers: List<Int>) {
        assertThatThrownBy { RegularNumbers(numbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(RegularNumbers.INVALID_SIZE_ERROR_MESSAGE)
    }

    @Test
    fun `정규 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThatThrownBy { RegularNumbers(listOf(1, 1, 2, 3, 4, 5)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(RegularNumbers.DUPLICATED_ERROR_MESSAGE)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46])
    fun `정규 번호의 숫자 범위가 유효한 범위인지 확인한다`(illegalNumber: Int) {
        val validNumbers = arrayOf(1, 2, 3, 4, 5)
        assertThatThrownBy { RegularNumbers(listOf(illegalNumber, *validNumbers)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(LottoNumber.INVALID_ERROR_MESSAGE)
    }

    @Test
    fun `정규 번호와 보너스가 중복되지 않았는 지 확인한다`() {
        val numbers = RegularNumbers(listOf(1, 2, 3, 4, 5, 6))
        val bonusNumber = Bonus(6)
        assertThatThrownBy { WinningNumbers(numbers, bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(WinningNumbers.DUPLICATED_WITH_BONUS_ERROR_MESSAGE)
    }

    companion object {
        @JvmStatic
        fun invalidSizeRegularNumbers(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(1, 2, 3, 4, 5)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7))
            )
        }
    }
}
