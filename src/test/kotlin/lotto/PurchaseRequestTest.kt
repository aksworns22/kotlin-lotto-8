package lotto

import lotto.request.PurchaseRequest
import lotto.util.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PurchaseRequestTest {
    @ParameterizedTest
    @MethodSource("userInput")
    fun `사용자의 입력에 해당하는 만큼 구매 단위를 계산한다`(userInput: UserInput, numberOfLotto: LottoPurchaseUnit) {
        assertThat(PurchaseRequest.from(userInput))
            .isEqualTo(numberOfLotto)
    }

    companion object {
        @JvmStatic
        fun userInput(): List<Arguments> {
            return listOf(
                Arguments.of(FakeUserInput(listOf("1000")), LottoPurchaseUnit(1)),
                Arguments.of(FakeUserInput(listOf("a", "1000")), LottoPurchaseUnit(1)),
                Arguments.of(FakeUserInput(listOf("-1000", "-2000", "3000")), LottoPurchaseUnit(3)),
                Arguments.of(FakeUserInput(listOf("1000.1", "2000.0")), LottoPurchaseUnit(2)),
                Arguments.of(FakeUserInput(listOf("1000.0 ")), LottoPurchaseUnit(1)),
                Arguments.of(FakeUserInput(listOf("100", "1000")), LottoPurchaseUnit(1))
            )
        }
    }
}
