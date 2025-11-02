package lotto

@JvmInline
value class Bonus(val number: Int) {
    init {
        require(LottoNumber.isValidNumber(number)) { LottoNumber.INVALID_ERROR }
    }

    companion object {
        fun from(input: String): Bonus {
            val number = input.toIntOrNull() ?: throw IllegalArgumentException(LottoNumber.INVALID_ERROR)
            return Bonus(number)
        }
    }
}
