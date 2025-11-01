package lotto

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class WinningNumbersTest {
    @ParameterizedTest
    @MethodSource("InvalidSizeWinningNumbers")
    fun `당첨 번호의 개수를 유효한 개수만큼 뽑지 않으면 예외가 발생한다`(numbers: List<Int>, bonusNumber: Int) {
        assertThatThrownBy { WinningNumbers(numbers, Bonus(bonusNumber)) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(WinningNumbers.INVALID_SIZE_ERROR)
    }

    companion object {
        @JvmStatic
        fun InvalidSizeWinningNumbers(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(1, 2, 3, 4, 5), 6),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7), 8)
            )
        }
    }
}
