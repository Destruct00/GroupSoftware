package com.example.groupSoftware.api.resource;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.groupSoftware.api.model.Condominio;
import com.example.groupSoftware.api.repository.CondominioRepository;


@RestController
@RequestMapping("/condominio")
public class CondominioResource {
	@Autowired
	private CondominioRepository condominioRepository;
	
	@GetMapping
	public List<Condominio> listarCondominios(){
		return condominioRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> buscarProdutoId(@PathVariable String id){
		Optional<Condominio> condominio = condominioRepository.findById(id);
		return condominio.isPresent() ? ResponseEntity.ok(condominio) : ResponseEntity.notFound().build() ;
	}
	
	@PostMapping()
	public ResponseEntity<Condominio> CriarMorador(@RequestBody Condominio condominio, HttpServletResponse response) {
		Condominio condominioSalvo = condominioRepository.save(condominio);
		return ResponseEntity.status(HttpStatus.OK).body(condominioSalvo);
	}
}
