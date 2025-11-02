package lotto

enum class Rank(val results: Set<LottoResult>) {
    FIRST(setOf(LottoResult(Lotto.MATCH_6, Bonus.NOT_MATCH))),
    SECOND(setOf(LottoResult(Lotto.MATCH_5, Bonus.MATCH))),
    THIRD(setOf(LottoResult(Lotto.MATCH_5, Bonus.NOT_MATCH))),
    FOURTH(setOf(LottoResult(Lotto.MATCH_4, Bonus.MATCH), LottoResult(Lotto.MATCH_4, Bonus.NOT_MATCH))),
    FIFTH(setOf(LottoResult(Lotto.MATCH_3, Bonus.MATCH), LottoResult(Lotto.MATCH_3, Bonus.NOT_MATCH))),
    NONE((Lotto.MATCH_0..Lotto.MATCH_2).flatMap {
        listOf(
            LottoResult(it, Bonus.MATCH),
            LottoResult(it, Bonus.NOT_MATCH)
        )
    }.toSet());

    companion object {
        const val INVALID_LOTTO_RESULT = "[ERROR] 올바른 등수를 찾을 수 없습니다"
        fun from(result: LottoResult): Rank {
            return entries.find {
                it.results.contains(result)
            } ?: throw IllegalArgumentException(INVALID_LOTTO_RESULT)
        }
    }
}
