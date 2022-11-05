package baseball;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DigitBaseballGameTest {
    @DisplayName("게임은 정답을 가지고 있습니다")
    @Test
    void testGameHasAnswer() {
        DigitBaseballGame digitBaseballGame = new DigitBaseballGame();
        List<Integer> answer = digitBaseballGame.getAnswer();
        assertThat(answer).hasSize(3);
    }

    @DisplayName("정답에는 중복된 숫자가 포함되지 않는다")
    @Test
    void testAnswerHasUniqueNumber() {
        DigitBaseballGame digitBaseballGame = new DigitBaseballGame();
        List<Integer> answer = digitBaseballGame.getAnswer();
        assertThat(Sets.newHashSet(answer)).hasSize(3);
    }

    @DisplayName("문자열을 입력시 스트라이크 점수를 계산한다")
    @Test
    void calculateStrikeScore() throws NoSuchFieldException, IllegalAccessException {
        DigitBaseballGame digitBaseballGame = new DigitBaseballGame();

        Field field = DigitBaseballGame.class.getDeclaredField("answer");
        field.setAccessible(true);
        field.set(digitBaseballGame, List.of(1, 2, 3));
        assertThat(digitBaseballGame.calculateScore("123").isThreeStrike()).isEqualTo(true);
        assertThat(digitBaseballGame.calculateScore("723").isTwoStrike()).isEqualTo(true);
        assertThat(digitBaseballGame.calculateScore("763").isOneStrike()).isEqualTo(true);
        assertThat(digitBaseballGame.calculateScore("765").isZeroStrike()).isEqualTo(true);
    }

    @DisplayName("문자열을 입력시 볼 점수를 계산한다")
    @Test
    void calculateBallScore() throws NoSuchFieldException, IllegalAccessException {
        DigitBaseballGame digitBaseballGame = new DigitBaseballGame();

        Field field = DigitBaseballGame.class.getDeclaredField("answer");
        field.setAccessible(true);
        field.set(digitBaseballGame, List.of(1, 2, 3));
        assertThat(digitBaseballGame.calculateScore("781").isOneBall()).isEqualTo(true);
        assertThat(digitBaseballGame.calculateScore("731").isTwoBall()).isEqualTo(true);
        assertThat(digitBaseballGame.calculateScore("231").isThreeBall()).isEqualTo(true);
        assertThat(digitBaseballGame.calculateScore("689").isZeroBall()).isEqualTo(true);
    }
}