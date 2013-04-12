package org.ossmeter.metricprovider.rascal;



public class RealMeasurement extends Measurement {
	
	
	
	public RealMeasurement() { 
		super();
	}
	
	public float getValue() {
		return parseFloat(dbObject.get("value")+"", 0.0f);
	}
	
	public RealMeasurement setValue(float value) {
		dbObject.put("value", value + "");
		notifyChanged();
		return this;
	}
	
	
	
	
}