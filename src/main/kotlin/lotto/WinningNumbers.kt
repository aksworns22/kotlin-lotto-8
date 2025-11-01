package lotto

data class WinningNumbers(val numbers: List<Int>, val bonus: Bonus) {
    init {
        require(numbers.size == SIZE_WITHOUT_BONUS) { INVALID_SIZE_ERROR }
    }

    init {
        val distinctNumbers = getDistinctNumbers()
        require(distinctNumbers.size == SIZE_WITHOUT_BONUS) { DUPLICATED_ERROR }
        require(!distinctNumbers.contains(bonus.number)) { DUPLICATED_WITH_BONUS_ERROR }
    }

    init {
        if (numbers.any { number -> !LottoNumber.isValidNumber(number) }) {
            throw IllegalArgumentException(LottoNumber.INVALID_ERROR)
        }
    }

    private fun getDistinctNumbers(): Set<Int> {
        return numbers.toSet()
    }

    companion object {
        const val SIZE_WITHOUT_BONUS = 6
        const val INVALID_SIZE_ERROR = "[ERROR] 당첨 번호는 보너스 제외 ${SIZE_WITHOUT_BONUS}개여야 합니다."
        const val DUPLICATED_ERROR = "[ERROR] 당첨 번호는 중복되어서는 안됩니다."
        const val DUPLICATED_WITH_BONUS_ERROR = "[ERROR] 당첨 번호와 보너스는 중복되어서는 안됩니다."
    }
}
