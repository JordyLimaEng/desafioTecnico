package com.jordy.desafioTecnico.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jordy.desafioTecnico.Entities.Terminal;
import com.jordy.desafioTecnico.Services.TerminalService;

@RestController
@RequestMapping(value = "/version")
public class TerminalResource {
	
	@Autowired
	private TerminalService service;
	
	@GetMapping(path = "/entityName/logic")
	public ResponseEntity<List<Terminal>> findAllTerminals(){
		List<Terminal> list = service.findAll();
				
		return ResponseEntity.ok().body(list);		
	}
	
	@GetMapping(path = "/entityName/{logic}")
	public ResponseEntity<Terminal> findByLogic(@PathVariable(value = "logic") int logic){
		Terminal t = service.findByLogic(logic);
				
		return ResponseEntity.ok().body(t);		
	}
}
