package lotto

import lotto.component.Bonus
import lotto.request.BonusNumberRequest
import lotto.util.FakeUserInput
import lotto.util.UserInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class BonusNumberRequestTest {
    @ParameterizedTest
    @MethodSource("userInput")
    fun `사용자 입력을 통해 보너스 번호를 생성한다`(userInput: UserInput, expectedNumber: Int) {
        assertThat(BonusNumberRequest.from(userInput))
            .isEqualTo(Bonus(expectedNumber))
    }

    companion object {
        @JvmStatic
        fun userInput(): List<Arguments> {
            return listOf(
                Arguments.of(FakeUserInput(listOf("45")), 45),
                Arguments.of(FakeUserInput(listOf("a", "0", "1")), 1),
                Arguments.of(FakeUserInput(listOf("-1000", "-1", "1")), 1),
            )
        }
    }
}
