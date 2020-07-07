package Apples;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.testng.annotations.AfterTest;

class AppleTest {

  @Test
  void getApple() {
    Apple apple = new Apple();
    assertEquals("appple", apple.getApple());
  }
}