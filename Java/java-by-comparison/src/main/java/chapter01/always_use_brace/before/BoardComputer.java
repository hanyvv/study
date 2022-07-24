package chapter01.always_use_brace.before;

import chapter01.common.CruiseControl;
import chapter01.common.User;

import java.util.Objects;

public class BoardComputer {

    CruiseControl cruiseControl;

    void authorize(User user) {
        Objects.requireNonNull(user);

        if (user.isUnknown())
            cruiseControl.logUnauthorizedAccessAttempt();
        if (user.isAstronaut())
            cruiseControl.grantAccess(user);
        if (user.isCommander())
            cruiseControl.grantAccess(user);
            cruiseControl.grantAdminAccess(user);
    }
}
