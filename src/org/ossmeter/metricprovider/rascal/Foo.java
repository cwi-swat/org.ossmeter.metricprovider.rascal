package org.ossmeter.metricprovider.rascal;

import java.io.File;

import com.googlecode.pongo.PongoGenerator;

public class Foo {
  public static void main(String[] args) {
    try {
      new PongoGenerator().generate(new File("/Users/jurgenv/EclipseWorkspace/org.ossmeter.metricprovider.rascal/src/rascalmetric.emf"));
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
