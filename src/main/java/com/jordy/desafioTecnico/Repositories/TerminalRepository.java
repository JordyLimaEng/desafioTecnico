package com.jordy.desafioTecnico.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jordy.desafioTecnico.Entities.Terminal;

public interface TerminalRepository extends JpaRepository<Terminal, Long>{
	
	@Query(value = "SELECT * FROM TERMINAL TM WHERE TM.LOGIC = ?1", nativeQuery = true)
	public Terminal findByLogic(int logic);
	
	
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query(value = "UPDATE TERMINAL SET "
			+ "SERIAL  = ?2, "
			+ "MODEL   = ?3, "
			+ "SAM     = ?4, "
			+ "PTID    = ?5, "
			+ "PLAT    = ?6, "
			+ "VERSION = ?7, "
			+ "MXR 	  = ?8, "
			+ "MXF     = ?9, "
			+ "VERFM   = ?10 "
			+ "WHERE LOGIC = ?1", nativeQuery = true)
	public void updateTerminal(int logic, String serial, String model, int sam, String ptid, int plat,
			String version, int mxr, int mxf, String VERFM);
}
