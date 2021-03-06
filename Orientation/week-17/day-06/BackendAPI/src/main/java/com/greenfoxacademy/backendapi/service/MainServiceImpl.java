package com.greenfoxacademy.backendapi.service;

import com.greenfoxacademy.backendapi.dto.ArrayAction;
import com.greenfoxacademy.backendapi.dto.ArrayResult;
import com.greenfoxacademy.backendapi.dto.Result;
import com.greenfoxacademy.backendapi.dto.Doubling;
import com.greenfoxacademy.backendapi.dto.Error;
import com.greenfoxacademy.backendapi.dto.Greeter;
import java.util.Arrays;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class MainServiceImpl implements MainService {

  @Override
  public Object doubling(Integer integerToDouble) {
    if (integerToDouble == null) {
      return new Error("Please provide an input!");
    } else {
      return new Doubling(integerToDouble);
    }
  }

  @Override
  public ResponseEntity<Object> greeter(String name, String title) {
    if (name == null || title == null) {
      return new ResponseEntity<>(handleGreetNullPointer(name, title), HttpStatus.BAD_REQUEST);
    } else {
      return ResponseEntity.ok()
          .body(new Greeter(name, title));
    }
  }

  @Override
  public Object doUntil(Integer until, String action) {
    if (until == null) {
      return new Error("Please provide a number!");
    } else {
      int result = action.equals("sum") ? 0 : 1;
      for (int i = 1; i <= until; i++) {
        switch (action) {
          case "sum" -> result += i;
          case "factor" -> result *= i;
        }
      }
      return new Result(result);
    }
  }

  @Override
  public Object handleArrayAction(ArrayAction arrayAction) {
    if (arrayAction.getWhat() == null || arrayAction.getNumbers() == null) {
      return new Error("Please provide what to do with the numbers!");
    } else {
      Integer[] array = arrayAction.getNumbers();
      return switch (arrayAction.getWhat()) {
        case "sum" -> arraySum(array);
        case "multiply" -> arrayMultiply(array);
        case "double" -> arrayDouble(array);
        default -> null;
      };
    }
  }

  private Error handleGreetNullPointer(String name, String title) {
    if (name == null && title == null) {
      return new Error("Please provide a name and a title!");
    } else if (name == null) {
      return new Error("Please provide a name!");
    } else {
      return new Error("Please provide a title!");
    }
  }

  private Result arraySum(Integer[] array) {
    return new Result(Arrays.stream(array).reduce(0, Integer::sum));
  }

  private Result arrayMultiply(Integer[] array) {
    return new Result(Arrays.stream(array).reduce((a, b) -> a*b).get());
  }

  private ArrayResult arrayDouble(Integer[] array) {
    return new ArrayResult(Arrays.stream(array).map(num -> num*2).toArray(Integer[]::new));
  }
}
