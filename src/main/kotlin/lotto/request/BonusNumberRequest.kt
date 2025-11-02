package lotto.request

import lotto.Bonus
import lotto.LottoPurchaseUnit
import lotto.util.UserInput

object BonusNumberRequest {
    fun from(userInput: UserInput): Bonus {
        while (true) {
            try {
                println("보너스 번호를 입력해 주세요.")
                val number = userInput.readLine().trim()
                return Bonus.from(number)

            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }
}
