package com.mohamedelsayed.springproject.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Scope("prototype")
@PropertySource("classpath:application.properties")
public class ReadDataFromCSV  extends ReadData{

	
	
	
	
	public ReadDataFromCSV(@Value("${data.ThirdPartyDataStore.location}") String path1, @Value("${data.SingleSourceOfTruthDataStore.location}") 
	String path2, @Value("${data.OraculumDataStore.location}") String path3 ) {
		super(path1, path2, path3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void readThirdPartyDataStore(String path)  {
		try 
		{
			BufferedReader csvReader = new BufferedReader(new FileReader(path));
			String row;
			while ((row = csvReader.readLine()) != null) 
			{
			    String[] _data = row.split(",");
			    int x = Integer.valueOf(_data[0]);
			    System.out.println(x +" "+ _data[1].toUpperCase());

			    data.put(x, new String[]{_data[1].toUpperCase(), "BLUE"});
			}
			csvReader.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		// TODO Auto-generated method stub
	}

	@Override
	public void readSingleSourceOfTruthDataStore(String path) {
		// TODO Auto-generated method stub
		try 
		{
			BufferedReader csvReader = new BufferedReader(new FileReader(path));
			String row;
			while ((row = csvReader.readLine()) != null) 
			{
			    String[] _data = row.split(",");
			    int x = Integer.valueOf(_data[0]);
			    System.out.println(x +" "+ _data[1]);

			    data.put(x, new String[]{_data[1].toUpperCase(), "GREEN"});
			}
			csvReader.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void readOraculumDataStore(String path) {
		// TODO Auto-generated method stub
		try 
		{
			BufferedReader csvReader = new BufferedReader(new FileReader(path));
			String row;
			while ((row = csvReader.readLine()) != null) 
			{
			    String[] _data = row.split(",");
			    int x = Integer.valueOf(_data[0]);
			    System.out.println(x +" "+ _data[1].toUpperCase());

			    data.put(x, new String[]{_data[1].toUpperCase(), "RED"});
			}
			csvReader.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Map<Integer, String[]> getData() {
		// TODO Auto-generated method stub
		return data;
	}
	
	

}
