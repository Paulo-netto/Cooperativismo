package com.br.cooperativismo.domain.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sessao")
public class Sessao {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sessao_id")
	private Long id;
	
	@OneToOne()
	@JoinColumn(name = "pauta_id")
	private Pauta pauta;
	
	private LocalDateTime tempoInicial;

	private LocalDateTime tempoFinal;

}
