package scope;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MunicipalityManager {
	private ArrayList<Municipality> municipalities;
	private final String NL = System.getProperty("line.separator");
	
	MunicipalityManager(){
		municipalities = new ArrayList<Municipality>();
	}
	
	public void addMunicipality(Municipality m) {
		boolean flag = true;
		for (Municipality mun : municipalities) {
			if(mun.isSameName(m)) {
				mun.update(m);
				flag = false;
			}			
		}
		if(flag) {
			municipalities.add(m);
			SortElemens();
		}
	}
	
	public String toString() {
		String info = "Municipis:" + NL;
		info += "---------" + NL;
		for(Municipality m: municipalities) {
			info+= m.toString() + NL;
		}
		return info;
	}
	
	private void SortElemens() {
		Collections.sort(municipalities, new Comparator<Municipality>() {
			public int compare(Municipality m1, Municipality m2) {
				return m1.compare(m2);
			}
		});
	}
	
}