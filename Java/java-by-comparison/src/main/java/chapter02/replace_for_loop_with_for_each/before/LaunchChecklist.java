package chapter02.replace_for_loop_with_for_each.before;

import chapter02.replace_for_loop_with_for_each.Commander;
import chapter02.replace_for_loop_with_for_each.Status;

import java.util.Arrays;
import java.util.List;

public class LaunchChecklist {

    List<String> checks = Arrays.asList("Cabin Pressure", "Communication", "Engine");

    Status prepareForTakeoff(Commander commander) {
        for (int i = 0; i < checks.size(); i++) {
            boolean shouldAbortTakeoff = commander.isFailing(checks.get(i));
            if (shouldAbortTakeoff) {
                return Status.ABORT_TAKE_OFF;
            }
        }
        return Status.READY_FOR_TAKE_OFF;
    }
}
