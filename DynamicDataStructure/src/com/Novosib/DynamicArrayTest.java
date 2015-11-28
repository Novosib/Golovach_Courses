package com.Novosib;

import java.util.Arrays;

/**
 * Created by AdminAccount on 22.11.2015.
 */
public class DynamicArrayTest {

    public static void main(String[] args) {
        DynamicArray dynArray = new DynamicArray();
        System.out.println(Arrays.toString(dynArray.data));

        dynArray.add(10);
        dynArray.add(20);
        dynArray.add(30);
        dynArray.add(40);
        dynArray.add(50);
        System.out.println(Arrays.toString(dynArray.data));

        dynArray.remove();
        System.out.println(Arrays.toString(dynArray.data));

        dynArray.remove(2);
        System.out.println(Arrays.toString(dynArray.data));

        dynArray.add(1, 0);
        System.out.println(Arrays.toString(dynArray.data));
    }
}
