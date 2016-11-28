package com.rajvansia.kafka;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class VitalSerializer implements Serializer<VitalMeasurement> {


  public void close() {

  }

  public void configure(Map<String, ?> arg0, boolean arg1) {

  }

  
  public byte[] serialize(String arg0, VitalMeasurement arg1) {
    byte[] retVal = null;
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      retVal = objectMapper.writeValueAsString(arg1).getBytes();
    } catch (Exception e) {
      e.printStackTrace();
    }
    return retVal;
  }



}
