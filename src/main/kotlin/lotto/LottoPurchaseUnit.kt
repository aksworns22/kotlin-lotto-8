package lotto

data class LottoPurchaseUnit(val count: Int) {
    companion object {
        const val VALID_MONEY_UNIT = 1000
        const val INVALID_MONEY_ERROR = "[ERROR] 유효하지 않은 구입 금액입니다."
        fun from(money: Int): LottoPurchaseUnit {
            require(money >= 0) { INVALID_MONEY_ERROR }
            require(money % VALID_MONEY_UNIT == 0) { INVALID_MONEY_ERROR }
            return LottoPurchaseUnit(money / VALID_MONEY_UNIT)
        }

        fun from(money: Double): LottoPurchaseUnit {
            require(money >= 0) { INVALID_MONEY_ERROR }
            require(money % VALID_MONEY_UNIT == 0.0) { INVALID_MONEY_ERROR }
            return LottoPurchaseUnit(money.toInt() / VALID_MONEY_UNIT)
        }
    }
}
