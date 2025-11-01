package lotto

import lotto.Lotto.Companion.LOTTO_SIZE

data class WinningNumbers(val numbers: List<Int>, val bonus: Bonus) {
    init {
        require(numbers.size == SIZE_WITHOUT_BONUS) { INVALID_SIZE_ERROR }
    }

    companion object {
        const val SIZE_WITHOUT_BONUS = 6
        const val INVALID_SIZE_ERROR = "[ERROR] 당첨 번호는 보너스 제외 ${SIZE_WITHOUT_BONUS}개여야 합니다."
    }
}
