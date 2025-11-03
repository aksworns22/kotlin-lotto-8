package lotto

import lotto.component.Bonus
import lotto.component.RegularNumbers

data class WinningNumbers(val numbers: RegularNumbers, val bonus: Bonus) {
    init {
        require(!numbers.contains(bonus.number)) { DUPLICATED_WITH_BONUS_ERROR_MESSAGE }
    }

    fun hasRegular(number: Int) = numbers.contains(number)
    fun isBonusMatch(number: Int): Boolean = bonus.number == number

    companion object {
        const val DUPLICATED_WITH_BONUS_ERROR_MESSAGE = "[ERROR] 당첨 번호와 보너스는 중복되어서는 안됩니다."
    }
}
