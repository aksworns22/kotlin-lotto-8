package lotto

import lotto.util.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

class PurchaseRequestTest {
    private lateinit var outputStream: OutputStream

    @BeforeEach
    fun init() {
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))
    }

    @AfterEach
    fun printOutput() {
        System.setOut(System.out)
        println(output())
    }

    fun output(): String {
        return outputStream.toString().trim()
    }

    @ParameterizedTest
    @MethodSource("userInput")
    fun `사용자의 입력에 해당하는 만큼 구매 단위를 계산한다`(userInput: UserInput, numberOfLotto: LottoPurchaseUnit) {
        assertThat(PurchaseRequest.from(userInput))
            .isEqualTo(numberOfLotto)
    }

    @Test
    fun `구매 금액을 입력 받는 경우 요구사항에 맞는 메시지를 출력한다`() {
        PurchaseRequest.from(FakeUserInput(listOf("a", "1000")))
        assertThat(output()).contains(
            "구입금액을 입력해 주세요.",
            LottoPurchaseUnit.INVALID_MONEY_ERROR,
            "1개를 구매했습니다."
        )
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
