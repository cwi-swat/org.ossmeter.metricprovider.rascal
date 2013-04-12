package org.ossmeter.metricprovider.rascal;

import org.ossmeter.metricprovider.rascal.history.model.HistoricRascalMetric;


public class Foo {
  public static void main(String[] args) {
	  RascalMetrics rm = new RascalMetrics();
	  
	  String transientMetricID = "org::rascal::Transient/Loc";
	  String historicMetricID = "org::rascal::Historic/Loc";
	  
	  IntegerMeasurement test = new IntegerMeasurement();
	  test.setMetric(transientMetricID);
	  test.setUri("class::/Foo.java");
	  test.setValue(33);
	  rm.getMeasurements().add(test);
	  

	  // findByMetric wouldn't want to return an iterable... Maybe we need to build up queries and end with .call();
	  Iterable<Measurement> classMeasures = rm.getMeasurements().findByMetric(transientMetricID).filterByUri("class://*");
	  
	  double culm = 0;
	  double count = 0;
	  for (Measurement m : classMeasures) {
		  culm += ((IntegerMeasurement)m).getValue();
		  count++;
	  }
	  culm =  culm / count; // save in historic DB as AVERAGE LOC PER CLASS metric?
	  
	  HistoricRascalMetric hrm = new HistoricRascalMetric();
	  hrm.setMetricId(historicMetricID);
	  hrm.setValue(String.valueOf(culm));
	  
	  
	  Iterable<Measurement> methodMeasures = rm.getMeasurements().findByMetric(transientMetricID).filterByUri("method://*");
  }
  
//  class HistoricRascalMetric {
//  	attr String metricID;
//  	attr String value;
//  }
}
