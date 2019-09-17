package com.howtodoinjava.rest.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import cz.cvut.kbss.jsonld.JsonLd;

@RestController
@RequestMapping(path = "/norrskenAdmin")
public class NorrskenAdminController {
	
	
	String accessToken ="Bearer eyJhbGciOiJSUzI1NiIsInR5cCI6IkpXVCIsImtpZCI6ImVlOTA2NzM4LWMwN2EtNGE4My1iMTMzLThjMjEyMjFmOWYyNSJ9.eyJ1c2VyX25hbWUiOiJub3Jyc2tlbm5vdGlmeWJ5NF9hZG1pbiIsInNjb3BlIjpbIkNBRE1JTiIsImZhIl0sImNvbXBhbnlfZ2xvYmFsbHlfdW5pcXVlX2lkIjoiaHR0cHM6Ly9vbmJvYXJkLmNsYy5lcmljc3Nvbi5uZXQvbm9ycnNrZW5ub3RpZnlieTQiLCJpc19wYXNzd29yZF9jaGFuZ2VfbmVlZGVkIjpmYWxzZSwiZXhwIjoxNTY4ODAxMTU3LCJhdXRob3JpdGllcyI6WyJTWU5DX01BTkFHRU1FTlQiLCJSRVNFVF9QV0QiLCJSRUFEX1JPTEUiLCJDUkVBVEUiLCJSRUFEX0lTU1VFIiwiVVBEQVRFX0FDQ09VTlQiLCJSRUFEX0ZJTFRFUiIsIlJFQURfVklFV19DT05GSUdVUkFUSU9OIiwiUkVBRF9TRUFSQ0giLCJVUERBVEVfSVNTVUUiLCJSRUFEX0lTU1VFX1NUQVRVUyIsIlJFQURfTUFQIiwiREVMRVRFIiwiUkVBRF9DT01QQU5ZIiwiQ1JFQVRFX0lTU1VFIiwiVVBEQVRFX0FDQ09VTlRfTElTVF9WSUVXX0NPTkZJR1VSQVRJT04iLCJMT0dJTiIsIlJFQURfVFJFRSIsIkRFTEVURV9GSUxURVIiLCJSRUFEX0lTU1VFX1RZUEUiLCJSRUFEX0xJU1QiLCJSRUFEX0xPR0lTVElDU19PQkpFQ1RTX0NSRUFURUQiLCJERUxFVEVfSVNTVUUiLCJSRUFEX0FDQ09VTlQiLCJSRUFEX0RFVEFJTFMiLCJSRUFEX0lTU1VFX1NFVkVSSVRZIiwiREVMRVRFX0FDQ09VTlQiLCJSRUFEIiwiVVBEQVRFX1ZJRVdfQ09ORklHVVJBVElPTiIsIkNSRUFURV9GSUxURVIiLCJSRUFEX1NVQlNDUklQVElPTlMiLCJDUkVBVEVfQUNDT1VOVCIsIlJFQURfQUNDT1VOVFMiLCJSRUFEX1RJTUVMSU5FIiwiVVBEQVRFX1BXRCJdLCJqdGkiOiIzNjhmY2IxNy1mZTRmLTQwNjItYmU2Mi03ODA3YTljNjQyYWEiLCJjbGllbnRfaWQiOiJmYS1jbGllbnQifQ.JRzS7G5lFm1gfsLIqT9rGYd1tqOBX3X96iCeAHzPd4EwDC8iKdGjZMCLhovdjECeyi71of8p-tq4iOKLgyFcIXb99ynAH-c3QTKEg6h0G_zUl95YW-JVBZ0bCZLguyKboyR7wOu9rjHyFfzxsrFZVZX3aj199oJvnrJLAPCkJ3bxRHwZHmfB2GGQIAWyNy4o4Ovhd-hty2Q4U1j3CVLk-aWDZRPnxKrWySA0O26JonPPH6hp7t8etmHKxMpcVhG5WiySlbvZOFHuykTLWeRn1Zn9o44w3XWYCAcCCisMXXkrFCdmstkOridLjQdsj5IwlxuAErv5xFMW9kOjqaTIlg";
	
	
	
	
	 @GetMapping(path="/loginByNorrskenAdmin", produces = "JsonLd.MEDIA_TYPE , application/json")
	    public NorrskenAdminLoginResponse getAccessToken() 
	    {
		 RestTemplate restTemplate = new RestTemplate();
		 
		 HttpHeaders headers = new HttpHeaders();
		 List<MediaType> list = new ArrayList<>();
		// list.add(JsonLd.MEDIA_TYPE);
		//headers.setAccept(acceptableMediaTypes);
		 NorrskenAdminLoogin norrskenAdminLoogin = new NorrskenAdminLoogin();
		 norrskenAdminLoogin.setUsername("norrskensup4_admin");
		 norrskenAdminLoogin.setPassword("norrskenAdminLoogin");
		 
		 Gson gson = new Gson();
		 gson.toJson(norrskenAdminLoogin);
		 
		 HttpEntity<String> request = new HttpEntity<String>( gson.toJson(norrskenAdminLoogin).toString(), headers);
		 
		 NorrskenAdminLoginResponse response =	 restTemplate.postForObject("https://onboard.clc.ericsson.net/userservice/login", request, NorrskenAdminLoginResponse.class);
		
		 accessToken =  response.getAccess_token();
		 System.out.println(" response :: " + response.getAccess_token());
		 
		 return response;
	    }
	
	

}
