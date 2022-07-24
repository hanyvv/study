package chapter01.return_bool_expression.before;

public class Astronaut {

    String name;
    int missions;

    boolean isValid() {
        if (missions < 0 || name == null || name.trim().isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}
