package org.ossmeter.metricprovider.rascal;



public class IntegerMeasurement extends Measurement {
	
	
	
	public IntegerMeasurement() { 
		super();
	}
	
	public long getValue() {
		return parseLong(dbObject.get("value")+"", 0);
	}
	
	public IntegerMeasurement setValue(long value) {
		dbObject.put("value", value + "");
		notifyChanged();
		return this;
	}
	
	
	
	
}