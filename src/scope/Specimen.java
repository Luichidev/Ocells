package scope;

import java.util.Date;

public class Specimen {
	private String	name;
	private int		numOfSightings;
	private Date	latestDate;
	private final String NL = System.getProperty("line.separator");
	
	Specimen(String name, int numOfSightings, Date latestDate){
		this.name = name;
		this.latestDate = latestDate;
		this.numOfSightings = numOfSightings;
	}
	
	public String to_String() {
		String info = "";
		info += this.name + NL + this.numOfSightings + NL + this.latestDate; 
		return info;
	}
	
	public boolean isGreater(Specimen sp) {
		boolean isGreater = false;
		//TODO
		return isGreater;
	}
	
	public void addSpecimen(Specimen sp) {
		//TODO
	}
	
}