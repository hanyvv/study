package chapter02.avoid_collection_modification_while_iteration.before;

import chapter02.avoid_collection_modification_while_iteration.Supply;

import java.util.ArrayList;
import java.util.List;
/*
* P : 컬렉션 순회 중에 데이터의 조작이 발생하는 경우 충돌할 위험이 있음 (ConcurrentModificationException)
* */

public class Inventory {

    private List<Supply> supplies = new ArrayList<>();

    void disposeContaminatedSupplies() {
        for (Supply supply : supplies) {
            if (supply.isContaminated()) {
                supplies.remove(supply);
            }
        }
    }
}
