package lotto.component

@JvmInline
value class Prize(val money: Long) {
    override fun toString(): String {
        return String.format("%,d", money)
    }
}
