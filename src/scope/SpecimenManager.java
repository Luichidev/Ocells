package scope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;

public class SpecimenManager {
	private ArrayList<Specimen> specimens;
	private final String NL = System.getProperty("line.separator");
	
	SpecimenManager(){
		specimens = new ArrayList<Specimen>();
	}
	
	SpecimenManager removePreviousThanDate (Date date) {
		SpecimenManager previous = new SpecimenManager();
		Iterator<Specimen> it = specimens.iterator();
		
		while (it.hasNext()) {
			Specimen s = it.next();
			if(s.isBeforeDate(date)) {
				previous.addSpecimen(s);
				it.remove();
			}
		}
		
		return previous;
	}
	public void addSpecimen(Specimen sp) {
		boolean flag = true;
		for (Specimen s : specimens) {
			if(s.isSameName(sp)) {
				s.update(sp);
				flag = false;
			}
		}
		if(flag) {
			specimens.add(sp);
			SortElemens();
		}
	}
	
	public String toString() {
		String info = "Espècies:" + NL;
		info += "---------" + NL;
		for(Specimen s: specimens) {
			info+= s.toString() + NL;
		}
		return info;
	}
	
	private void SortElemens() {
		Collections.sort(specimens, new Comparator<Specimen>() {
			public int compare(Specimen s1, Specimen s2) {
				return s1.compare(s2);
			}
		});
	}
}
