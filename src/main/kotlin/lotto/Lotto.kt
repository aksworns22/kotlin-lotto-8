package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }

    init {
        require(numbers.distinct().size == LOTTO_SIZE) { "[ERROR] 로또 번호는 중복되어서는 안됩니다." }
    }

    companion object {
        const val LOTTO_SIZE = 6
    }
}
