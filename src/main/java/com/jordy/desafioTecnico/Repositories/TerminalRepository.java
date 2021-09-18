package com.jordy.desafioTecnico.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jordy.desafioTecnico.Entities.Terminal;

public interface TerminalRepository extends JpaRepository<Terminal, Long>{
	
	@Query(
			value = "SELECT * FROM TERMINAL TM WHERE TM.LOGIC = ?1",
			nativeQuery = true)
	public Terminal findByLogic(int logic);
}
