package lotto

import org.assertj.core.api.Assertions.assertThatCode
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {
    @Test
    fun `로또 번호의 개수가 6개가 넘어가면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7))
        }
    }

    @Test
    fun `로또 번호에 중복된 숫자가 있으면 예외가 발생한다`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 5))
        }
    }

    @ParameterizedTest
    @MethodSource("invalidSizeNumbers")
    fun `로또 번호의 개수를 유효한 개수만큼 뽑지 않으면 예외가 발생한다`(invalidSizeNumbers: List<Int>) {
        assertThatThrownBy { Lotto(invalidSizeNumbers) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(Lotto.LOTTO_SIZE_ERROR)
    }

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46])
    fun `로또 번호의 숫자 범위가 유효한 범위인지 확인한다`(illegalNumber: Int) {
        val validNumbers = arrayOf(1, 2, 3, 4, 5)
        val numbersWithInvalid = listOf(illegalNumber, *validNumbers)
        assertThatThrownBy { Lotto(numbersWithInvalid) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .hasMessage(LottoNumber.INVALID_ERROR)
    }

    @Test
    fun `랜덤한 숫자로 구성된 로또를 발행한다`() {
        assertThatCode { Lotto.fromRandom() }
            .describedAs("랜덤 숫자 생성과 관련한 문제가 있습니다")
            .doesNotThrowAnyException()
    }

    companion object {
        @JvmStatic
        fun invalidSizeNumbers(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(1, 2, 3, 4, 5)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7))
            )
        }
    }
}
