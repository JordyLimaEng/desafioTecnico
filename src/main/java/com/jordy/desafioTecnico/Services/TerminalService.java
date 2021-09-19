package com.jordy.desafioTecnico.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordy.desafioTecnico.Entities.Terminal;
import com.jordy.desafioTecnico.Exceptions.ResourceAlredyExists;
import com.jordy.desafioTecnico.Exceptions.ResourceNotFoundException;
import com.jordy.desafioTecnico.Repositories.TerminalRepository;

@Service
public class TerminalService {
	
	@Autowired
	private TerminalRepository repository;
	
	public List<Terminal> findAll(){
		return repository.findAll();
	}
	
	public Terminal findByLogic(int logic) {
		Terminal response = repository.findByLogic(logic);
		if(response != null) {
			return response;
		}else{
			throw new ResourceNotFoundException(logic);
		}
	}
	
	public Terminal addTerminal(Terminal t) {
		Terminal getTerminal = repository.findByLogic(t.getLogic());
		
		if(getTerminal != null) {
			throw new ResourceAlredyExists(t.getLogic());
		}
		
		return repository.save(t);
	}
	
	public Terminal updateTerminal(int logic, String serial, String model, int sam, String ptid, int plat,
			String version, int mxr, int mxf, String VERFM) {
		repository.updateTerminal(logic, serial, model, sam, ptid, plat, version, mxr, mxf, VERFM);
		Long id = repository.findByLogic(logic).getId();
		return repository.getById(id);
	}
	
}
