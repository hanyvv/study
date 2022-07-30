package chapter02.using_java_api.before;

import chapter02.avoid_collection_modification_while_iteration.Supply;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    private List<Supply> supplies = new ArrayList<>();

    int getQuantity(Supply supply) {
        if (supply == null) {
            throw new NullPointerException("supply must not be null");
        }
        int quantity = 0;
        for (Supply supplyInStock : supplies) {
            if (supply.equals(supplyInStock)) {
                quantity++;
            }
        }
        return quantity;
    }
}
