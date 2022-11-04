package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class DigitBaseballGame {
    private final List<Integer> answer;

    public DigitBaseballGame() {
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!digits.contains(randomNumber)) {
                digits.add(randomNumber);
            }
        }
        answer = digits;
    }

    public List<Integer> getAnswer() {
        return answer;
    }
}
