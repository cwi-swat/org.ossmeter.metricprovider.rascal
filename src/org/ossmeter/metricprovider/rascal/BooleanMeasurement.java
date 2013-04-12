package org.ossmeter.metricprovider.rascal;



public class BooleanMeasurement extends Measurement {
	
	
	
	public BooleanMeasurement() { 
		super();
	}
	
	public boolean getValue() {
		return parseBoolean(dbObject.get("value")+"", false);
	}
	
	public BooleanMeasurement setValue(boolean value) {
		dbObject.put("value", value + "");
		notifyChanged();
		return this;
	}
	
	
	
	
}