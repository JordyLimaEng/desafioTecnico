package com.jordy.desafioTecnico.Config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jordy.desafioTecnico.Entities.Terminal;
import com.jordy.desafioTecnico.Repositories.TerminalRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private TerminalRepository terminalRepository;

	@Override
	public void run(String... args) throws Exception {
		
		Terminal t1 = new Terminal(null,44332211, "123", "PWWIN", 0, "F04A2E4088B", 4, "8.00b3", 0, 16777216, "PWWIN");
		Terminal t2 = new Terminal(null,22334411, "143", "PWWIN", 0, "F04AE@w!88B", 4, "8.00b3", 0, 16775316, "PWWIN");
		Terminal t3 = new Terminal(null,55332233, "523", "PWWIN", 0, "F2S3AE4088B", 4, "8.00b3", 0, 16221216, "PWWIN");
	
		terminalRepository.saveAll(Arrays.asList(t1,t2,t3));
	}
	
	
}
