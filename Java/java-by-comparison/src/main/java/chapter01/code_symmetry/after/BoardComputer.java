package chapter01.code_symmetry.after;

import chapter01.common.CruiseControl;
import chapter01.common.User;

import java.util.Objects;

public class BoardComputer {

    CruiseControl cruiseControl;

    void authorize(User user) {
        Objects.requireNonNull(user);
        if (user.isUnknown()) {
            cruiseControl.logUnauthorizedAccessAttempt();
            return;
        }

        if (user.isAstronaut()) {
            cruiseControl.grantAccess(user);
        } else if (user.isCommander()) {
            cruiseControl.grantAccess(user);
            cruiseControl.grantAdminAccess(user);
        }
    }

}
