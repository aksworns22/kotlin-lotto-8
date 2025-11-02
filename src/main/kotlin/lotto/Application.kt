package lotto

import lotto.util.ConsoleUserInput
import lotto.util.UniqueRandomGenerator

fun main() {
    val lottoPurchaseUnit = PurchaseRequest.from(ConsoleUserInput)

    val boughtLotto = Lotto.from(UniqueRandomGenerator, lottoPurchaseUnit)
    boughtLotto.print()
}
