package chapter02.replace_magic_number_with_constant.before;

/*
 * P : 1. speedPreset 의 값을 넣을려면 메서드 내부에 대한 정교한 지식이 필요
 *     2. 어떤 설정을 쓸 수 있는지 알려주지 않으니 옵션을 외울 수 밖에 없음
 * 매직 넘버를 사용하는 코드는 이해하기 어려움
 *
 * */
public class CruiseControl {

    private double targetSpeedKmh;

    void setPreset(int speedPreset) {
        if (speedPreset == 2) {
            setTargetSpeedKmh(16944);
        } else if (speedPreset == 1) {
            setTargetSpeedKmh(7667);
        } else if (speedPreset == 0) {
            setTargetSpeedKmh(0);
        }
    }

    void setTargetSpeedKmh(double speed) {
        targetSpeedKmh = speed;
    }
}
