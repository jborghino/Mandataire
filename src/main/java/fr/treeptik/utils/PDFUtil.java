package fr.treeptik.utils;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import fr.treeptik.model.Client;
import fr.treeptik.model.Vehicule;

public class PDFUtil {

	public String createPDF(Vehicule vehicule, Client client) {
		Document document = new Document(PageSize.A4);

		try {
			String path = "/home/stagiaire/POE/workspace/Mandataire/pdf/";
			String nomFichier = vehicule.getMarque() + "_" + vehicule.getModele() + ".pdf";
			PdfWriter.getInstance(document, new FileOutputStream(path+nomFichier));
			document.addTitle("Commande vehicule");
			document.addAuthor("Mandataire Auto");
			document.open();
			StringBuilder myString = new StringBuilder();
			myString.append("Marque : ").append(vehicule.getMarque()).append("\n")
			.append("Modèle : ").append(vehicule.getModele()).append("\n")
			.append("Couleur : ").append(vehicule.getCouleur()).append("\n")
			.append("Portes : ").append(vehicule.getNbPortes()).append("\n")
			.append("Places : ").append(vehicule.getNbPlaces()).append("\n")
			.append("Equipements : ").append(vehicule.getEquipement()).append("\n")
			.append("Motorisation : ").append(vehicule.getMotorisation()).append("\n")
			.append("Emissions : ").append(vehicule.getEmission()).append("\n")
			.append("Prix : ").append(vehicule.getPrix()).append("\n");
			document.add(new Paragraph(myString.toString()));
			
			return path+nomFichier;
		} catch (DocumentException | FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			document.close();
		}
		return null;
		
	}

}
