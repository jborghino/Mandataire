package fr.treeptik.service.impl;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.treeptik.watcher.Watcher;

@Service
public class WatchServiceImpl {

	@Autowired
	private Watcher watcher;
	@PostConstruct
	
	public void run(){
		watcher.start();
	}
	
	
}
