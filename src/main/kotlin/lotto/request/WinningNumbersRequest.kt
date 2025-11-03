package lotto.request

import lotto.WinningNumbers
import lotto.util.UserInput

object WinningNumbersRequest {
    fun from(userInput: UserInput): WinningNumbers {
        val regularNumbers = RegularNumbersRequest.from(userInput)
        while (true) {
            try {
                val bonusNumber = BonusNumberRequest.from(userInput)
                return WinningNumbers(regularNumbers, bonusNumber)

            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }
}
