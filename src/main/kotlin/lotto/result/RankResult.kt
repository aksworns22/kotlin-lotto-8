package lotto.result

import lotto.Rank

@JvmInline
value class RankResult(val count: Map<Rank, Int>) {
    companion object {
        fun of(rankHistory: List<Rank>): RankResult {
            val count: MutableMap<Rank, Int> = mutableMapOf()
            for (rank in Rank.entries) {
                count[rank] = rankHistory.count { rankInHistory -> rankInHistory == rank }
            }
            return RankResult(count)
        }
    }

    fun print() {
        println("당첨 통계")
        println("---")
        for (rank in Rank.descendingRanks()) {
            println("${rank.condition} (${rank.prize}원) - ${count[rank]}개")
        }
    }
}
