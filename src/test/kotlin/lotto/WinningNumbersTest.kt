package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class WinningNumbersTest {
    @ParameterizedTest
    @MethodSource("invalidSizeWinningNumbers")
    fun `당첨 번호의 개수를 유효한 개수만큼 뽑지 않으면 예외가 발생한다`(numbers: List<Int>, bonusNumber: Int) {
        assertThatThrownBy { WinningNumbers(numbers, Bonus(bonusNumber)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(WinningNumbers.INVALID_SIZE_ERROR)
    }

    @Test
    fun `당첨 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        val duplicatedNumbers = listOf(1, 1, 2, 3, 4, 5)
        val bonus = Bonus(6)
        assertThatThrownBy { WinningNumbers(duplicatedNumbers, bonus) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(WinningNumbers.DUPLICATED_ERROR)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46])
    fun `당첨 번호의 숫자 범위가 유효한 범위인지 확인한다`(illegalNumber: Int) {
        val validNumbers = arrayOf(1, 2, 3, 4, 5)
        val numbersWithInvalid = listOf(illegalNumber, *validNumbers)
        assertThatThrownBy { WinningNumbers(numbersWithInvalid, Bonus(7)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(WinningNumbers.INVALID_NUMBER_ERROR)
    }

    @Test
    fun `당첨 번호와 보너스가 중복되지 않았는 지 확인한다`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val bonusNumber = Bonus(6)
        assertThatThrownBy { WinningNumbers(numbers, bonusNumber) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(WinningNumbers.DUPLICATED_WITH_BONUS_ERROR)
    }

    companion object {
        @JvmStatic
        fun invalidSizeWinningNumbers(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(1, 2, 3, 4, 5), 6),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7), 8)
            )
        }
    }
}
