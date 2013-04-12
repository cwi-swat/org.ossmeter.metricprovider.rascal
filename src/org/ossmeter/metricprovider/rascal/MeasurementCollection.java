package org.ossmeter.metricprovider.rascal;

import java.util.Iterator;

import com.googlecode.pongo.runtime.IteratorIterable;
import com.googlecode.pongo.runtime.PongoCollection;
import com.googlecode.pongo.runtime.PongoCursorIterator;
import com.googlecode.pongo.runtime.PongoFactory;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;

public class MeasurementCollection extends PongoCollection<Measurement> {
	
	public MeasurementCollection(DBCollection dbCollection) {
		super(dbCollection);
		createIndex("uri");
		createIndex("metric");
	}
	
	public Iterable<Measurement> findById(String id) {
		return new IteratorIterable<Measurement>(new PongoCursorIterator<Measurement>(this, dbCollection.find(new BasicDBObject("_id", id))));
	}
	
	public Iterable<Measurement> findByUri(String q) {
		return new IteratorIterable<Measurement>(new PongoCursorIterator<Measurement>(this, dbCollection.find(new BasicDBObject("uri", q + ""))));
	}
	
	public Measurement findOneByUri(String q) {
		Measurement measurement = (Measurement) PongoFactory.getInstance().createPongo(dbCollection.findOne(new BasicDBObject("uri", q + "")));
		if (measurement != null) {
			measurement.setPongoCollection(this);
		}
		return measurement;
	}

	public long countByUri(String q) {
		return dbCollection.count(new BasicDBObject("uri", q + ""));
	}
	public Iterable<Measurement> findByMetric(String q) {
		return new IteratorIterable<Measurement>(new PongoCursorIterator<Measurement>(this, dbCollection.find(new BasicDBObject("metric", q + ""))));
	}
	
	public Measurement findOneByMetric(String q) {
		Measurement measurement = (Measurement) PongoFactory.getInstance().createPongo(dbCollection.findOne(new BasicDBObject("metric", q + "")));
		if (measurement != null) {
			measurement.setPongoCollection(this);
		}
		return measurement;
	}

	public long countByMetric(String q) {
		return dbCollection.count(new BasicDBObject("metric", q + ""));
	}
	
	
	@Override
	public Iterator<Measurement> iterator() {
		return new PongoCursorIterator<Measurement>(this, dbCollection.find());
	}
	
	public void add(Measurement measurement) {
		super.add(measurement);
	}
	
	public void remove(Measurement measurement) {
		super.remove(measurement);
	}
	
}