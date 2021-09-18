package com.jordy.desafioTecnico.Resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jordy.desafioTecnico.entities.Terminal;

@RestController
@RequestMapping(value = "/version/entityName/logic")
public class TerminalResource {
	
	@GetMapping
	public ResponseEntity<Terminal> findByLogic(){
		
		Terminal t = new Terminal(44332211, "123", "PWWIN", 0, "F04A2E4088B", 4, "8.00b3", 0, 16777216, "PWWIN");
		
		return ResponseEntity.ok().body(t);
		
	}
}
