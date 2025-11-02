package lotto

data class WinningNumbers(val numbers: RegularNumbers, val bonus: Bonus) {
    init {
        require(!numbers.contains(bonus.number)) { DUPLICATED_WITH_BONUS_ERROR }
    }

    companion object {
        const val DUPLICATED_WITH_BONUS_ERROR = "[ERROR] 당첨 번호와 보너스는 중복되어서는 안됩니다."
    }
}

@JvmInline
value class RegularNumbers(val numbers: List<Int>) {
    init {
        require(numbers.size == SIZE_WITHOUT_BONUS) { INVALID_SIZE_ERROR }
    }

    init {
        if (numbers.any { number -> !LottoNumber.isValidNumber(number) }) {
            throw IllegalArgumentException(LottoNumber.INVALID_ERROR)
        }
    }

    init {
        require(getDistinctNumbers().size == SIZE_WITHOUT_BONUS) { DUPLICATED_ERROR }
    }

    private fun getDistinctNumbers(): Set<Int> = numbers.toSet()

    fun contains(number: Int) = getDistinctNumbers().contains(number)

    companion object {
        const val SIZE_WITHOUT_BONUS = 6
        const val INVALID_SIZE_ERROR = "[ERROR] 당첨 번호는 보너스 제외 ${SIZE_WITHOUT_BONUS}개여야 합니다."
        const val DUPLICATED_ERROR = "[ERROR] 정규 번호는 중복되어서는 안됩니다."
    }
}

