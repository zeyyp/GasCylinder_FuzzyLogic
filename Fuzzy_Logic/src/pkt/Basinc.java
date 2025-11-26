package pkt;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;

public class Basinc {
	private FIS fis;  // bulanık modelimizi tutan degişken
	private double sicaklik;
	private double hacim;
	
	public Basinc(double sicaklik,double hacim) throws URISyntaxException {
		this.sicaklik = sicaklik;
		this.hacim= hacim;
		
		File dosya = new File(getClass().getResource("Model.fcl").toURI());
		
		fis = FIS.load(dosya.getPath())	;
		fis.setVariable("hacim", hacim);
		fis.setVariable("sicaklik", sicaklik);
		fis.evaluate();		
	}
	
	public FIS getModel() {
		return fis;
	}
	
	@Override
	public String toString() {
		String cikti;
	     
		cikti = "Basinç: " + Math.round(fis.getVariable("basinc").getValue())+ " bar";
		return cikti;  
	}
	
	
	
	
	
	
	
	
	
}
