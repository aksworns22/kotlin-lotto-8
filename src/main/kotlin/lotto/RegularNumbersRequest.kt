package lotto

import lotto.util.UserInput

object RegularNumbersRequest {
    fun from(userInput: UserInput): RegularNumbers {
        while (true) {
            try {
                return RegularNumbers.from(userInput.readLine().split(","))
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }
}
