package com.rajvansia.kafka;

public final class VitalSimulator{

	  public static void main(String[] args) {

	    String brokers = "localhost:9092";
	    String groupId = "vitals1";
	    String topic = "99897";

	    if (args != null && args.length == 3) {
	      brokers = args[0];
	      groupId = args[1];
	      topic = args[2];
	    }

	    // Start User Producer Thread
	    VitalProducer producerThread = new VitalProducer(brokers, topic);
	    Thread t1 = new Thread(producerThread);
	    t1.start();

	    // Start group of User Consumer Thread
	    VitalConsumer consumerThread = new VitalConsumer(brokers, groupId, topic);
	    Thread t2 = new Thread(consumerThread);
	    t2.start();

	    try {
	      Thread.sleep(100000);
	    } catch (InterruptedException ie) {

	    }
	  }
	}
