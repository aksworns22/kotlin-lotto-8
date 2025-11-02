package lotto

import lotto.util.FakeUserInput
import lotto.util.UserInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RegularNumbersRequestTest {
    @ParameterizedTest
    @MethodSource("userInput")
    fun `사용자의 입력을 받아 정규 번호를 결정한다`(userInput: UserInput, result: List<Int>) {
        assertThat(RegularNumbersRequest.from(userInput))
            .isEqualTo(RegularNumbers(result))
    }

    companion object {
        @JvmStatic
        fun userInput(): List<Arguments> {
            return listOf(
                Arguments.of(
                    FakeUserInput(
                        listOf(
                            "1,2,3,3,4,5",
                            "1,2,3,4,5,6.0",
                            "-1,2,3,4,5,6",
                            "1,2,3,4,5,46",
                            "a,1,2,3,4,5",
                            "1 , 2, 3, 4,  5, 6",
                        )
                    ),
                    listOf(1, 2, 3, 4, 5, 6)
                )
            )
        }
    }
}
