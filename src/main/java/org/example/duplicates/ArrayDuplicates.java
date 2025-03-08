package org.example.duplicates;

import java.util.*;

public class ArrayDuplicates {

    /*
    Diferenta dintre Arrays.asList() vs new ArrayList<>(Arrasy.asList());
     */
    public static void main(String[] args) {
        List<Integer> immutableList = Arrays.asList(1, 2, 3, 4, 5); // sinonim cu unmodifible
        // imutable list = este o lista constanta
//        immutableList.add(66);
//        immutableList.remove(0);
        System.out.println(immutableList + "\n");

        List<Integer> mutableList = new ArrayList<>(immutableList);
        // mutable list = este o lista asupra careia putem face operatii de add, remove, update
        System.out.println(mutableList);    // 1 2 3 4 5
        mutableList.add(6);
        System.out.println(mutableList);    // 1 2 3 4 5 6
        mutableList.remove(1);
        System.out.println(mutableList);    // 1 3 4 5 6
    }


    public static String[] removeDuplicates(String[] input) {
        Set<String> set = new LinkedHashSet<>(Arrays.asList(input));
//        System.out.println(set);
        return set.toArray(new String[0]);
    }
}
