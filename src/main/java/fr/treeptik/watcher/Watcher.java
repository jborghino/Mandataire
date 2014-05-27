package fr.treeptik.watcher;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.treeptik.utils.ParserXML;

@Component
public class Watcher extends Thread {

	@Autowired
	private ParserXML parserXML;
	
	public void run() {
		System.out.println("Watcher started");
//		Path myDir = Paths.get("/home/stagiaire/POE/workspace/Mandataire");
//		System.out.println(myDir.toFile().getAbsolutePath());

		try {
//			WatchService watcher = FileSystems.getDefault().newWatchService();
//			WatchService watcher = myDir.getFileSystem().newWatchService();
			
			FileSystem fileSystem = FileSystems.getDefault();
			WatchService watcher = fileSystem.newWatchService();

			Path myDir = fileSystem.getPath("/home/stagiaire/POE/workspace/Mandataire");
			
			myDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE);
			WatchKey watchKey = null;
			for (;;) {
				watchKey = watcher.take();
				List<WatchEvent<?>> events = watchKey.pollEvents();
				for (WatchEvent<?> event : events) {
					if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
						Path path = (Path) event.context();
						String fileName = path.toFile().getPath();
		
						//FORMAT : nomMandataire_jj-mm-yy.xml
						String patternStr = "[a-zA-Z0-9]*_[0-9]{2}\\-[0-9]{2}\\-[0-9]{2}\\.xml";
//						String patternStr = "";
						Pattern pattern = Pattern.compile(patternStr);
						Matcher matcher = pattern.matcher(fileName);
						Boolean matchFound = matcher.find();
						if(matchFound){
							System.out.println("Created: " + event.context().toString());
							parserXML.parseXML(fileName);
						}
						
					}
					
				}
				if (!watchKey.reset()) {
					break;
				}
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
			e.printStackTrace();
		}
	}

}
