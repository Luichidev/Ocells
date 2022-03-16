package scope;

public class Municipality {
	private String	name;
	private int		numOfSightings;
	
	Municipality(String name, int numOfSightings){
		this.name = name;
		this.numOfSightings = numOfSightings;
	}
	
	public String toString() {
		String info = "";
		info += "{ Nom: " + this.name;
		info += ", Nombre Obs.: " + this.numOfSightings;
		info += "}"; 
		return info;
	}
	
	public boolean isGreater(Municipality m) {
		boolean isGreater = false;
		//TODO
		return isGreater;
	}
	
	public boolean isSameName(Municipality m) {
		return this.name.compareTo(m.name) == 0;
	}
	
	public void update(Municipality m) {
		this.numOfSightings += m.numOfSightings;
	}
	
	public int compare(Municipality m) {
		return this.name.compareTo(m.name);
	}
}