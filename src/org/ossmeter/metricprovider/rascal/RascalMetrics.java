package org.ossmeter.metricprovider.rascal;

import com.googlecode.pongo.runtime.PongoDB;
import com.mongodb.DB;

public class RascalMetrics extends PongoDB {
	
	public RascalMetrics() {}
	
	public RascalMetrics(DB db) {
		setDb(db);
	}
	
	protected MeasurementCollection measurements = null;
	
	
	
	public MeasurementCollection getMeasurements() {
		return measurements;
	}
	
	
	@Override
	public void setDb(DB db) {
		super.setDb(db);
		measurements = new MeasurementCollection(db.getCollection("measurements"));
		pongoCollections.add(measurements);
	}
}