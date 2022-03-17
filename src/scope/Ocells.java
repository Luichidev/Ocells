package scope;

import java.io.*;
import java.util.Date;

public class Ocells {
	public static void main(String[] args) {
		BufferedReader in;
		SpecimenManager specimens = new SpecimenManager();
		MunicipalityManager municipalities = new MunicipalityManager();

		String name;
		String municipality;
		int numOfSightings;
		Date lastestDate;

		try {
			in = new BufferedReader(new FileReader("dades-5.txt"));
			String strng;
			while ((strng = in.readLine()) != null) {
				name = strng;
				municipality = in.readLine();
				numOfSightings = Integer.parseInt(in.readLine());
				lastestDate = new Date();
				String[] arrayDate = in.readLine().split(" ");
				lastestDate.setYear(Integer.parseInt(arrayDate[0]) - 1900);
				lastestDate.setMonth(Integer.parseInt(arrayDate[1]) - 1);
				lastestDate.setDate(Integer.parseInt(arrayDate[2]));

				// Creem una especie i ho agegim al SpecimenManager
				Specimen newSpecimen = new Specimen(name, numOfSightings, lastestDate);
				specimens.addSpecimen(newSpecimen);

				// Creem un municipi i ho afegim al MunicipalityManager
				Municipality newMunicipality = new Municipality(municipality, numOfSightings);
				municipalities.addMunicipality(newMunicipality);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		/*
		 * System.out.println("Totes les esp�cies observades s�n:");
		 * System.out.println(specimens);
		 * System.out.println("Tots els municipis amb esp�cies observades s�n:");
		 * System.out.println(municipalities);
		 */

		Date newDate = new Date(119, 1, 15);
		SpecimenManager specimens_previous = specimens.removePreviousThanDate(newDate);
		System.out.println("Totes les espècies observades amb data pr�via a date:");
		System.out.println(specimens_previous.toString());
		System.out.println("Totes les espècies observades amb data posterior a date:");
		System.out.println(specimens.toString());

	}
}
