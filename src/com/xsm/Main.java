package com.xsm;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Function<Integer, Integer> f = status -> Objects.equals(status, 1) ? status : 2;
        Integer apply = f.apply(1);
        System.out.println(apply);

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        for (int i = 0; i < list.size(); i ++){
            System.out.println(list.get(i));
        }

        ////
    }
}
