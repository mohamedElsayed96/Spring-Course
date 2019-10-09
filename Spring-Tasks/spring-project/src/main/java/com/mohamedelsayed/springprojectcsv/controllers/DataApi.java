package com.mohamedelsayed.springprojectcsv.controllers;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohamedelsayed.springprojectcsv.models.DataModel;
import com.mohamedelsayed.springprojectcsv.service.ReadData;


@RestController
@Scope("prototype")
public class DataApi {

	
	private ReadData readData;
	@Autowired
	public DataApi(ReadData readData) {
		this.readData = readData;
	}


	@GetMapping("/data")
	public Set<Entry<Integer, DataModel>> getData()
	{

		return readData.getData().entrySet();
	}
}
