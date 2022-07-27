package chapter02.replace_constant_with_enum.after;

import java.util.Objects;


/*
*  가능한 옵션을 모두 열거할 수 있다면 항상 정수 대신 enum 타입을 사용
*
*
* */
public class CruiseControl {

    private double targetSpeedKmh;

    void setPreset(SpeedPreset speedPreset) {
        Objects.requireNonNull(speedPreset);

        setTargetSpeedKmh(speedPreset.speedKmh);
    }

    void setTargetSpeedKmh(double speed) {
        this.targetSpeedKmh = speed;
    }
}

enum SpeedPreset {
    STOP(0), PLANETARY_SPEED(7667), CRUISE_SPEED(16944),
    ;

    final double speedKmh;

    SpeedPreset(double speedKmh) {
        this.speedKmh = speedKmh;
    }
}
