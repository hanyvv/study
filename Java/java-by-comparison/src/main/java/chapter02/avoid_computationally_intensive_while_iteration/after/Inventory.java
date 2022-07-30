package chapter02.avoid_computationally_intensive_while_iteration.after;

import chapter02.avoid_collection_modification_while_iteration.Supply;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Pattern;

/*
* S : 메서드를 호출할 때 정규식을 한 번만 컴파일
* */

public class Inventory {

    private List<Supply> supplies = new ArrayList<>();

    List<Supply> find(String regex) {
        List<Supply> result = new LinkedList<>();
        Pattern pattern = Pattern.compile(regex);
        for (Supply supply : supplies) {
            if (pattern.matcher(supply.toString()).matches()) {
                result.add(supply);
            }
        }
        return result;
    }
}
