package lotto

import lotto.result.PurchaseResult
import lotto.result.RankResult
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.withPrecision
import org.junit.jupiter.api.Test

class ProfitTest {
    @Test
    fun `구매한 모든 로또를 통해 수익률을 계산한다`() {
        val rankResult = RankResult.of(listOf(Rank.FIFTH))
        val purchaseResult = PurchaseResult(8)
        assertThat(Profit(rankResult, purchaseResult).rate)
            .isEqualTo(0.625, withPrecision(0.0001))
    }
}
