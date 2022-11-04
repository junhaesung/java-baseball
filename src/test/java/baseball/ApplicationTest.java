package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Disabled
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력값에 숫자가 아닌 문자가 포함되면 예외 발생")
    @Test
    void testArgumentContainsCharacter() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("랜덤 3자리 숫자를 잘 생성한다")
    @Test
    void 컴퓨터_숫자_테스트(){
        assertThat(Application.getRandomDigit()).hasSize(3);
    }

    @DisplayName("랜덤 3자리 숫자에는 중복이 포함되지 않는다")
    @Test
    void 컴퓨터_숫자_중복_테스트(){
        List<Integer> randomNumber= Application.getRandomDigit();
        assertThat(Sets.newHashSet(randomNumber)).hasSize(3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
