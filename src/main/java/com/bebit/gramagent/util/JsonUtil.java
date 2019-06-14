package com.bebit.gramagent.util;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {
  private static ObjectMapper mapper;

  public static ObjectMapper getObjectMapper() {
    if (mapper == null) {

      mapper = new ObjectMapper();
      // mapper.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
      // true);

    }
    return mapper;
  }

}
