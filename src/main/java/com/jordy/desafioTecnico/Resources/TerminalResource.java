package com.jordy.desafioTecnico.Resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.jordy.desafioTecnico.DTO.TerminalDTO;
import com.jordy.desafioTecnico.Entities.Terminal;
import com.jordy.desafioTecnico.Services.TerminalService;

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

	@PostMapping(path = "/${resource.entity}")
	public ResponseEntity<TerminalDTO> addTerminal(
			@RequestHeader(name="content-type", required = true) MediaType v,
			@RequestBody String t) {
		
		if(v.toString().equals("text/html;charset=utf-8")) {
			String[] campos = t.split(";");
			TerminalDTO tDTO = new TerminalDTO(
					Integer.parseInt(campos[0]), 
					campos[1], 
					campos[2], 
					Integer.parseInt(campos[3]), 
					campos[4], 
					Integer.parseInt(campos[5]), 
					campos[6], 
					Integer.parseInt(campos[7]), 
					Integer.parseInt(campos[8]), 
					campos[9]);
			Terminal terminalSave = new Terminal(null, tDTO);
			service.addTerminal(terminalSave);			
			return ResponseEntity.ok().body(tDTO);
		}
		return null;
	}

}
