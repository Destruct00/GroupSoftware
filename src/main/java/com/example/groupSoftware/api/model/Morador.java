package com.example.groupSoftware.api.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Data;

@Entity
@Data
public class Morador {

	@Id
	private String nomeESobrenome;
	
	@OneToOne
	@JoinColumn(name = "unidade_id")
	private Unidade unidade;
	
}
