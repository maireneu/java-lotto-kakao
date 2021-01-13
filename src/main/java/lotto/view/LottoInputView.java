package lotto.view;

import lotto.domain.LottoNo;
import lotto.domain.LottoTicket;
import lotto.domain.PurchaseList;
import lotto.domain.Validation;

import java.util.*;
import java.util.stream.Collectors;

public class LottoInputView {

    private static Scanner sc = new Scanner(System.in);

    public static int inputMoney() {
        String money;

        do {
            System.out.println("구입금액을 입력해 주세요.");
            money = sc.nextLine();
        } while(!validateMoney(money));

        return Integer.parseInt(money);
    }

    private static boolean validateMoney(String inputMoney) {
        int money = convertStringToInt(inputMoney);
        if( !PurchaseList.validateInputMoney(money) ) {
            System.out.println("잘못된 금액을 입력하셨습니다.");
            return false;
        }
        return true;
    }

    private static Integer convertStringToInt(String inputMoney) {
        try {
            return Integer.parseInt(inputMoney);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static Set<Integer> inputLottoNumbers(String printText) {
        Set<Integer> nums;
        do{
            System.out.println(printText);
            nums = convertInputToNumbers(sc.nextLine().split(", "));
        }while(!validateWinningNumber(nums));
        return nums;
    }

    private static Set<Integer> convertInputToNumbers(String[] inputString) {
        try {
            return Arrays.stream(inputString)
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return new HashSet<>();
    }

    private static boolean validateWinningNumber(Set<Integer> numbers){
        if( !Validation.validateLottoTicket(numbers) ) {
            System.out.println("로또 번호가 적절하지 않습니다.");
            return false;
        }

        return true;
    }

    public static int inputBonusNumber() {
        String bonusNum;
        do{
            System.out.println("보너스 볼을 입력해 주세요.");
            bonusNum = sc.nextLine();
        }while(!validateBonusNumber(bonusNum));
        System.out.println();
        return Integer.parseInt(bonusNum);
    }

    private static boolean validateBonusNumber(String inputBonus){
        int bonusNum = convertStringToInt(inputBonus);
        if( !Validation.validateLottoNo(bonusNum) ) {
            System.out.println("보너스볼 번호가 적절하지 않습니다.");
            return false;
        }

        return true;
    }

    public static int inputManualLottoBuying() {
        String count;
        do {
            System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
            count = sc.nextLine();
        }while(!validateManualCount(count));
        return Integer.parseInt(count);
    }

    private static boolean validateManualCount(String inputCount) {
        int count = convertStringToInt(inputCount);
        if( count < 0 ) {
            System.out.println("잘못된 수를 입력하셨습니다.");
            return false;
        }
        return true;
    }

}
