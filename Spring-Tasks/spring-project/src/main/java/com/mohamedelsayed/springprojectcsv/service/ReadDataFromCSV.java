package com.mohamedelsayed.springprojectcsv.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.mohamedelsayed.springprojectcsv.models.DataModel;

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
			    //System.out.println(x +" "+ _data[1].toUpperCase());

			    data.put(x, new DataModel(_data[1].toUpperCase(), "BLUE"));
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
			    //System.out.println(x +" "+ _data[1]);

			    data.put(x, new DataModel(_data[1].toUpperCase(), "GREEN"));
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
			    //System.out.println(x +" "+ _data[1].toUpperCase());

			    data.put(x, new DataModel(_data[1].toUpperCase(), "RED"));
			}
			csvReader.close();
		} 
		catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Map<Integer, DataModel> getData() {
		// TODO Auto-generated method stub
		List<Map.Entry<Integer, DataModel> > list = 
	               new ArrayList<Map.Entry<Integer, DataModel> >(data.entrySet()); 
		Collections.sort(list, new Comparator<Map.Entry<Integer, DataModel> >() { 
            public int compare(Map.Entry<Integer, DataModel> o1,  
                               Map.Entry<Integer, DataModel> o2) 
            { 
            	
                int result = (o1.getValue().getData()).compareTo(o2.getValue().getData()); 
                //System.out.println(o1.getValue()[0]+" "+o2.getValue()[0] + " " +result);
                if(result != 0 )
                	return result;
                return o1.getKey() < o2.getKey()?  -1: 1; 
            } 
        }); 
		Map<Integer, DataModel> temp = new LinkedHashMap<Integer, DataModel>(); 
        for (Entry<Integer, DataModel> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
		return temp;
	}
	
	

}
