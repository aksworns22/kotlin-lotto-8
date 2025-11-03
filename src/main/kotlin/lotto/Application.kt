package lotto

import lotto.request.PurchaseRequest
import lotto.request.WinningNumbersRequest
import lotto.result.LottoResult
import lotto.result.RankResult
import lotto.util.ConsoleUserInput
import lotto.util.UniqueRandomGenerator

fun List<Lotto>.print() {
    this.forEach { lotto ->
        println(lotto.toString())
    }
    println()
}

fun main() {
    val lottoPurchaseUnit = PurchaseRequest.from(ConsoleUserInput)
    val boughtLotto = Lotto.from(UniqueRandomGenerator, lottoPurchaseUnit)
    boughtLotto.print()
    val winningNumbers = WinningNumbersRequest.from(ConsoleUserInput)
    val lottoResults = boughtLotto.map { lotto -> LottoResult.of(lotto, winningNumbers) }
    val rankResult = RankResult.of(lottoResults.map { lottoResult -> Rank.from(lottoResult) })
    rankResult.print()
    val profit = Profit(rankResult, lottoPurchaseUnit)
    profit.printRate()
}
