package com.corecomets.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//@JsonIgnoreProperties(value = {"someField2","someField3"}) // This is another way to filter out the fields from the response. But in a very static way. Called as static filtering 
@JsonFilter("DummyBeanFilter")
public class DummyBean {
	
	private String someField1;
	private String someField2;
	
	//@JsonIgnore // This will filter out this field while sending in response.
	private String someField3;
	
	
	public DummyBean(String someField1, String someField2, String someField3) {
		super();
		this.someField1 = someField1;
		this.someField2 = someField2;
		this.someField3 = someField3;
	}


	public String getSomeField1() {
		return someField1;
	}


	public void setSomeField1(String someField1) {
		this.someField1 = someField1;
	}


	public String getSomeField2() {
		return someField2;
	}


	public void setSomeField2(String someField2) {
		this.someField2 = someField2;
	}


	public String getSomeField3() {
		return someField3;
	}


	public void setSomeField3(String someField3) {
		this.someField3 = someField3;
	}

	
}
