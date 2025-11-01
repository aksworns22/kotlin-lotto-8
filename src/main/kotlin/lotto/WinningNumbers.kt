package lotto

data class WinningNumbers(val numbers: List<Int>, val bonus: Bonus) {
    init {
        require(numbers.size == SIZE_WITHOUT_BONUS) { INVALID_SIZE_ERROR }
    }

    init {
        require(numbers.distinct().size == SIZE_WITHOUT_BONUS) { DUPLICATED_ERROR }
    }

    companion object {
        const val SIZE_WITHOUT_BONUS = 6
        const val INVALID_SIZE_ERROR = "[ERROR] 당첨 번호는 보너스 제외 ${SIZE_WITHOUT_BONUS}개여야 합니다."
        const val DUPLICATED_ERROR = "[ERROR] 당첨 번호는 중복되어서는 안됩니다."
    }
}
