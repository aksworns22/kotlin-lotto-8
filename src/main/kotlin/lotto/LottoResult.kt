package lotto

data class LottoResult(val matchCount: Int, val bonusMatch: Boolean) {
    companion object {
        fun of(lotto: Lotto, winningNumbers: WinningNumbers): LottoResult {
            val regularMatchCount = lotto.countRegularMatches(winningNumbers)
            val bonusMatched = lotto.isBonusMatch(winningNumbers)
            return LottoResult(regularMatchCount, bonusMatched)
        }
    }
}
