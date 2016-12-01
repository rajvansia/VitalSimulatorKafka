package com.rajvansia.kafka;

public final class VitalSimulator{

	  public static void main(String[] args) {

	    String brokers = "localhost:9092";
	    String groupId = "vitals2";
	    String topic = "99897";
	    String simulator = "none";
	    String device = "none";
	    
	    simulator = args[0];
	    device = args[1];
	    
	    if (simulator.equals("producer")) {
	    // Start User Producer Thread
	    	 System.out.println("inu");
	    VitalProducer producerThread = new VitalProducer(brokers, topic, device);
	    Thread t1 = new Thread(producerThread);
	    t1.start();
	    try {
		      Thread.sleep(100000);
		    } catch (InterruptedException ie) {

		    }
	    }
	    if (simulator.equals("consumer")) {
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
	}
