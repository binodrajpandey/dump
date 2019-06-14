package com.bebit.gramagent.acts;

import com.bebit.gramagent.conditions.SubCondition;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SelectUsersByDatesAct {
  @JsonProperty(value = "utc_time_period")
  private Integer utcTimePeriod;
  @JsonProperty(value = "app_user_id")
  private Integer appUserId;
  @JsonProperty("client_id")
  private Integer clientId;

  @JsonProperty(value = "conversion_ids")
  private List<Integer> conversionIds;
  @JsonProperty("start_time_sec")
  private Long startTimeSec;

  @JsonProperty("login_session_key")
  private String loginSessionKey;
  @JsonProperty("uuid")
  private String uuid;

  @JsonProperty("sub_cnds")
  private List<SubCondition> subCnds;

  @JsonProperty("end_time_sec")
  private Long endTimeSec;

  public Integer getUtcTimePeriod() {
    return utcTimePeriod;
  }

  public void setUtcTimePeriod(Integer utcTimePeriod) {
    this.utcTimePeriod = utcTimePeriod;
  }

  public Integer getAppUserId() {
    return appUserId;
  }

  public void setAppUserId(Integer appUserId) {
    this.appUserId = appUserId;
  }

  public Integer getClientId() {
    return clientId;
  }

  public void setClientId(Integer clientId) {
    this.clientId = clientId;
  }

  public List<Integer> getConversionIds() {
    return conversionIds;
  }

  public void setConversionIds(List<Integer> conversionIds) {
    this.conversionIds = conversionIds;
  }

  public Long getStartTimeSec() {
    return startTimeSec;
  }

  public void setStartTimeSec(Long startTimeSec) {
    this.startTimeSec = startTimeSec;
  }

  public String getLoginSessionKey() {
    return loginSessionKey;
  }

  public void setLoginSessionKey(String loginSessionKey) {
    this.loginSessionKey = loginSessionKey;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }


  public List<SubCondition> getSubCnds() {
    return subCnds;
  }

  public void setSubCnds(List<SubCondition> subCnds) {
    this.subCnds = subCnds;
  }

  public Long getEndTimeSec() {
    return endTimeSec;
  }

  public void setEndTimeSec(Long endTimeSec) {
    this.endTimeSec = endTimeSec;
  }

  @Override
  public String toString() {
    return "SelectUsersByDatesAct [utcTimePeriod=" + utcTimePeriod + ", appUserId=" + appUserId
        + ", clientId=" + clientId + ", conversionIds=" + conversionIds + ", startTimeSec="
        + startTimeSec + ", loginSessionKey=" + loginSessionKey + ", uuid=" + uuid + ", subCnds="
        + subCnds + ", endTimeSec=" + endTimeSec + "]";
  }


}
