package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) { LOTTO_SIZE_ERROR }
    }

    init {
        require(numbers.distinct().size == LOTTO_SIZE) { DUPLICATED_LOTTO_NUMBER_ERROR }
    }

    init {
        if (numbers.any { number -> !LottoNumber.isValidNumber(number) }) {
            throw IllegalArgumentException(LottoNumber.INVALID_ERROR)
        }
    }

    companion object {
        const val LOTTO_SIZE = 6
        const val DUPLICATED_LOTTO_NUMBER_ERROR = "[ERROR] 로또 번호는 중복되어서는 안됩니다."
        const val LOTTO_SIZE_ERROR = "[ERROR] 로또 번호는 ${LOTTO_SIZE}개여야 합니다."
    }
}
