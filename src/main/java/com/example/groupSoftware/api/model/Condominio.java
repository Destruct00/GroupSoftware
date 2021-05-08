package com.example.groupSoftware.api.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class Condominio {

	@Id
	private String nome;
	
	private String endereco;
	
	@OneToMany
	@JoinColumn(name = "unidade_id")
	private List<Unidade> unidade;
	
}
