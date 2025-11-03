package lotto.request

import lotto.result.PurchaseResult
import lotto.util.UserInput

object PurchaseRequest {
    fun from(userInput: UserInput): PurchaseResult {
        while (true) {
            try {
                println("구입금액을 입력해 주세요.")
                val money = userInput.readLine().trim()
                val purchaseResult = PurchaseResult.of(money)
                println("\n${purchaseResult.count}개를 구매했습니다.")
                return purchaseResult

            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }
}
