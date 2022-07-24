package chapter01.return_bool_expression.after;

public class Astronaut {

    String name;
    int missions;

    boolean isValid() {
        boolean isValidMissions = missions >= 0;
        boolean isValidName = name != null && !name.trim().isEmpty();
        return isValidMissions && isValidName;
    }
}
