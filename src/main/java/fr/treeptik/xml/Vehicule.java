//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.05.27 at 01:59:37 PM CEST 
//


package fr.treeptik.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for vehicule complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="vehicule">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="marque" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="modele" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="couleur" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="nb_portes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nb_places" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="equipement" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="motorisation" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="emission" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prix" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "vehicule", propOrder = {
    "marque",
    "modele",
    "couleur",
    "nbPortes",
    "nbPlaces",
    "equipement",
    "motorisation",
    "emission",
    "url",
    "prix"
})
public class Vehicule {

    @XmlElement(required = true)
    protected String marque;
    @XmlElement(required = true)
    protected String modele;
    @XmlElement(required = true)
    protected String couleur;
    @XmlElement(name = "nb_portes")
    protected int nbPortes;
    @XmlElement(name = "nb_places")
    protected int nbPlaces;
    @XmlElement(required = true)
    protected String equipement;
    @XmlElement(required = true)
    protected String motorisation;
    protected int emission;
    @XmlElement(required = true)
    protected String url;
    protected int prix;

    /**
     * Gets the value of the marque property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMarque() {
        return marque;
    }

    /**
     * Sets the value of the marque property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMarque(String value) {
        this.marque = value;
    }

    /**
     * Gets the value of the modele property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getModele() {
        return modele;
    }

    /**
     * Sets the value of the modele property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setModele(String value) {
        this.modele = value;
    }

    /**
     * Gets the value of the couleur property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCouleur() {
        return couleur;
    }

    /**
     * Sets the value of the couleur property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCouleur(String value) {
        this.couleur = value;
    }

    /**
     * Gets the value of the nbPortes property.
     * 
     */
    public int getNbPortes() {
        return nbPortes;
    }

    /**
     * Sets the value of the nbPortes property.
     * 
     */
    public void setNbPortes(int value) {
        this.nbPortes = value;
    }

    /**
     * Gets the value of the nbPlaces property.
     * 
     */
    public int getNbPlaces() {
        return nbPlaces;
    }

    /**
     * Sets the value of the nbPlaces property.
     * 
     */
    public void setNbPlaces(int value) {
        this.nbPlaces = value;
    }

    /**
     * Gets the value of the equipement property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEquipement() {
        return equipement;
    }

    /**
     * Sets the value of the equipement property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEquipement(String value) {
        this.equipement = value;
    }

    /**
     * Gets the value of the motorisation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMotorisation() {
        return motorisation;
    }

    /**
     * Sets the value of the motorisation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMotorisation(String value) {
        this.motorisation = value;
    }

    /**
     * Gets the value of the emission property.
     * 
     */
    public int getEmission() {
        return emission;
    }

    /**
     * Sets the value of the emission property.
     * 
     */
    public void setEmission(int value) {
        this.emission = value;
    }

    /**
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the prix property.
     * 
     */
    public int getPrix() {
        return prix;
    }

    /**
     * Sets the value of the prix property.
     * 
     */
    public void setPrix(int value) {
        this.prix = value;
    }

}
