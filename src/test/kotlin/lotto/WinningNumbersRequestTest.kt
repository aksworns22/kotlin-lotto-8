package lotto

import lotto.component.Bonus
import lotto.component.RegularNumbers
import lotto.request.WinningNumbersRequest
import lotto.util.FakeUserInput
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningNumbersRequestTest {
    @Test
    fun `정규 번호와 보너스 번호를 입력받아 중복 확인 후 당첨 번호를 만든다`() {
        assertThat(WinningNumbersRequest.from(FakeUserInput(listOf("1,2,3,4,5,6", "1", "7"))))
            .isEqualTo(WinningNumbers(RegularNumbers(listOf(1, 2, 3, 4, 5, 6)), Bonus(7)))
    }
}
