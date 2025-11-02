package lotto.util

import camp.nextstep.edu.missionutils.Randoms

interface RandomGenerator {
    fun pickUniqueNumbersInRange(minNumber: Int, maxNumber: Int, count: Int): List<Int>
}

object UniqueRandomGenerator : RandomGenerator {
    override fun pickUniqueNumbersInRange(minNumber: Int, maxNumber: Int, count: Int): List<Int> {
        return Randoms.pickUniqueNumbersInRange(minNumber, maxNumber, count)
    }
}

class FakeRandomGenerator(randomNumbers: List<List<Int>>) : RandomGenerator {
    private val iterator = randomNumbers.iterator()
    override fun pickUniqueNumbersInRange(minNumber: Int, maxNumber: Int, count: Int): List<Int> {
        return iterator.next()
    }
}
