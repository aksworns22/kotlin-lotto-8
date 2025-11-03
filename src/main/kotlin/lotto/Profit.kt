package lotto

data class Profit(val rankResult: RankResult, val lottoPurchaseUnit: LottoPurchaseUnit) {
    val earnMoney = Rank.entries.sumOf { it.prize.money * rankResult.count[it]!! }
    val purchaseMoney = lottoPurchaseUnit.totalMoney
    val rate = earnMoney.toDouble() / purchaseMoney.toDouble()
}
