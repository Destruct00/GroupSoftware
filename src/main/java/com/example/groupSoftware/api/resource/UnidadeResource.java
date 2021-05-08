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
import com.example.groupSoftware.api.model.Unidade;
import com.example.groupSoftware.api.repository.UnidadeRepository;

@RestController
@RequestMapping("/unidade")
public class UnidadeResource {

	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@GetMapping()
	public List<Unidade> listarUnidade(){
		return unidadeRepository.findAll();
	}
	
	@PostMapping()
	public ResponseEntity<Unidade> CriarUnidade(@RequestBody Unidade unidade, HttpServletResponse response) {
		Unidade unidadeSalvo = unidadeRepository.save(unidade);
		return ResponseEntity.status(HttpStatus.OK).body(unidadeSalvo);
	}
}
