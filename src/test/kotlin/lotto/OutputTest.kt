package lotto

import lotto.request.PurchaseRequest
import lotto.request.RegularNumbersRequest
import lotto.util.FakeRandomGenerator
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

    @Test
    fun `구매한 로또를 오름차순으로 정렬해서 보여준다`() {
        val randomNumbers = listOf(
            listOf(6, 5, 4, 3, 2, 1),
            listOf(45, 1, 2, 4, 3, 44)
        )
        val fakeRandomGenerator = FakeRandomGenerator(randomNumbers)
        val boughtLotto = Lotto.from(fakeRandomGenerator, LottoPurchaseUnit(2))
        boughtLotto.print()
        assertThat(output()).contains(
            "[1, 2, 3, 4, 5, 6]",
            "[1, 2, 3, 4, 44, 45]"
        )
    }

    @Test
    fun `정규 번호를 입력 받는 경우 요구사항에 맞는 메시지를 출력한다`() {
        RegularNumbersRequest.from(
            FakeUserInput(
                listOf(
                    "1",
                    "1,1,2,3,4,5",
                    "a,1,2,3,4,5",
                    "-1,2,3,4,5,6",
                    "1,2,3,4,5,46",
                    "1.0,2,3,4,5,6",
                    "1,2,3,4,5,6"
                )
            )
        )
        assertThat(output()).contains(
            "당첨 번호를 입력해 주세요.",
            LottoNumber.INVALID_ERROR,
            RegularNumbers.INVALID_SIZE_ERROR,
            RegularNumbers.DUPLICATED_ERROR,
        )
    }
}
