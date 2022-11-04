package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 * 숫자 야구 앱
 */
public class Application {
    private static final Pattern DIGIT_PATTERN = Pattern.compile("\\d[1,3]");

    public static void main(String[] args) {
        String input = Console.readLine();
        if (input.length() > 3) {
            throw new IllegalArgumentException("입력값의 길이는 3글자 이하이어야 합니다. ");
        }
        if (!isDigit(input)) {
            throw new IllegalArgumentException("입력값에는 숫자(0~9)만 포함되어야 합니다. ");
        }

    }

    /**
     * 주어진 문자열이 3자리 숫자로만 이루어져있는지 검사
     * @param input 입력한 정답 후보
     * @return 주어진 문자열이 3자리 숫자로만 이루어져있는지 여부
     */
    private static boolean isDigit(String input) {
        return DIGIT_PATTERN.matcher(input).matches();
    }

    /**
     * 숫자야구 정답을 생성
     * @return 크기가 3인 숫자 리스트
     */
    public static List<Integer> getAnswer(){
        List<Integer> digits = new ArrayList<>();
        while (digits.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!digits.contains(randomNumber)) {
                digits.add(randomNumber);
            }
        }
        return digits;
    }
}
