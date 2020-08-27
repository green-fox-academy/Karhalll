package com.greenfoxacademy.dependencies.GreenfoxAppClass.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service
public class FileService implements StudentService {

  Path path = Paths.get("src/main/resources/static/gfa/students.txt");

  @Override
  public List<String> findAll() {
    return getFileStream()
        .collect(Collectors.toList());
  }

  @Override
  public void save(String student) {
    try {
      Files.writeString(path, "\n" + student, StandardOpenOption.APPEND);
    } catch (IOException e) {
      System.out.println("Can't write to file");
    }
  }

  @Override
  public int count() {
    return (int) getFileStream()
        .count();
  }

  @Override
  public boolean isStudent(String name) {
    return getFileStream()
        .anyMatch(s -> s.equals(name));
  }

  private Stream<String> getFileStream() {
    try {
      return Files.lines(path);
    } catch (IOException e) {
      System.out.println("Can't read file");
      return null;
    }
  }
}
