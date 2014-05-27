package fr.treeptik.mapper;

import java.util.List;

import fr.treeptik.model.Concessionnaire;
import fr.treeptik.model.Vehicule;

public class ConcessionnaireMapper {

	
	public static Concessionnaire getConcessionnaire(fr.treeptik.xml.Concessionnaire concessionnaire, List<Vehicule> vehicules){
		Concessionnaire ret = new Concessionnaire();
		
		ret.setSiren(concessionnaire.getSiren());
		ret.setVehicules(vehicules);
		
		return ret;
	}
	
}
