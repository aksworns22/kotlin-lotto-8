package lotto

data class LottoPurchaseUnit(val count: Int) {
    val totalMoney = count * VALID_MONEY_UNIT

    init {
        require(count >= 0) { INVALID_UNIT_ERROR }
    }

    companion object {
        const val VALID_MONEY_UNIT = 1000
        const val INVALID_MONEY_ERROR = "[ERROR] 유효하지 않은 구입 금액입니다."
        const val INVALID_UNIT_ERROR = "[ERROR] 유효하지 않은 단위입니다."
        fun from(input: String): LottoPurchaseUnit {
            val money = input.toDoubleOrNull() ?: throw IllegalArgumentException(INVALID_MONEY_ERROR)
            validateMoney(money)
            return LottoPurchaseUnit(money.toInt() / VALID_MONEY_UNIT)
        }

        private fun validateMoney(money: Double) {
            require(money > 0) { INVALID_MONEY_ERROR }
            require(money % VALID_MONEY_UNIT == 0.0) { INVALID_MONEY_ERROR }
        }
    }
}
