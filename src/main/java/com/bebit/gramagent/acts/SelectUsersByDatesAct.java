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
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((appUserId == null) ? 0 : appUserId.hashCode());
    result = prime * result + ((clientId == null) ? 0 : clientId.hashCode());
    result = prime * result + ((conversionIds == null) ? 0 : conversionIds.hashCode());
    result = prime * result + ((endTimeSec == null) ? 0 : endTimeSec.hashCode());
    result = prime * result + ((loginSessionKey == null) ? 0 : loginSessionKey.hashCode());
    result = prime * result + ((startTimeSec == null) ? 0 : startTimeSec.hashCode());
    result = prime * result + ((subCnds == null) ? 0 : subCnds.hashCode());
    result = prime * result + ((utcTimePeriod == null) ? 0 : utcTimePeriod.hashCode());
    result = prime * result + ((uuid == null) ? 0 : uuid.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SelectUsersByDatesAct other = (SelectUsersByDatesAct) obj;
    if (appUserId == null) {
      if (other.appUserId != null)
        return false;
    } else if (!appUserId.equals(other.appUserId))
      return false;
    if (clientId == null) {
      if (other.clientId != null)
        return false;
    } else if (!clientId.equals(other.clientId))
      return false;
    if (conversionIds == null) {
      if (other.conversionIds != null)
        return false;
    } else if (!conversionIds.equals(other.conversionIds))
      return false;
    if (endTimeSec == null) {
      if (other.endTimeSec != null)
        return false;
    } else if (!endTimeSec.equals(other.endTimeSec))
      return false;
    if (loginSessionKey == null) {
      if (other.loginSessionKey != null)
        return false;
    } else if (!loginSessionKey.equals(other.loginSessionKey))
      return false;
    if (startTimeSec == null) {
      if (other.startTimeSec != null)
        return false;
    } else if (!startTimeSec.equals(other.startTimeSec))
      return false;
    if (subCnds == null) {
      if (other.subCnds != null)
        return false;
    } else if (!subCnds.equals(other.subCnds))
      return false;
    if (utcTimePeriod == null) {
      if (other.utcTimePeriod != null)
        return false;
    } else if (!utcTimePeriod.equals(other.utcTimePeriod))
      return false;
    if (uuid == null) {
      if (other.uuid != null)
        return false;
    } else if (!uuid.equals(other.uuid))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "SelectUsersByDatesAct [utcTimePeriod=" + utcTimePeriod + ", appUserId=" + appUserId
        + ", clientId=" + clientId + ", conversionIds=" + conversionIds + ", startTimeSec="
        + startTimeSec + ", loginSessionKey=" + loginSessionKey + ", uuid=" + uuid + ", subCnds="
        + subCnds + ", endTimeSec=" + endTimeSec + "]";
  }


}
