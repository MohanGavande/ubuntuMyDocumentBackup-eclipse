package com.mohan.microservices.limitsservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mohan.microservices.limitsservice.bean.LimitConfiguration;

@RestController
public class LimitConfigurationController {
	
	@GetMapping(path="/limits")
	public LimitConfiguration retrivaLimitsFromConfigurations() {
		
		return new LimitConfiguration(1000,1);
	}

}
