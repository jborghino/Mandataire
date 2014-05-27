package fr.treeptik.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.mapper.ConcessionnaireMapper;
import fr.treeptik.mapper.VehiculeMapper;
import fr.treeptik.service.ConcessionnaireService;
import fr.treeptik.service.VehiculeService;
import fr.treeptik.xml.Concessionnaire;
import fr.treeptik.xml.Root;
import fr.treeptik.xml.Vehicule;

@Component
public class ParserXML {

	@Autowired
	private ConcessionnaireService concessionnaireService;
	@Autowired
	private VehiculeService vehiculeService;

	public void parseXML(String f) throws FileNotFoundException, ServiceException {

		JAXBContext context;
		try {
			context = JAXBContext.newInstance("fr.treeptik.xml");
			Unmarshaller unmarshaller = context.createUnmarshaller();

			String path = "/home/stagiaire/POE/workspace/Mandataire/";
			String tmp = path+f;
			File file = new File(tmp);
			Root root = (Root) unmarshaller.unmarshal(file);
			
			List<Vehicule> vehicules = root.getVehicule();
			if (vehicules != null) {
				List<fr.treeptik.model.Vehicule> listVehicules = new ArrayList<>();
				for (Vehicule vehicule : vehicules) {
					fr.treeptik.model.Vehicule v = VehiculeMapper.getVehicule(vehicule);
					listVehicules.add(v);
					try {
						vehiculeService.save(v);
					} catch (ServiceException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				Concessionnaire concessionnaire = root.getConcessionnaire();
				fr.treeptik.model.Concessionnaire con = ConcessionnaireMapper.getConcessionnaire(concessionnaire, listVehicules);
				
				String sirenFromXML = con.getSiren();
				List<String> sirenFromDB = concessionnaireService.findAllSiren();
				if(!sirenFromDB.contains(sirenFromXML)){
					concessionnaireService.save(con);
				}
			}
			
			
		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

	}

	public static String readPropertiesFile(String f) throws Exception,
			FileNotFoundException {

		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(f);

		try {
			properties.load(new FileInputStream(f));
			return properties.getProperty("folder");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fileInputStream.close();
		}
		return null;
	}


}
