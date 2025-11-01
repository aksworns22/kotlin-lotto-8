package lotto

import lotto.util.UserInput

object PurchaseRequest {
    fun from(userInput: UserInput): LottoPurchaseUnit {
        try {
            val money = userInput.readLine().trim().toDouble()
            return LottoPurchaseUnit.from(money)

        } catch (error: IllegalArgumentException) {
            return from(userInput)
        }
    }
}
