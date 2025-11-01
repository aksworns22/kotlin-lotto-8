package lotto

data class LottoPurchaseUnit(val count: Int) {
    companion object {
        const val VALID_MONEY_UNIT = 1000
        fun from(money: Int) = LottoPurchaseUnit(money / VALID_MONEY_UNIT)
    }
}
