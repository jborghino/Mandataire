package fr.treeptik.mapper;

import fr.treeptik.model.Vehicule;

public class VehiculeMapper {

	public static Vehicule getVehicule(fr.treeptik.xml.Vehicule vehicule){
		Vehicule ret = new Vehicule();
		
		ret.setCouleur(vehicule.getCouleur());
		ret.setEmission(vehicule.getEmission());
		ret.setEquipement(vehicule.getEquipement());
		ret.setMarque(vehicule.getMarque());
		ret.setModele(vehicule.getModele());
		ret.setMotorisation(vehicule.getMotorisation());
		ret.setNbPlaces(vehicule.getNbPlaces());
		ret.setNbPortes(vehicule.getNbPortes());
		ret.setPrix(vehicule.getPrix());
		ret.setUrl(vehicule.getUrl());
		
		return ret;
	}
	
}
