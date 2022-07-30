package ch14.optional;

import java.util.Optional;

public class Ex14_0 {
    public static void main(String[] args) {
        //int[] arr = null; //초기화 null로 X
        int[] arr = {};
        System.out.println("arr.length = " + arr.length);

        //Optional<String> opt = null; //OK. but 바람직 X
        Optional<String> opt = Optional.empty();
       // Optional<String> opt = Optional.of("abc");
        System.out.println("opt = " + opt);
       // System.out.println("opt.get() = " + opt.get()); get()은 잘 안씀

//        String str = opt.orElse(""); //Optional에 저장된 값이 null이면 "" 반환
        String str = opt.orElseGet(() -> "");
        System.out.println("str = " + str);
    }
}
