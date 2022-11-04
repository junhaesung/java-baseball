package baseball;

import camp.nextstep.edu.missionutils.Console;

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
}
