package lotto

import lotto.component.Bonus
import lotto.component.RegularNumbers
import lotto.result.LottoResult
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoResultTest {
    @ParameterizedTest
    @MethodSource("compareLotto")
    fun `당첨 번호와 구매한 로또를 비교한다`(lotto: Lotto, winningNumbers: WinningNumbers, result: LottoResult) {
        assertThat(LottoResult.of(lotto, winningNumbers))
            .isEqualTo(result)
    }

    companion object {
        @JvmStatic
        fun compareLotto(): List<Arguments> {
            return listOf(
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 6)),
                    WinningNumbers(RegularNumbers(listOf(1, 2, 3, 4, 5, 6)), Bonus(7)),
                    LottoResult(Lotto.MATCH_6, Bonus.NOT_MATCH)
                ),
                Arguments.of(
                    Lotto(listOf(1, 2, 3, 4, 5, 11)),
                    WinningNumbers(RegularNumbers(listOf(1, 2, 7, 8, 9, 10)), Bonus(11)),
                    LottoResult(Lotto.MATCH_2, Bonus.MATCH)
                ),
                Arguments.of(
                    Lotto(listOf(3, 1, 9, 8, 6, 2)),
                    WinningNumbers(RegularNumbers(listOf(12, 6, 17, 14, 16, 19)), Bonus(11)),
                    LottoResult(Lotto.MATCH_1, Bonus.NOT_MATCH)
                ),
                Arguments.of(
                    Lotto(listOf(3, 1, 9, 8, 6, 2)),
                    WinningNumbers(RegularNumbers(listOf(3, 1, 9, 2, 6, 19)), Bonus(45)),
                    LottoResult(Lotto.MATCH_5, Bonus.NOT_MATCH)
                ),
                Arguments.of(
                    Lotto(listOf(3, 1, 9, 8, 6, 2)),
                    WinningNumbers(RegularNumbers(listOf(3, 1, 9, 2, 6, 19)), Bonus(8)),
                    LottoResult(Lotto.MATCH_5, Bonus.MATCH)
                )
            )
        }
    }
}
