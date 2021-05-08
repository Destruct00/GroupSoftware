package com.example.groupSoftware.api.resource;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.groupSoftware.api.model.Morador;
import com.example.groupSoftware.api.repository.MoradorRepository;

@RestController
@RequestMapping("/morador")
public class MoradorResource {

	@Autowired
	private MoradorRepository moradorRepository;
	
	@GetMapping()
	public List<Morador> listarMorador(){
		return moradorRepository.findAll();
	}
	

	@PostMapping()
	public ResponseEntity<Morador> CriarMorador(@RequestBody Morador morador, HttpServletResponse response) {
		Morador moradorSalvo = moradorRepository.save(morador);
		return ResponseEntity.status(HttpStatus.OK).body(moradorSalvo);
	}
}
