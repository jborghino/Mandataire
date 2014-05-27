package fr.treeptik.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicule implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String marque;
	private String modele;
	private String couleur;
	private String equipement;
	private String motorisation;
	private String url;

	private Integer nbPortes;
	private Integer nbPlaces;
	private Integer emission;
	private Integer prix;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getModele() {
		return modele;
	}
	public void setModele(String modele) {
		this.modele = modele;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public String getEquipement() {
		return equipement;
	}
	public void setEquipement(String equipement) {
		this.equipement = equipement;
	}
	public String getMotorisation() {
		return motorisation;
	}
	public void setMotorisation(String motorisation) {
		this.motorisation = motorisation;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Integer getNbPortes() {
		return nbPortes;
	}
	public void setNbPortes(Integer nbPortes) {
		this.nbPortes = nbPortes;
	}
	public Integer getNbPlaces() {
		return nbPlaces;
	}
	public void setNbPlaces(Integer nbPlaces) {
		this.nbPlaces = nbPlaces;
	}
	public Integer getEmission() {
		return emission;
	}
	public void setEmission(Integer emission) {
		this.emission = emission;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Vehicule [id=" + id + ", marque=" + marque + ", modele="
				+ modele + ", couleur=" + couleur + ", equipement="
				+ equipement + ", motorisation=" + motorisation + ", url="
				+ url + ", nbPortes=" + nbPortes + ", nbPlaces=" + nbPlaces
				+ ", emission=" + emission + ", prix=" + prix + "]";
	}
	
	
}
