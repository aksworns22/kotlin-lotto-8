package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class RankTest {
    @ParameterizedTest
    @MethodSource("lottoResult")
    fun `당첨 번호와 구매한 로또의 비교 결과를 통해 등수를 확인한다`(lottoResult: LottoResult, rank: Rank) {
        assertThat(Rank.from(lottoResult))
            .isEqualTo(rank)
    }

    companion object {
        @JvmStatic
        fun lottoResult(): List<Arguments> {
            return listOf(
                Arguments.of(
                    LottoResult(Lotto.MATCH_6, Bonus.NOT_MATCH),
                    Rank.FIRST
                ),
                Arguments.of(
                    LottoResult(Lotto.MATCH_5, Bonus.MATCH),
                    Rank.SECOND
                ),
                Arguments.of(
                    LottoResult(Lotto.MATCH_5, Bonus.NOT_MATCH),
                    Rank.THIRD
                ),
                Arguments.of(
                    LottoResult(Lotto.MATCH_4, Bonus.NOT_MATCH),
                    Rank.FOURTH
                ),
                Arguments.of(
                    LottoResult(Lotto.MATCH_4, Bonus.MATCH),
                    Rank.FOURTH
                ),
                Arguments.of(
                    LottoResult(Lotto.MATCH_3, Bonus.NOT_MATCH),
                    Rank.FIFTH
                ),
                Arguments.of(
                    LottoResult(Lotto.MATCH_3, Bonus.MATCH),
                    Rank.FIFTH
                ),
                Arguments.of(
                    LottoResult(Lotto.MATCH_2, Bonus.NOT_MATCH),
                    Rank.NONE
                ),
                Arguments.of(
                    LottoResult(Lotto.MATCH_2, Bonus.MATCH),
                    Rank.NONE
                )
            )
        }
    }
}
