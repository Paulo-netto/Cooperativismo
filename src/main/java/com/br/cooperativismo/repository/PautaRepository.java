package com.br.cooperativismo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.cooperativismo.domain.model.Pauta;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Long>{

}
