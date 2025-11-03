package lotto

import lotto.component.LottoNumber
import lotto.result.PurchaseResult
import lotto.util.RandomGenerator

fun List<Lotto>.print() {
    this.forEach { lotto ->
        println(lotto.toString())
    }
    println()
}

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == SIZE) { SIZE_ERROR }
    }

    init {
        require(numbers.distinct().size == SIZE) { DUPLICATED_NUMBER_ERROR_MESSAGE }
    }

    init {
        if (numbers.any { number -> !LottoNumber.isValidNumber(number) }) {
            throw IllegalArgumentException(LottoNumber.INVALID_ERROR_MESSAGE)
        }
    }

    override fun toString(): String {
        val sortedNumbers = numbers.sorted()
        return sortedNumbers.toString()
    }

    fun countRegularMatches(winningNumbers: WinningNumbers): Int {
        return numbers.count { number -> winningNumbers.hasRegular(number) }
    }

    fun isBonusMatch(winningNumbers: WinningNumbers): Boolean {
        return numbers.any { number -> winningNumbers.isBonusMatch(number) }
    }

    companion object {
        const val SIZE = 6
        const val DUPLICATED_NUMBER_ERROR_MESSAGE = "[ERROR] 로또 번호는 중복되어서는 안됩니다."
        const val SIZE_ERROR = "[ERROR] 로또 번호는 ${SIZE}개여야 합니다."
        const val MATCH_6 = 6
        const val MATCH_5 = 5
        const val MATCH_4 = 4
        const val MATCH_3 = 3
        const val MATCH_2 = 2
        const val MATCH_1 = 1
        const val MATCH_0 = 0
        fun from(randomGenerator: RandomGenerator): Lotto {
            val minNumber = LottoNumber.MIN_NUMBER
            val maxNumber = LottoNumber.MAX_NUMBER
            val randomNumbers = randomGenerator.pickUniqueNumbersInRange(minNumber, maxNumber, SIZE)
            return Lotto(randomNumbers)
        }

        fun from(randomGenerator: RandomGenerator, numberOfLotto: PurchaseResult): List<Lotto> {
            return (0..<numberOfLotto.count).map { from(randomGenerator) }
        }
    }
}
