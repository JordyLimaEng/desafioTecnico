package com.jordy.desafioTecnico.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jordy.desafioTecnico.Entities.Terminal;
import com.jordy.desafioTecnico.Repositories.TerminalRepository;

@Service
public class TerminalService {
	
	@Autowired
	private TerminalRepository repository;
	
	public List<Terminal> findAll(){
		return repository.findAll();
	}
	
	public Terminal findByLogic(int logic) {
		return repository.findByLogic(logic);		
	}
	
}
