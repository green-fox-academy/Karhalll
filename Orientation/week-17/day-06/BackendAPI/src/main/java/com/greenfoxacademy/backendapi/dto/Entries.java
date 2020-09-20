package com.greenfoxacademy.backendapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.greenfoxacademy.backendapi.dto.LogDTO;
import java.util.List;

public class Entries {

  private final List<LogDTO> entries;
  @JsonProperty("entries_count")
  private final Integer entriesCount;

  public Entries(List<LogDTO> entries) {
    this.entries = entries;
    this.entriesCount = entries.size();
  }

  public List<LogDTO> getEntries() {
    return entries;
  }

  public Integer getEntriesCount() {
    return entriesCount;
  }
}
