package com.rajvansia.kafka;

import java.util.Random;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Date;
import org.apache.kafka.clients.producer.Callback;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

public class VitalProducer implements Runnable {

  private final KafkaProducer<String, VitalMeasurement> producer;
  private final String topic;
  private final String device;

  public VitalProducer(String brokers, String topic, String device) {
    Properties prop = createProducerConfig(brokers);
    this.producer = new KafkaProducer<String, VitalMeasurement>(prop);
    this.topic = topic;
    this.device = device;
  }

  private static Properties createProducerConfig(String brokers) {
    Properties props = new Properties();
    props.put("bootstrap.servers", brokers);
    props.put("acks", "all");
    props.put("retries", 0);
    props.put("batch.size", 16384);
    props.put("linger.ms", 1);
    props.put("buffer.memory", 33554432);
    props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
    props.put("value.serializer", "com.rajvansia.kafka.VitalSerializer");

    return props;
  }

 
  public void run() {
	  for (int i = 0; i < 100; i++) {
		  
		  Random rand = new Random();
		  double SpO2 = rand.nextInt(100 - 80) + 80;
		  double Co = rand.nextInt(10 - 2) + 2;
		  double Hr = rand.nextInt(120 - 60) + 60;
		  double  NibpSystolic= rand.nextInt(140 - 80) + 80;
		  double  NibpSyDiastolic= rand.nextInt(100 - 40) + 40;
		  double  Rr= rand.nextInt(50 - 10) + 10;
		  Date date = new Date();
		  
    List<VitalMeasurement> vitals = new ArrayList<VitalMeasurement>();
    switch (device){
    case "PulseOximeter": vitals.add(new VitalMeasurement("99897", "Pulse Oximeter", "SpO2",SpO2, "%", date ));
    					  vitals.add(new VitalMeasurement("99897", "Physiological Monitor", "HR",Hr, "BPM", date ));
    break;
    case "CardiacMonitor":vitals.add(new VitalMeasurement("99897", "Cardiac Monitor", "CO",Co, "L/min", date ));
    break;
    case "Ventilator":vitals.add(new VitalMeasurement("99897", "Ventilator", "RR",Rr, "breaths/min", date ));
    break;
    case "NibpCuff": vitals.add(new VitalMeasurement("99897", "NIBP Cuff", "BP Systolic",NibpSystolic, "mmHg", date ));
    				vitals.add(new VitalMeasurement("99897", "NIBP Cuff", "BP Diastolic",NibpSyDiastolic, "mmHg", date ));
    break;
    default: vitals.add(new VitalMeasurement("99897", "Pulse Oximeter", "SpO2",SpO2, "%", date ));
    }
    for (final VitalMeasurement vital : vitals) {

      producer.send(new ProducerRecord<String, VitalMeasurement>(topic, vital.getPatientId(), vital),
          new Callback() {
            public void onCompletion(RecordMetadata metadata, Exception e) {
              if (e != null) {
                e.printStackTrace();
              }
              System.out.println("Sent:" + vital.toString());
            }
          });
      try {
    	  Thread.sleep(rand.nextInt(1000 - 400) + 400);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }

    }}

    // closes producer
    producer.close();

  }
}
