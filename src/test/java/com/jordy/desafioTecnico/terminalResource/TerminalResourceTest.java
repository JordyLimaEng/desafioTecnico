package com.jordy.desafioTecnico.terminalResource;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static io.restassured.module.mockmvc.RestAssuredMockMvc.standaloneSetup;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.jordy.desafioTecnico.Entities.Terminal;
import com.jordy.desafioTecnico.Exceptions.ResourceAlredyExists;
import com.jordy.desafioTecnico.Exceptions.ResourceCantBeUpdated;
import com.jordy.desafioTecnico.Exceptions.ResourceNotFoundException;
import com.jordy.desafioTecnico.Exceptions.ResourceNotValid;
import com.jordy.desafioTecnico.Repositories.TerminalRepository;
import com.jordy.desafioTecnico.Resources.TerminalResource;
import com.jordy.desafioTecnico.Resources.Exceptions.ResourceExceptionHandler;
import com.jordy.desafioTecnico.Resources.Exceptions.StandardError;
import com.jordy.desafioTecnico.Services.TerminalService;

import io.restassured.http.ContentType;

@WebMvcTest
public class TerminalResourceTest {
	
	@Autowired
    private MockMvc mockMvc; 
	
	@Autowired
	private TerminalResource terminalResource;
	
	@MockBean
	private TerminalService terminalService;
	
	@MockBean
	private TerminalRepository terminalRepository;
	
	@MockBean
	private ResourceNotFoundException resourceNotFoundException;
	
	@MockBean
	private ResourceCantBeUpdated resourceCantBeUpdated;
	
	@MockBean
	private ResourceAlredyExists resourceAlredyExists;
	
	@MockBean
	private ResourceNotValid resourceNotValid;
	
	@MockBean
	private ResourceExceptionHandler resourceExceptionHandler;
	
	@MockBean
	private StandardError standardError;
	
	@BeforeEach
	public void setup() {
		standaloneSetup(this.terminalResource, this.resourceExceptionHandler,
						this.resourceNotFoundException);
	}
	
	//Não consegui fazer passar o teste com minha exceção personalizada
	// no entanto, se colocar nos métodos do resource o formato: (o teste passa). 
	//		if(t == null) {
	//			return ResponseEntity.notFound().build();
	//		}
	
	@Test //pass
	public void deveRetornarSucesso_QuandoBuscarTerminal() {		
		when(this.terminalService.findByLogic(44332211))
				.thenReturn(new Terminal(1L,44332211, "523", "PWWIN", 0, "F2S3AE4088B", 4, "8.00b3", 0, 16221216, "PWWIN"));
		
		given()
				.accept(ContentType.JSON)
			.when()
				.get("/1.0.0/Terminal/{logic}", 44332211)
			.then()
				.statusCode(org.springframework.http.HttpStatus.OK.value());
	}
	
	@Test //pass
	public void deveRetornarNaoEncontrado_QuandoBuscarTerminal(){	
		when(this.terminalService.findByLogic(1))
				.thenReturn(null);		
		
		given()
				.accept(ContentType.JSON)
			.when()
				.get("/1.0.0/Terminal/{logic}", 1)
			.then()
				.statusCode(org.springframework.http.HttpStatus.NOT_FOUND.value());
	}
	
	@Test //pass
	public void deveRetornarMediaNaoSuportada_QuandoSalvarTerminal() throws Exception{	
		RequestBuilder req = MockMvcRequestBuilders
				.post("/1.0.0/Terminal")
				.accept(MediaType.TEXT_HTML)
				.content("{\n"
						+ "    \"serial\": \"123\",\n"
						+ "    \"mxr\": 2,\n"
						+ "    \"verfm\": \"PWWAN\",\n"
						+ "    \"model\": \"SADAS\",\n"
						+ "    \"mxf\": 16777216,\n"
						+ "    \"logic\": 11445577,\n"
						+ "    \"ptid\": \"F0dasd88B\",\n"
						+ "    \"plat\": 123123,\n"
						+ "    \"version\": \"8.00b3\",\n"
						+ "    \"sam\": 0\n"
						+ "}")
				.contentType(MediaType.APPLICATION_JSON);
				
		MvcResult res = mockMvc.perform(req)
                .andExpect(status().isUnsupportedMediaType())
                .andReturn();		
	}
	
	@Test //not pass
	public void deveRetornarCreated_QuandoSalvarTerminal() throws Exception{	
		RequestBuilder req = MockMvcRequestBuilders
				.post("/1.0.0/Terminal")
				.accept(MediaType.TEXT_HTML)
				.content("99885500;234;PWWIN;23;D25C23ER21B;4;8.00b3;0;15127973;PWWIN")
				.contentType(MediaType.TEXT_HTML);
				
		MvcResult res = mockMvc.perform(req)
                .andExpect(status().isCreated())
                .andReturn();
	}
	
	@Test //pass
	public void deveRetornarMediaNaoSuportada_QuandoAtualizarTerminal() throws Exception{	
		RequestBuilder req = MockMvcRequestBuilders
				.put("/1.0.0/Terminal/11223344")
				.accept(MediaType.APPLICATION_JSON)
				.content("99885500;234;PWWIN;23;D25C23ER21B;4;8.00b3;0;15127973;PWWIN")
				.contentType(MediaType.TEXT_HTML);
				
		MvcResult res = mockMvc.perform(req)
                .andExpect(status().isUnsupportedMediaType())
                .andReturn();
	}
}










