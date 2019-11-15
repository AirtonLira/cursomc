package com.airtonlira.cursomc.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airtonlira.cursomc.domain.Pedido;;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

		
}
