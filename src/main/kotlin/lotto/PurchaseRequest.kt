package lotto

import lotto.util.UserInput

object PurchaseRequest {
    fun from(userInput: UserInput): LottoPurchaseUnit {
        while (true) {
            try {
                println("구입금액을 입력해 주세요.")
                val money = userInput.readLine().trim()
                val lottoPurchaseUnit = LottoPurchaseUnit.from(money)
                println("\n${lottoPurchaseUnit.count}개를 구매했습니다.")
                return lottoPurchaseUnit

            } catch (error: IllegalArgumentException) {
                println(error.message)
            }
        }
    }
}
