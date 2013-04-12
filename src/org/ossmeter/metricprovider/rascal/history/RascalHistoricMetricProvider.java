package org.ossmeter.metricprovider.rascal.history;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.ossmeter.metricprovider.rascal.IntegerMeasurement;
import org.ossmeter.metricprovider.rascal.Measurement;
import org.ossmeter.metricprovider.rascal.RascalMetricProvider;
import org.ossmeter.metricprovider.rascal.RascalMetrics;
import org.ossmeter.metricprovider.rascal.history.model.HistoricRascalMetrics;
import org.ossmeter.platform.IHistoricalMetricProvider;
import org.ossmeter.platform.IMetricProvider;
import org.ossmeter.platform.MetricProviderContext;
import org.ossmeter.repository.model.Project;

import com.googlecode.pongo.runtime.Pongo;

public abstract class RascalHistoricMetricProvider implements IHistoricalMetricProvider{

	protected String metricId;
	private RascalMetricProvider rascalMetricProvider;
	private MetricProviderContext context;

	@Override
	public boolean appliesTo(Project project) {
		return true; //FIXME
	}

	@Override
	public void setUses(List<IMetricProvider> uses) {
		this.rascalMetricProvider = (RascalMetricProvider)uses.get(0);
	}


	@Override
	public void setMetricProviderContext(MetricProviderContext context) {
		this.context = context;
	}

	@Override
	public Pongo measure(Project project) {
		RascalMetrics rascalMetrics = rascalMetricProvider.adapt(context.getProjectDB(project));

		Iterable<Measurement> measurements = rascalMetrics.getMeasurements().findByMetric(metricId);
		
		HistoricRascalMetrics hrm = new HistoricRascalMetrics();
		Map<String, Long> map = new HashMap<String, Long>();
		
		for (Measurement m : measurements) {
			if (m instanceof IntegerMeasurement) {
				
				String key = m.getUri().split("://")[0];
				if (map.containsKey(key)) {
					map.put(key, map.get(key) + ((IntegerMeasurement) m).getValue()); 
				} else {
					map.put(key, ((IntegerMeasurement) m).getValue());
				}
			}
		}

		for (Entry<String, Long> entry : map.entrySet()){
			IntegerMeasurement im = new IntegerMeasurement();
			im.setMetric(metricId);
			im.setValue(entry.getValue());
			im.setUri(entry.getKey());
			hrm.getMeasurements().add(im);
		}
		
		return hrm;
	}

	
	
}
