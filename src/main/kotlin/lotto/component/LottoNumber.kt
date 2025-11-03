package lotto.component

object LottoNumber {
    const val MIN_NUMBER = 1
    const val MAX_NUMBER = 45
    const val INVALID_ERROR = "[ERROR] 올바른 로또 번호 범위가 아닙니다."
    fun isValidNumber(number: Int) = number in MIN_NUMBER..MAX_NUMBER
}
