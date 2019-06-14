package com.bebit.gramagent.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubCondition {
  private Integer type;
  private Integer id;
  @JsonProperty("word_match_method")
  private Integer wordMatchMethod;
  private List<String> values;

  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getWordMatchMethod() {
    return wordMatchMethod;
  }

  public void setWordMatchMethod(Integer wordMatchMethod) {
    this.wordMatchMethod = wordMatchMethod;
  }

  public List<String> getValues() {
    return values;
  }

  public void setValues(List<String> values) {
    this.values = values;
  }



}
