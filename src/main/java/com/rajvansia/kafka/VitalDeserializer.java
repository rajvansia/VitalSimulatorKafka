package com.rajvansia.kafka;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;

public class VitalDeserializer implements Deserializer<VitalMeasurement> {


  public void close() {

  }


  public void configure(Map<String, ?> arg0, boolean arg1) {

  }


  public VitalMeasurement deserialize(String arg0, byte[] arg1) {
    ObjectMapper mapper = new ObjectMapper();
    VitalMeasurement vital = null;
    try {
      vital = mapper.readValue(arg1, VitalMeasurement.class);
    } catch (Exception e) {

      e.printStackTrace();
    }
    return vital;
  }

}
