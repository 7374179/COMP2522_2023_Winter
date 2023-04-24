package org.bcit.comp2522.lectures.ll09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lambda {
  Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

  int add(int a, int b) {
    return a + b;
  }

  int add(int a, int b, int c) {
    return a + b + c;
  }

  int add(int a, int b, int c, int d) {
    return a + b + c + d;
  }

  int add(Integer[] args) {
    return Arrays.stream(args).reduce(0, (x, y) -> x + y);
  }

  int add(int... args) {
    return Arrays.stream(args).reduce(0, (x, y) -> x + y);
  }

  int mult(int... args) {
    return Arrays.stream(args).reduce(1, (x, y) -> x * y);
  }

  public static void main(String[] args) {
//    Integer[] nums = {1, 2, 3, 4, 5, 6};
//    ArrayList<Integer> numbers = new ArrayList<Integer>(Arrays.asList(nums));
//    numbers.forEach(n -> System.out.println(n));
//
//    String[] strs = {"1", "2", "3", "4", "5", "6"};
//    ArrayList<String> strings = new ArrayList<String>(Arrays.asList(strs));
//    strings.stream()
//        .map(n -> Integer.parseInt(n))
//        .filter(n -> n % 2 == 0)
//        .map(n -> n.toString())
//        .forEach(n -> System.out.println(n));
//
//    strings.stream().reduce(
//        "", (acc, s) -> acc + s
//    );
//
////    " "+"1" + "2"+ "3"+"4"+"5"+"6"
//
////    list of list of Integer -> list of Integer
//
//    Integer[] l1 = {1, 2, 3};
//    Integer[] l2 = {4, 5, 6};
//    List<List<Integer>> lol = new ArrayList<>();
//    lol.add(Arrays.stream(l1).toList());
//    lol.add(Arrays.stream(l2).toList());
//    System.out.println(lol);
//    List<Integer> out = lol.stream().reduce(
//        new ArrayList<Integer>(),
//        (acc, list) -> {
//          acc.addAll(list);
//          return acc;
//        }
//    );
//    System.out.println(out);
//
//
//    List<Integer> squares = numbers.stream()
//        .map(n -> n * n)
//        .collect(Collectors.toList());
//
//    System.out.println(squares);
//
//
//    List<Integer> evens = numbers.stream()
//        .filter(n -> n % 2 == 0)
//        .collect(Collectors.toList());
//
//
//    interface StrInt {
//      String apply(String sr, int i);
//    }
//
//    StrInt index = (str, i) -> String.valueOf(str.charAt(i));
//
//    StrInt repeat = (str, i) -> {
//      String acc = "";
//      for (int k = 0; k < i; k++) {
//        acc = acc + str;
//      }
//      return acc;
//    };
//
//    StrInt del = (str, i) -> str.substring(0, i) + str.substring(i + 1, str.length());
//    System.out.println(index.apply("OK3", 2));
//    System.out.println(repeat.apply("OK3", 2));
//    System.out.println(del.apply("OK3", 2));


  }

}
