package lotto

data class Profit(val rankResult: RankResult, val lottoPurchaseUnit: LottoPurchaseUnit) {
    val earnMoney = Rank.entries.sumOf { it.prize.money * rankResult.count[it]!! }
    val purchaseMoney = lottoPurchaseUnit.totalMoney
    val rate = earnMoney.toDouble() / purchaseMoney.toDouble()

    fun printRate() {
        println("총 수익률은 ${"%.1f".format(rate * 100)}%입니다.")
    }
}
