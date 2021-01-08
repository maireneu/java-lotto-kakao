package lotto.domain;

import lotto.StatisticsType;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoLogicTest {

    @Test
    void lottoNosLengthValidTest() {
        List<LottoTicket> lottoTickets = LottoLogic.buyLottoTicketsAuto(10);
        assertThat(lottoTickets.size()).isEqualTo(10);
    }

    @Test
    void statisticTest() {
        WinningLottoNos winningLottoNos = new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        LottoTicket lottoTicket2 = new LottoTicket(Arrays.asList(1, 2, 9, 10, 11, 12)); // 2
        LottoTicket lottoTicket3 = new LottoTicket(Arrays.asList(1, 2, 3, 9, 10, 11)); // 3
        LottoTicket lottoTicket4 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 10, 11)); // 4
        LottoTicket lottoTicket5 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 8)); // 5
        LottoTicket lottoTicket5_1 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7)); // 5,1
        LottoTicket lottoTicket6 = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6)); // 6

    }

    @Test
    void winningStatisticsTest() {
        WinningLottoNos winningLottoNos = new WinningLottoNos(Arrays.asList(1, 2, 3, 4, 5, 6), 7);
        List<LottoTicket> lottoTickets = Arrays.asList(
                new LottoTicket(Arrays.asList(1, 2, 9, 10, 11, 12))
                , new LottoTicket(Arrays.asList(1, 2, 3, 9, 10, 11))
                , new LottoTicket(Arrays.asList(1, 2, 3, 4, 10, 11))
                , new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 8))
                , new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 7))
                , new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6))
        );
        StatisticsResult statisticsResult = new StatisticsResult();
        statisticsResult.increaseTypeCount(StatisticsType.NONE);
        statisticsResult.increaseTypeCount(StatisticsType.THREE);
        statisticsResult.increaseTypeCount(StatisticsType.FOUR);
        statisticsResult.increaseTypeCount(StatisticsType.FIVE);
        statisticsResult.increaseTypeCount(StatisticsType.FIVE_WITH_BONUS);
        statisticsResult.increaseTypeCount(StatisticsType.SIX);

        assertThat(LottoLogic.winningStatistics(lottoTickets, winningLottoNos))
                .isEqualTo(statisticsResult);

    }

}
