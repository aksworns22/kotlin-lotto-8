package lotto

import lotto.util.FakeUserInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.OutputStream
import java.io.PrintStream

class OutputTest {
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

    @Test
    fun `구매 금액을 입력 받는 경우 요구사항에 맞는 메시지를 출력한다`() {
        PurchaseRequest.from(FakeUserInput(listOf("a", "1000")))
        assertThat(output()).contains(
            "구입금액을 입력해 주세요.",
            LottoPurchaseUnit.INVALID_MONEY_ERROR,
            "1개를 구매했습니다."
        )
    }
}
