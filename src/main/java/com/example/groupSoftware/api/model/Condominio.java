package com.example.groupSoftware.api.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Condominio {

	@Id
	private String nome;
	
	private String endereco;
	
	@ManyToOne
	@JoinColumn(name = "unidade_id")
	private Unidade unidade;
	
}
