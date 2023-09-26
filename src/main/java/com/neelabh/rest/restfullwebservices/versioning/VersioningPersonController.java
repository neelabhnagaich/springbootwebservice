package com.neelabh.rest.restfullwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {

	@GetMapping("/v1/person")
	public Personv1 getPersonv1() {
		return new Personv1("Neelabh");
	}
	
	@GetMapping("/v2/person")
	public Personv2 getPersonv2() {
		return new Personv2( new Name("Neel", "nagaich"));
	}
	
	@GetMapping(path="/person", params="version=1")
	public Personv1 getFirstVersionOfPersonWithRequestparam() {
		return new Personv1("Name with req param");
	}
	
	@GetMapping(path="/person", params="version=2")
	public Personv2 getSecondVersionOfPersonWithRequestparam() {
		return new Personv2( new Name("Ashis", "shukla"));
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=1")
	public Personv1 getFirstVersionOfPersonWithRequestHeader() {
		return new Personv1("Bob vishwas");
	}
	
	@GetMapping(path="/person/header", headers="X-API-VERSION=2")
	public Personv2 getSecondVersionOfPersonWithRequestHeader() {
		return new Personv2( new Name("Aamir", "suhel"));
	}
	
	@GetMapping(path="/person/header", produces="application/vnd.company.app-v1+json")
	public Personv1 getFirstVersionOfPersonWithAcceptHeader() {
		return new Personv1("Bob vishwas");
	}
	
	@GetMapping(path="/person/header", produces="application/vnd.company.app-v2+json")
	public Personv2 getSecondVersionOfPersonWithAcceptHeader() {
		return new Personv2( new Name("Aamir", "suhel"));
	}
	


}
