package com.mohamedelsayed.userregister.feignproxies;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mohamedelsayed.userregister.models.ResponseModel;

@FeignClient(name = "zuul-api-gateway")
public interface RandomStringProxy {

	@GetMapping("/random-generation-service/random-string/{count}")
	public ResponseModel getRandomString(@PathVariable int count);
}
