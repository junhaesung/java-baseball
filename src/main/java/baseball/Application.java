package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

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
    private static boolean isDigit(String input) {
        return DIGIT_PATTERN.matcher(input).matches();
    }

    public static List<Integer> getRandomDigit(){
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
