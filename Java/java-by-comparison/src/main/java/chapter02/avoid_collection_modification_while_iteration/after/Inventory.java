package chapter02.avoid_collection_modification_while_iteration.after;

import chapter02.avoid_collection_modification_while_iteration.Supply;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/*
* S : Iterator 활용
* */

public class Inventory {

    private List<Supply> supplies = new ArrayList<>();

    void disposeContaminatedSupplies() {
        Iterator<Supply> iterator = supplies.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().isContaminated()) {
                iterator.remove();
            }
        }
    }
}
