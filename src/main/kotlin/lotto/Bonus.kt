package lotto

@JvmInline
value class Bonus(val number: Int) {
    init {
        require(isValidNumber(number)) { INVALID_NUMBER_ERROR }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        fun isValidNumber(number: Int) = number in MIN_NUMBER..MAX_NUMBER
        const val INVALID_NUMBER_ERROR = "[ERROR] 올바른 보너스 번호 범위가 아닙니다."
    }
}
