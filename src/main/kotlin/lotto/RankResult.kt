package lotto

@JvmInline
value class RankResult(val count: Map<Rank, Int>) {
    companion object {
        fun of(rankHistory: List<Rank>): RankResult {
            val count: MutableMap<Rank, Int> = mutableMapOf()
            for (rank in Rank.entries) {
                count[rank] = rankHistory.count { rank == it }
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
