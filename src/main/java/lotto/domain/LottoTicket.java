package lotto.domain;

import java.util.*;

public class LottoTicket {

    public static final int LOTTO_NUMBER_COUNT_OF_TICKET = 6;
    public static final int LOTTO_PRICE = 1000;

    private List<LottoNo> numbers = new ArrayList<>();

    public LottoTicket(Set<Integer> numbers) {

        if( !validateLottoTicket(numbers) ) {
            throw new IllegalArgumentException("잘못된 로또 티켓 번호입니다.");
        }

        for( int number : numbers ) {
            this.numbers.add(LottoNo.of(number));
        }
        Collections.sort(this.numbers);
    }

    public static boolean validateLottoTicket(final Set<Integer> numbers) {
        return numbers.size() == LOTTO_NUMBER_COUNT_OF_TICKET;
    }

    public boolean isContains(LottoNo lottoNo) {
        return this.numbers.contains(lottoNo);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
    }
}
