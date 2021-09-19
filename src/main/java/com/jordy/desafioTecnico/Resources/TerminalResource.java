package com.jordy.desafioTecnico.Resources;

import java.io.InputStream;
import java.util.List;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.jordy.desafioTecnico.DTO.TerminalDTO;
import com.jordy.desafioTecnico.Entities.Terminal;
import com.jordy.desafioTecnico.Services.TerminalService;
import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;
import com.networknt.schema.SpecVersion;
import com.networknt.schema.ValidationMessage;

@RestController
@Validated
@RequestMapping(path = "/${api.version}")
public class TerminalResource {

	@Autowired
	private TerminalService service;

	@GetMapping(path = "/Terminals") // extra
	public ResponseEntity<List<Terminal>> findAllTerminals() {
		List<Terminal> list = service.findAll();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping(path = "/${resource.entity}/{logic}")
	public ResponseEntity<Terminal> findByLogic(@PathVariable(value = "logic") int logic) {
		Terminal t = service.findByLogic(logic);

		return ResponseEntity.ok().body(t);
	}

	@PostMapping(path = "/${resource.entity}", consumes = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<?> SaveWithValidationSchema(@RequestBody String reqStr) throws JsonProcessingException {
		System.out.println("Request Json String" + reqStr);
		
		InputStream schemaAsStream = TerminalResource.class.getClassLoader().getResourceAsStream("terminal.schema.json");
		JsonSchema schema = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V7).getSchema(schemaAsStream);
		
		JSONObject jsonReqStr = returnReqAsJson(reqStr);
		
		ObjectMapper om = new ObjectMapper();
		om.setPropertyNamingStrategy(PropertyNamingStrategy.KEBAB_CASE);
		JsonNode jsonNode = om.readTree(jsonReqStr.toString());
		
		Set<ValidationMessage> errors = schema.validate(jsonNode);
        String errorsCombined = "";
        for (ValidationMessage error : errors) {
            System.out.println("Validation Error: "+ error);
            errorsCombined += error.toString() + "\n";
        }

        if (errors.size() > 0) {
        	return ResponseEntity.badRequest().body("Please fix your entry!\n " + errorsCombined);
        }
		
        Terminal terminalSave = new Terminal(null, jsonReqStr);
		service.addTerminal(terminalSave);
		
		return ResponseEntity.ok().body(jsonReqStr.toString());
	}
	
	JSONObject returnReqAsJson(String req) {			
		String campos[] = req.split(";");
		JSONObject objJson = new JSONObject();
						
		if(!campos[0].equals("")) {
			objJson.put("logic", Integer.parseInt(campos[0]));			
		}
		if(!campos[1].equals("")) {
			objJson.put("serial", campos[1]);			
		}
		if(!campos[2].equals("")) {
			objJson.put("model", campos[2]);			
		}
		if(!campos[3].equals("")) {
			objJson.put("sam", Integer.parseInt(campos[3]));			
		}
		if(!campos[4].equals("")) {
			objJson.put("ptid", campos[4]);			
		}
		if(!campos[5].equals("")) {
			objJson.put("plat", Integer.parseInt(campos[5]));			
		}
		if(!campos[6].equals("")) {
			objJson.put("version", campos[6]);			
		}
		if(!campos[7].equals("")) {
			objJson.put("mxr", Integer.parseInt(campos[7]));			
		}
		if(!campos[8].equals("")) {
			objJson.put("mxf", Integer.parseInt(campos[8]));			
		}
		if(!campos[9].equals("")) {
			objJson.put("VERFM", campos[9]);			
		}
		
		return objJson;
	}

}
