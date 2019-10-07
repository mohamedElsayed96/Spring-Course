package com.mohamedelsayed.springproject.controllers;

import java.util.Map;

import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohamedelsayed.springproject.service.ReadData;


@RestController
public class DataApi {

	
	private ReadData readData;
	@Autowired
	public DataApi(ReadData readData) {
		this.readData = readData;
	}


	@GetMapping("/data")
	public Map<Integer, String[]> getData()
	{

		return readData.getData();
	}
}
