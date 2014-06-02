package fr.treeptik.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class FileSystem {
	
	public static String getPath(){
		return System.getProperty("user.dir");
	}
	
	
}
