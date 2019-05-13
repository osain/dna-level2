package com.example.dna.controller;

import java.security.Principal;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.dna.service.DnaService;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@RestController
@CrossOrigin
@RequestMapping(value="/")
public class MainController {
	private static final JsonParser jsonParser = new JsonParser();
	
	@PostMapping(value="mutation")
	@ResponseBody
	@SuppressWarnings("rawtypes")
	public ResponseEntity dnaMutation(@RequestBody String string, Principal principal) {
		JsonObject json = jsonParser.parse(string).getAsJsonObject();
		JsonArray array = json.get("dna").getAsJsonArray();
		String[] dna = new String[array.size()];
		int idx = 0;
		for(JsonElement elm : array) {
			dna[idx++] = elm.getAsString();
		}
		ResponseEntity response = null;
		if(new DnaService().hasMutation(dna)) {
			response = new ResponseEntity(HttpStatus.OK);
		} else {
			response = new ResponseEntity(HttpStatus.FORBIDDEN);
		}
		return(response);
	}
	
	@GetMapping(value="status")
	@ResponseBody
	public String checkStatus() {
		return("ok");
	}
	
}
