package org.bcit.comp2522.lectures.ll08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyDictionaryTest {
  Dictionary dictionary;

  @BeforeAll
  void setup() {
    dictionary = new Dictionary();
  }

  @Test
  void duplicateTest() {
    dictionary.add("Hello", "World");
    assertThrows(DuplicateKeyException.class, () -> {
      dictionary.add("Hello", "Nobody");
    });
  }

}