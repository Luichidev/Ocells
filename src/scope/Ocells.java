package scope;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ocells {
	public static void main(String[] args) {
		BufferedReader in;
		SpecimenManager specimens = new SpecimenManager();
		MunicipalityManager municipalities = new MunicipalityManager();
		
		boolean endOfFile = false;
				
		while (!endOfFile) {
			try {
				String name;
				String municipality;
				int numOfSightings;
				Date lastestDate;
				String currentLine;
				in = new BufferedReader (new FileReader("dades-5.txt"));
				name = in.readLine();
				municipality = in.readLine();
				numOfSightings = Integer.parseInt(in.readLine());
				lastestDate = new SimpleDateFormat("yyyy mm dd").parse(in.readLine());				
				Specimen newSpecimen = new Specimen(name, numOfSightings, lastestDate);
				newSpecimen.addSpecimen(newSpecimen);
				specimens.addSpecimen(newSpecimen);
				Municipality newMunicipality = new Municipality(name, numOfSightings);
				municipalities.addMunicipality(newMunicipality);
				if((currentLine = in.readLine()) == null){
					endOfFile = true;
				}
			} catch (Exception e) {
				System.err.println(e.toString());
				endOfFile = true;
			}			
			
		}
	
		System.out.println("Totes les espècies observades són:");
		System.out.println(specimens.to_String());
		System.out.println("Tots els municipis amb espècies observades són:");
		System.out.println(municipalities.to_String());
		
		//Date newDate;
		//SpecimenManager specimens_previous = specimens.removePreviousThanDate(newDate);
		/*System.out.println("ok");
		System.out.println("Totes les espècies observades amb data prèvia a date:");
		System.out.println(specimens_previous.to_String());
		System.out.println("Totes les espècies observades amb data posterior a date:");
		System.out.println(specimens.to_String());*/
		
	}
}
