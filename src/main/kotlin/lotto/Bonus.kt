package lotto

@JvmInline
value class Bonus(val number: Int) {
    init {
        require(LottoNumber.isValidNumber(number)) { LottoNumber.INVALID_ERROR }
    }
}
