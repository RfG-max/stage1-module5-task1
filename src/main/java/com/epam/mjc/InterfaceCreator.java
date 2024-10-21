package com.epam.mjc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceCreator {

    public Predicate<List<String>> isValuesStartWithUpperCase() {
        return strings -> {
            for (String s: strings) {
                if (s.isEmpty() || !Character.isUpperCase(s.charAt(0))) {
                    return false;
                }
            }
            return true;
        };
    }

    public Consumer<List<Integer>> addEvenValuesAtTheEnd() {
        return integers -> {
            List<Integer> evenList = new ArrayList<>();
            for (Integer integer: integers) {
                if (integer % 2 == 0){
                    evenList.add(integer);
                }
            }
            integers.addAll(evenList);
        };
    }

    public Supplier<List<String>> filterCollection(List<String> values) {
        {return () -> {
            List<String> resultList = new ArrayList<>();
            for (String s : values
                 ) {
                String[] words = s.trim().split("\\s+");
                if (Character.isUpperCase(s.charAt(0))&&(s.endsWith("."))&&(words.length>3)) {
                    resultList.add(s);
                }
            }
            return resultList;
        };}
    }

    public Function<List<String>, Map<String, Integer>> stringSize() {
        return strings -> {
            Map<String, Integer> map = new HashMap<>();
            for (String str : strings) {
                map.put(str, str.length());
            }
            return map;
        };
    }

    public BiFunction<List<Integer>, List<Integer>, List<Integer>> concatList() {
        { return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }
    }
}
