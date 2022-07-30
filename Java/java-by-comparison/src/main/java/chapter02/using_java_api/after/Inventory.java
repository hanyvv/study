package chapter02.using_java_api.after;

import chapter02.avoid_collection_modification_while_iteration.Supply;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Inventory {

    private List<Supply> supplies = new ArrayList<>();

    int getQuantity(Supply supply) {
        Objects.requireNonNull(supply, "supply must not be null");
        return Collections.frequency(supplies, supply);

    }
}
