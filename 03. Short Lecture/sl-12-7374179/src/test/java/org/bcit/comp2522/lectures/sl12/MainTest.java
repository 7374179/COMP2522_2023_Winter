package org.bcit.comp2522.lectures.sl12;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
  @Test
  void sum() {
    Main main = new Main();
    int[] nums = new int[3];
    for (int i = 0; i < 3; i++) {
      nums[i] = i + 1;
    }
    long sum = main.sum(nums);
    assertEquals(6, sum);
  }

  @Test
  void sumSlice() {
    Main main = new Main();
    int[] nums = new int[3];
    for (int i = 0; i < 3; i++) {
      nums[i] = i + 1;
    }
    long sum1 = main.sum(nums,0,1);
    assertEquals(1, sum1);
    long sum2 = main.sum(nums,0,2);
    assertEquals(3, sum2);
    long sum3 = main.sum(nums,0,3);
    assertEquals(6, sum3);
  }

}