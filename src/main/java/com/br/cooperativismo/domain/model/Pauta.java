package com.br.cooperativismo.domain.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pauta")
public class Pauta {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pauta_id")
	private Long id;
	
	
	private String descricao;
	
	@OneToOne(mappedBy = "pauta")
	private Sessao sessao;
	

	
	
}
