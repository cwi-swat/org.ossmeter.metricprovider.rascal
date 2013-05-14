package org.ossmeter.metricprovider.rascal.history;

import java.util.Arrays;
import java.util.List;

public class LocHistoricMetricProvider extends RascalHistoricMetricProvider {

	protected String _metricId = "rascal://DemoLoc/countLoc";
	
	public LocHistoricMetricProvider() {
		this.metricId = _metricId;
	}

	@Override
	public String getIdentifier() {
		return _metricId = "/historic";
	}
	
	@Override
	public List<String> getIdentifiersOfUses() {
		return Arrays.asList(_metricId);
	}
	
}
