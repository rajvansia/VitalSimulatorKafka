
package com.rajvansia.kafka;
import java.util.Date;

public class VitalMeasurement{
	  private String patientId;
	  private String deviceId;
	  private String vitalParameter;
	  private String vitalUnit;
	  private Date timeStamp;
	  private double vitalValue;



	  public VitalMeasurement() {

	  }

	  public VitalMeasurement(String patientId, String deviceId, String vitalParameter,  Double vitalValue, String vitalUnit, Date timeStamp) {
	    super();
	    this.timeStamp = timeStamp;
	    this.patientId = patientId;
	    this.deviceId = deviceId;
	    this.vitalParameter = vitalParameter;
	    this.vitalValue = vitalValue;
	    this.vitalUnit = vitalUnit;
	    
	  }

	  /*
	   * (non-Javadoc)
	   * 
	   * @see java.lang.Object#toString()
	   */
	  @Override
	  public String toString() {
	    return "Vitals [timeStamp:" + timeStamp + ", patientId:" + patientId + ", deviceId:" + deviceId + ", vitalParameter:" + vitalParameter + ", vitalValue:"
	        + vitalValue + ", vitalUnit:" + vitalUnit + "]";
	  }

	  /**
	   * @return the id
	   */
	  public String getPatientId() {
	    return patientId;
	  }

	  /**
	   * @param id the id to set
	   */
	  public void setId(String patientId) {
	    this.patientId = patientId;
	  }

	  /**
	   * @return the userName
	   */
	  public String getdeviceId() {
	    return deviceId;
	  }

	  /**
	   * @param userName the userName to set
	   */
	  public void setVitalParameter(String vitalParameter) {
	    this.vitalParameter = vitalParameter;
	  }
	  public String getVitalParameter() {
		    return vitalParameter;
		  }
	  /**
	   * @return the firstName
	   */
	  public String getVitalUnit() {
	    return vitalUnit;
	  }

	  /**
	   * @param firstName the firstName to set
	   */
	  public void setVitalUnit(String vitalUnit) {
	    this.vitalUnit = vitalUnit;
	  }

	  /**
	   * @return the lastName
	   */
	  public Date getTimeStamp() {
	    return timeStamp;
	  }

	  /**
	   * @param lastName the lastName to set
	   */
	  public void setLastName(Date timeStamp) {
	    this.timeStamp = timeStamp;
	  }


	  /**
	   * @return the age
	   */
	  public double getVitalValue() {
	    return vitalValue;
	  }

	  /**
	   * @param age the age to set
	   */
	  public void setVitalValue(int vitalValue) {
	    this.vitalValue = vitalValue;
	  }
	}
