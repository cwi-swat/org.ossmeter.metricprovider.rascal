package org.ossmeter.metricprovider.rascal;


public class Foo {
  public static void main(String[] args) {
	  RascalMetrics rm = new RascalMetrics();
	  IntegerMeasurement test = new IntegerMeasurement();
	  test.setMetric("org::rascal::foo/bar");
	  test.setUri("class::/Foo.java");
	  test.setValue(33);
	  rm.getMeasurements().add(test);
  }
}
