package lotto

import lotto.util.UserInput

object PurchaseRequest {
    fun from(userInput: UserInput): LottoPurchaseUnit {
        try {
            val money = userInput.readLine().trim().toDouble()
            val lottoPurchaseUnit = LottoPurchaseUnit.from(money)
            println("\n${lottoPurchaseUnit.count}개를 구매했습니다.")
            return LottoPurchaseUnit.from(money)

        } catch (_: NumberFormatException) {
            println(LottoPurchaseUnit.INVALID_MONEY_ERROR)
            return from(userInput)
        } catch (error: IllegalArgumentException) {
            println(error)
            return from(userInput)
        }
    }
}
