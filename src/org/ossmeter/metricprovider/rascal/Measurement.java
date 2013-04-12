package org.ossmeter.metricprovider.rascal;

import com.googlecode.pongo.runtime.Pongo;


public class Measurement extends Pongo {
	
	
	
	public Measurement() { 
		super();
	}
	
	public String getUri() {
		return parseString(dbObject.get("uri")+"", "");
	}
	
	public Measurement setUri(String uri) {
		dbObject.put("uri", uri + "");
		notifyChanged();
		return this;
	}
	public String getMetric() {
		return parseString(dbObject.get("metric")+"", "");
	}
	
	public Measurement setMetric(String metric) {
		dbObject.put("metric", metric + "");
		notifyChanged();
		return this;
	}
	
	
	
	
}