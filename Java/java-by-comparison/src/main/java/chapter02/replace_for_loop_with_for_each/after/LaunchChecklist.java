package chapter02.replace_for_loop_with_for_each.after;

import chapter02.replace_for_loop_with_for_each.Commander;
import chapter02.replace_for_loop_with_for_each.Status;

import java.util.Arrays;
import java.util.List;

public class LaunchChecklist {

    List<String> checks = Arrays.asList("Cabin Pressure", "Communication", "Engine");

    Status prepareForTakeoff(Commander commander) {
        for (String check : checks) {
            boolean shouldAbortTakeoff = commander.isFailing(check);
            if (shouldAbortTakeoff) {
                return Status.ABORT_TAKE_OFF;
            }
        }
        return Status.READY_FOR_TAKE_OFF;
    }
}
