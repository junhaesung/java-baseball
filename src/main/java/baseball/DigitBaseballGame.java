package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

    public Score calculateScore(String s) {
        List<Integer> playerChoices = Arrays.stream(s.split(""))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int strikeCount = countStrike(playerChoices);
        int ballCount = countBall(playerChoices);
        return new Score(ballCount, strikeCount);
    }

    private int countStrike(List<Integer> playerChoices) {
        return IntStream.range(0, 3)
                .reduce(0, (total, index) -> calculateStrike(total, index, playerChoices));
    }

    private int calculateStrike(int total, int index, List<Integer> playerChoices) {
        if (Objects.equals(playerChoices.get(index), answer.get(index))) {
            return total + 1;
        }
        return total;
    }

    private int countBall(List<Integer> playerChoices) {
        return IntStream.range(0, 3)
                .reduce(0, (total, i) -> calculateBall(total, i, playerChoices));
    }

    private int calculateBall(int total, int index, List<Integer> playerChoices) {
        if (isBall(playerChoices.get(index), index)) {
            return total + 1;
        }
        return total;
    }

    private boolean isBall(int value, int index) {
        if (value == answer.get(index)) {
            return false;
        }
        return answer.contains(value);
    }
}
