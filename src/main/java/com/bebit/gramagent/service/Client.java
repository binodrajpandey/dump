package com.bebit.gramagent.service;

public class Client {
  private Integer id;
  private Integer masterId;
  private String name;
  private String kana;
  private String parameter;

  private String createdAt;

  private String updatedAt;

  private Boolean isDisabled;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getMasterId() {
    return masterId;
  }

  public void setMasterId(Integer masterId) {
    this.masterId = masterId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getKana() {
    return kana;
  }

  public void setKana(String kana) {
    this.kana = kana;
  }

  public String getParameter() {
    return parameter;
  }

  public void setParameter(String parameter) {
    this.parameter = parameter;
  }

  public String getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(String createdAt) {
    this.createdAt = createdAt;
  }

  public String getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }

  public Boolean getIsDisabled() {
    return isDisabled;
  }

  public void setIsDisabled(Boolean isDisabled) {
    this.isDisabled = isDisabled;
  }

  @Override
  public String toString() {
    return "Client [id=" + id + ", masterId=" + masterId + ", name=" + name + ", kana=" + kana
        + ", parameter=" + parameter + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt
        + ", isDisabled=" + isDisabled + "]";
  }



}
