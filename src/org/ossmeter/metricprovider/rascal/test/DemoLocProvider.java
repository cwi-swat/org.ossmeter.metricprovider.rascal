package org.ossmeter.metricprovider.rascal.test;

import java.net.URI;
import java.util.Collections;
import java.util.List;

import org.ossmeter.metricprovider.rascal.RascalMetricProvider;
import org.ossmeter.platform.IMetricProvider;

public class DemoLocProvider extends RascalMetricProvider {
  public DemoLocProvider() {
    super(getURI());
  }

  private static URI getURI() {
    return URI.create("rascal://DemoLoc/countLoc");
  }

  @Override
  public String getIdentifier() {
    return getURI().toASCIIString();
  }

  @Override
  public void setUses(List<IMetricProvider> uses) {

  }

  @Override
  public List<String> getIdentifiersOfUses() {
    return Collections.emptyList();
  }
}
