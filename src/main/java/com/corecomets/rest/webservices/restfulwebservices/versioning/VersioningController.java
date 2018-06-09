package com.corecomets.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

//------------------------------------------------------------------------------------------------------------------------//
	//URI VERSIONING
	//eg : Twitter 
	// Pollutes URI space, 
//------------------------------------------------------------------------------------------------------------------------//
	@GetMapping("v1/person")
	public PersonV1 personV1() {
		return new PersonV1("Goldie Lock");
	}
	
	@GetMapping("v2/person")
	public PersonV2 personV2() {
		return new PersonV2(new Name ("Goldie", "Lock"));
	}
	
	
//------------------------------------------------------------------------------------------------------------------------//
	//REQUEST PARAM VERSIONING
	//eg : Amazon
	// Pollutes URI  space
	// Pollutes URI space, Cannot be executed on browser
//------------------------------------------------------------------------------------------------------------------------//

	// Versioning using Request Parameters --> eg. /person/param?version=1
	@GetMapping(value="/person/param", params = "version=1")
	public PersonV1 paramV1() {
		return new PersonV1("Goldie Lock");
	}
	
	// Versioning using Request Parameters --> eg. /person/param?version=1
	@GetMapping(value="/person/param", params = "version=2")
	public PersonV2 paramV2() {
		return new PersonV2(new Name ("Goldie", "Lock"));
	}
	
	
//------------------------------------------------------------------------------------------------------------------------//
	//HEADER VERSIONING
	// eg : Microsoft
	// Missuse of http headers. HTTP headers are never intended for versioning
	// Cannot be suitable for cahing, As the versioning is using headers its not possible for maintaining cahing
	// Cannot be executed on browser
//------------------------------------------------------------------------------------------------------------------------//

	// Versioning using HEADERS 
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public PersonV1 headerV1() {
		return new PersonV1("Goldie Lock");
	}
	
	// Versioning using HEADERS 
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public PersonV2 headerV2() {
		return new PersonV2(new Name ("Goldie", "Lock"));
	}
	
	
//------------------------------------------------------------------------------------------------------------------------//
	//PRODUCERS VERSIONING : Also Called as Content Negotiation or Accept Versioning or MIME Type Versioning
	//eg : GitHub
	// Missuse of http headers. HTTP headers are never intended for versioning
	// Cannot be suitable for cahing, As the versioning is using headers its not possible for maintaining cahing
	// Cannot be executed on browser
//------------------------------------------------------------------------------------------------------------------------//

	// Versioning using HEADERS 
	@GetMapping(value="/person/produces", produces = "application/vnd.company.app-v1+json")
	public PersonV1 producesV1() {
		return new PersonV1("Goldie Lock");
	}
	
	//PRODUCERS VERSIONING : Also Called as Content Negotiation or Accept Versioning
	@GetMapping(value="/person/produces", produces = "application/vnd.company.app-v2+json")
	public PersonV2 producesV2() {
		return new PersonV2(new Name ("Goldie", "Lock"));
	}
//------------------------------------------------------------------------------------------------------------------------//
	
	
}
