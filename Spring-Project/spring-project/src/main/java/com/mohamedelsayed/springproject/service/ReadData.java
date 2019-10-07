package com.mohamedelsayed.springproject.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class ReadData {

	protected Map<Integer, String[]> data = new HashMap<Integer, String[]>();
	
	
	public ReadData(String path1, String path2, String path3) 
	{
		readThirdPartyDataStore(path1);
		readSingleSourceOfTruthDataStore(path2);
		readOraculumDataStore(path3);
		
	}
	
	public abstract void readThirdPartyDataStore(String path); 
	public abstract void readSingleSourceOfTruthDataStore(String path);
	public abstract void readOraculumDataStore(String path);

	public abstract Map<Integer, String[]> getData(); 
	
}