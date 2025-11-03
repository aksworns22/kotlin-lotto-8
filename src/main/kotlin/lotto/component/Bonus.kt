package lotto.component

@JvmInline
value class Bonus(val number: Int) {
    init {
        require(LottoNumber.isValidNumber(number)) { LottoNumber.INVALID_ERROR_MESSAGE }
    }

    companion object {
        const val MATCH = true
        const val NOT_MATCH = false
        fun from(input: String): Bonus {
            val number = input.toIntOrNull() ?: throw IllegalArgumentException(LottoNumber.INVALID_ERROR_MESSAGE)
            return Bonus(number)
        }
    }
}
