package lotto.request

import lotto.component.RegularNumbers
import lotto.util.UserInput

object RegularNumbersRequest {
    fun from(userInput: UserInput): RegularNumbers {
        while (true) {
            try {
                println("당첨 번호를 입력해 주세요.")
                return RegularNumbers.from(userInput.readLine().split(","))
            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }
}
