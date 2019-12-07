package com.airtonlira.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airtonlira.cursomc.domain.Desconto;

@Repository
public interface DescontoRepository extends JpaRepository<Desconto, Integer> {

		
}
