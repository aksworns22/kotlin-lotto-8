package lotto

import lotto.request.BonusNumberRequest
import lotto.request.PurchaseRequest
import lotto.request.RegularNumbersRequest
import lotto.util.ConsoleUserInput
import lotto.util.UniqueRandomGenerator

fun main() {
    val lottoPurchaseUnit = PurchaseRequest.from(ConsoleUserInput)
    val boughtLotto = Lotto.from(UniqueRandomGenerator, lottoPurchaseUnit)
    boughtLotto.print()
    val regularNumbers = RegularNumbersRequest.from(ConsoleUserInput)
    val bonusNumber = BonusNumberRequest.from(ConsoleUserInput)
}
