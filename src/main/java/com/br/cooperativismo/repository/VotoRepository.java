package com.br.cooperativismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.cooperativismo.domain.model.TipoVotacaoPauta;
import com.br.cooperativismo.domain.model.Voto;

@Repository
public interface VotoRepository extends JpaRepository<Voto, Long> {
	


}
