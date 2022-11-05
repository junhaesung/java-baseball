package baseball;

public class Score {
    private final Ball ball;
    private final Strike strike;


    public Score(int ball, int strike) {
        this.ball = Ball.from(ball);
        this.strike = Strike.from(strike);
    }

    public boolean isOneBall() {
        return ball == Ball.ONE;
    }

    public boolean isTwoBall() {
        return ball == Ball.TWO;
    }

    public boolean isThreeBall() {
        return ball == Ball.THREE;
    }

    public boolean isOneStrike() {
        return strike == Strike.ONE;
    }

    public boolean isTwoStrike() {
        return strike == Strike.TWO;
    }

    public boolean isThreeStrike() {
        return strike == Strike.THREE;
    }

    public boolean isZeroStrike() {
        return strike == Strike.ZERO;
    }

    public boolean isZeroBall() {
        return ball == Ball.ZERO;
    }
}
