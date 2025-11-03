package lotto

import lotto.component.Bonus
import lotto.component.Prize
import lotto.result.LottoResult

enum class Rank(val results: Set<LottoResult>, val condition: String, val prize: Prize) {
    FIRST(setOf(LottoResult(Lotto.MATCH_6, Bonus.NOT_MATCH)), "6개 일치", Prize(2_000_000_000)),
    SECOND(setOf(LottoResult(Lotto.MATCH_5, Bonus.MATCH)), "5개 일치, 보너스 볼 일치", Prize(30_000_000)),
    THIRD(setOf(LottoResult(Lotto.MATCH_5, Bonus.NOT_MATCH)), "5개 일치", Prize(1_500_000)),
    FOURTH(
        setOf(LottoResult(Lotto.MATCH_4, Bonus.MATCH), LottoResult(Lotto.MATCH_4, Bonus.NOT_MATCH)),
        "4개 일치",
        Prize(50_000)
    ),
    FIFTH(
        setOf(LottoResult(Lotto.MATCH_3, Bonus.MATCH), LottoResult(Lotto.MATCH_3, Bonus.NOT_MATCH)),
        "3개 일치",
        Prize(5_000)
    ),
    NONE((Lotto.MATCH_0..Lotto.MATCH_2).flatMap { matchCount ->
        listOf(
            LottoResult(matchCount, Bonus.MATCH),
            LottoResult(matchCount, Bonus.NOT_MATCH)
        )
    }.toSet(), "2개 이하 일치", Prize(0));

    companion object {
        const val INVALID_LOTTO_RESULT_MESSAGE = "[ERROR] 올바른 등수를 찾을 수 없습니다"
        fun from(result: LottoResult): Rank {
            return entries.find { rank ->
                rank.results.contains(result)
            } ?: throw IllegalArgumentException(INVALID_LOTTO_RESULT_MESSAGE)
        }

        fun descendingRanks(): List<Rank> = listOf(FIFTH, FOURTH, THIRD, SECOND, FIRST)
    }
}
