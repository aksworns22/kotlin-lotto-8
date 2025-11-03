package lotto.component

@JvmInline
value class RegularNumbers(val numbers: List<Int>) {
    init {
        require(numbers.size == SIZE) { INVALID_SIZE_ERROR_MESSAGE }
    }

    init {
        if (numbers.any { number -> !LottoNumber.isValidNumber(number) }) {
            throw IllegalArgumentException(LottoNumber.INVALID_ERROR_MESSAGE)
        }
    }

    init {
        require(getDistinctNumbers().size == SIZE) { DUPLICATED_ERROR_MESSAGE }
    }

    private fun getDistinctNumbers(): Set<Int> = numbers.toSet()

    fun contains(number: Int) = getDistinctNumbers().contains(number)

    companion object {
        const val SIZE = 6
        const val INVALID_SIZE_ERROR_MESSAGE = "[ERROR] 당첨 번호는 보너스 제외 ${SIZE}개여야 합니다."
        const val DUPLICATED_ERROR_MESSAGE = "[ERROR] 정규 번호는 중복되어서는 안됩니다."
        fun from(input: List<String>): RegularNumbers {
            val trimmedInput = input.map { rawInput -> rawInput.trim() }
            val numbers = trimmedInput.map { number ->
                number.toIntOrNull() ?: throw IllegalArgumentException(LottoNumber.NOT_NUMBER_ERROR_MESSAGE)
            }
            if (numbers.any { number -> !LottoNumber.isValidNumber(number) }) {
                throw IllegalArgumentException(LottoNumber.INVALID_ERROR_MESSAGE)
            }
            return RegularNumbers(numbers)
        }
    }
}
