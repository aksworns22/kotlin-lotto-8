package lotto

data class WinningNumbers(val numbers: List<Int>, val bonus: Bonus) {
    init {
        require(numbers.size == SIZE_WITHOUT_BONUS) { INVALID_SIZE_ERROR }
    }

    init {
        require(numbers.distinct().size == SIZE_WITHOUT_BONUS) { DUPLICATED_ERROR }
    }

    init {
        if (numbers.any { number -> !isValidNumber(number) }) {
            throw IllegalArgumentException(INVALID_NUMBER_ERROR)
        }
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val SIZE_WITHOUT_BONUS = 6
        const val INVALID_SIZE_ERROR = "[ERROR] 당첨 번호는 보너스 제외 ${SIZE_WITHOUT_BONUS}개여야 합니다."
        const val DUPLICATED_ERROR = "[ERROR] 당첨 번호는 중복되어서는 안됩니다."
        const val INVALID_NUMBER_ERROR = "[ERROR] 올바른 당첨 번호 범위가 아닙니다."
        fun isValidNumber(number: Int) = number in MIN_NUMBER..MAX_NUMBER
    }
}
