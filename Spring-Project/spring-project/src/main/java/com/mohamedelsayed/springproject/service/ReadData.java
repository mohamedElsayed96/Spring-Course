package com.mohamedelsayed.springproject.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.mohamedelsayed.springproject.models.DataModel;

public abstract class ReadData {

	protected Map<Integer, DataModel> data = new HashMap<Integer, DataModel>();
	
	
	public ReadData(String path1, String path2, String path3) 
	{
		readThirdPartyDataStore(path1);
		readSingleSourceOfTruthDataStore(path2);
		readOraculumDataStore(path3);
		System.out.println("an Object created");
	}
	
	public abstract void readThirdPartyDataStore(String path); 
	public abstract void readSingleSourceOfTruthDataStore(String path);
	public abstract void readOraculumDataStore(String path);

	public abstract Map<Integer, DataModel> getData(); 
	
}