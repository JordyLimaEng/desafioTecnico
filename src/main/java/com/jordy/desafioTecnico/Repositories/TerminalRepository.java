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
	@Query(value = "UPDATE TERMINAL TM SET "
			+ "TM.SERIAL  = ?2, "
			+ "TM.MODEL   = ?3, "
			+ "TM.SAM     = ?4, "
			+ "TM.PTID    = ?5, "
			+ "TM.PLAT    = ?6, "
			+ "TM.VERSION = ?7, "
			+ "TM.MXR 	  = ?8, "
			+ "TM.MXF     = ?9, "
			+ "TM.VERFM   = ?10 "
			+ "WHERE TM.LOGIC = ?1", nativeQuery = true)
	public void updateTerminal(int logic, String serial, String model, int sam, String ptid, int plat,
			String version, int mxr, int mxf, String VERFM);
}
