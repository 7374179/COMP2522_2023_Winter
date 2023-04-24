package org.bcit.comp2522.lectures.ll08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
@TestInstance(TestInstance.Lifecycle.PER_CLASS)

class MyDictionaryTest {
  Dictionary dictionary;


  @BeforeAll
  void setup() {
    dictionary = new Dictionary();
  }

  @Test
  void duplicateTest() throws DuplicateKeyException {
      dictionary.add("Hello", "World");
      assertThrows(DuplicateKeyException.class, () -> {
        dictionary.add("Hello", "Nobody");
      });
  }

}