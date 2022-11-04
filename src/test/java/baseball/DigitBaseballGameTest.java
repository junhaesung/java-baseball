package baseball;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    void testAnswerHasUniqueNumber(){
        DigitBaseballGame digitBaseballGame = new DigitBaseballGame();
        List<Integer> answer = digitBaseballGame.getAnswer();
        assertThat(Sets.newHashSet(answer)).hasSize(3);
    }

}