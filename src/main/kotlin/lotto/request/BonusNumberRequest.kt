package lotto.request

import lotto.Bonus
import lotto.LottoPurchaseUnit
import lotto.util.UserInput

object BonusNumberRequest {
    fun from(userInput: UserInput): Bonus {
        while (true) {
            try {
                val number = userInput.readLine().trim()
                return Bonus.from(number)

            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }
}
